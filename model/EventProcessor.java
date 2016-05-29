package model;

import java.time.LocalDateTime;
import java.util.List;

import model.employees.Employee;
import model.events.BusinessEvent;
import model.events.CustPriceChangeEvent;
import model.events.MailProcessEvent;
import model.events.RouteAdditionEvent;
import model.events.RouteDiscEvent;
import model.events.TransportCostChangeEvent;
import model.map.*;
import storage.DataStore;

/**
 *
 * This Class processes events requested by the controller, and directed through
 * the KPSmartModel Class. Any changes to the SiteMap data that are required by
 * the events are made here. The appropriate business event object is made as
 * record of each event, and these events are pushed to the DataStore for
 * storage (and retrieval if a request to review events is made from the
 * controller)
 *
 * @author Nic, Joely
 *
 *
 *
 *         Implement Class Methods.
 *
 *         If this current implementation does not work, We are always able to
 *         copy functionality methods INSIDE EventProcessor into the
 *         KPSmartModel
 *
 *
 */
public class EventProcessor {

	public static String debuggingString = "Class EventProcessor";
	public static int debuggingInt = 0;

	public final DataStore db;

	public EventProcessor(DataStore db) {
		this.db = db;
	}

	/*
	 * =========================================================================
	 * START OF Methods to process events
	 * =========================================================================
	 */
	public boolean processMail(int originID, String origin, int destinationID, String destination, double weight,
			double volume, Priority priority, int employeeID) {
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		int time = now.getHour() * 10 + now.getMinute();
		// staff that is logged in
		Employee employee = db.getEmployees().getEmployeeFromID(employeeID);
		String employeeName;
		if (employee == null) {
			// TODO: Change to error when log in works
			employeeName = "no-one";
		} else {
			employeeName = employee.getName();
		}

		List<Integer> compoundRoutes = db.getSiteMap().findCompoundRoute(originID, destinationID, priority);
		// need to check that a compound route was available - if it wasn't, the
		// event fails! if no route was available, compound route will be null
		if (compoundRoutes == null) {
			return false;
		}

		// find the business figures TODO: maybe store them somewhere for the
		// view key figures part?
		double revenue = findRevenue(compoundRoutes, weight, volume);
		double expenditure = findExpenditure(compoundRoutes, weight, volume);
		double deliveryTime = findDeliveryTime(compoundRoutes);

		// make the event to record the action
		BusinessEvent mailProcessEvent = new MailProcessEvent(day, month, year, time, employeeName, origin, destination,
				weight, volume, priority, revenue, expenditure, deliveryTime);
		// store the event in the data store
		db.addEvent(mailProcessEvent);
		return true;
	}

	/**
	 * @param origin
	 *            - string
	 * @param destination
	 *            - string
	 * @param carrier
	 *            - string
	 * @param type
	 *            - Type enum (mode of transport - AIR, SEA, LAND
	 * @param duration
	 *            - double, hours of travel time when this route is taken
	 * @param custPriceWeight
	 *            - double, price charged to customer per gram of weight
	 * @param custPriceVolume
	 *            - double, price charged to customer per cubic cm of volume
	 * @param transCostWeight
	 *            - double, cost that KPS incurs from transport company, per
	 *            gram of weight
	 * @param transCostVolume
	 *            - double, cost that KPS incurs from transport company, per
	 *            cubic cm of volume
	 * @param employeeID
	 *            - int, id of staff that was logged into the system when event
	 *            was generated
	 */
	public boolean addRoute(String origin, String destination, String company, Type type, double duration,
			double custPriceWeight, double custPriceVolume, double transCostWeight, double transCostVolume,
			int employeeID) {
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		int time = now.getHour() * 10 + now.getMinute();
		// staff that is logged in
		Employee employee = db.getEmployees().getEmployeeFromID(employeeID);
		String employeeName;
		if (employee == null) {
			// TODO: Change to error when log in works
			employeeName = "no-one";
		} else {
			employeeName = employee.getName();
		}

		// capitalise the names
		origin = SiteMap.uniformPrint(origin);
		destination = SiteMap.uniformPrint(destination);

		// Tell sitemap to add the new route with the information. Fail if the
		// route cannot be added
		if (!db.getSiteMap().addNewRoute(origin, destination, company, type, duration, custPriceWeight, custPriceVolume,
				transCostWeight, transCostVolume)) {
			return false;
		}

		// make the event to record the action
		BusinessEvent addRouteEvent = new RouteAdditionEvent(day, month, year, time, employeeName, origin, destination,
				company, type, duration, custPriceWeight, custPriceVolume, transCostWeight, transCostVolume);
		// store the event in the data store
		db.addEvent(addRouteEvent);
		return true;
	}

	public boolean disconRoute(int routeID, int employeeID) {
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		int time = now.getHour() * 10 + now.getMinute();
		// staff that is logged in
		Employee employee = db.getEmployees().getEmployeeFromID(employeeID);
		String employeeName;
		if (employee == null) {
			// TODO: Change to error when log in works
			employeeName = "no-one";
		} else {
			employeeName = employee.getName();
		}

		// Tell site map to discontinue route and fail if unsuccessful
		if (!db.getSiteMap().discontinueRoute(routeID)) {
			return false;
		}

		// make the event to record the action
		Route route = db.getSiteMap().getRouteFromID(routeID);
		String origin = route.getOrigin();
		String destination = route.getDestination();
		String company = route.getCompany();
		Type type = route.getType();
		BusinessEvent drBusinessEvent = new RouteDiscEvent(day, month, year, time, employeeName, origin, destination,
				company, type);
		// store the event in the data store
		db.addEvent(drBusinessEvent);
		return true;
	}

	public boolean changeCustomerPrice(String origin, String destination, Priority priority, double newWeightCost,
			double newVolumeCost, int employeeID) {
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		int time = now.getHour() * 10 + now.getMinute();
		// staff that is logged in
		Employee employee = db.getEmployees().getEmployeeFromID(employeeID);
		String employeeName;
		if (employee == null) {
			// TODO: Change to error when log in works
			employeeName = "no-one";
		} else {
			employeeName = employee.getName();
		}

		if (!db.getSiteMap().updateCustomerPrices(origin, destination, priority, newWeightCost, newVolumeCost)) {
			return false;
		}

		// make the event to record the action
		BusinessEvent cpcBusinessEvent = new CustPriceChangeEvent(day, month, year, time, employeeName, origin,
				destination, priority, newWeightCost, newVolumeCost);
		// store the event in the data store
		db.addEvent(cpcBusinessEvent);
		return true;
	}

	public boolean changeTransportCost(int routeID, double newTransCostWeight, double newTransCostVolume, int employeeID) {
		LocalDateTime now = LocalDateTime.now();
		int day = now.getDayOfMonth();
		int month = now.getMonthValue();
		int year = now.getYear();
		int time = now.getHour() * 10 + now.getMinute();
		// staff that is logged in
		Employee employee = db.getEmployees().getEmployeeFromID(employeeID);
		String employeeName;
		if (employee == null) {
			// TODO: Change to error when log in works
			employeeName = "no-one";
		} else {
			employeeName = employee.getName();
		}

		db.getSiteMap().updateTransportCost(routeID, newTransCostWeight, newTransCostVolume);
		Route route = db.getSiteMap().getRouteFromID(routeID);
		// make the event to record the action
		String origin = route.getOrigin();
		String destination = route.getDestination();
		String company = route.getCompany();
		Type type = route.getType();

		BusinessEvent tranportCostEvent = new TransportCostChangeEvent(day, month, year, time, employeeName, origin,
				destination, company, type, newTransCostWeight, newTransCostVolume);
		db.addEvent(tranportCostEvent);
		return true;
	}
	/*
	 * =========================================================================
	 * END OF Methods to process events
	 * =========================================================================
	 */

	/*
	 * =========================================================================
	 * START OF Helper methods for the event processing
	 * =========================================================================
	 */
	private double findRevenue(List<Integer> compoundRoutes, double weight, double volume) {
		double total = 0;
		for (int routeID : compoundRoutes) {
			Route route = db.getSiteMap().getRouteFromID(routeID);
			if (route.getType().equals(Type.AIR)) {
				total += weight * route.getCustPriceWeight();
			} else {
				total += volume * route.getCustPriceVolume();
			}
		}
		return total;
	}

	private double findExpenditure(List<Integer> compoundRoutes, double weight, double volume) {
		double total = 0;
		for (int routeID : compoundRoutes) {
			Route route = db.getSiteMap().getRouteFromID(routeID);
			if (route.getType().equals(Type.AIR)) {
				total += weight * route.getTransPriceWeight();
			} else {
				total += volume * route.getTransPriceVolume();
			}
		}
		return total;
	}

	private double findDeliveryTime(List<Integer> compoundRoutes) {
		int time = 0;
		for (int routeID : compoundRoutes) {
			time += db.getSiteMap().getRouteFromID(routeID).getDuration();
		}
		return time;
	}
	/*
	 * =========================================================================
	 * END OF Helper methods for the event processing
	 * =========================================================================
	 */

	// the only things that can be changed on the route are the prices
	// if changes to the carrier, mode, or duration are needed, the route should
	// be discontinued,
	// and a new one made

}
