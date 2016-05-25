package model.events;

import model.map.Priority;

public class MailProcessEvent extends BusinessEvent {
	private String origin;
	private String destination;
	private double weight;
	private double volume;
	private Priority priority;
	private double revenue;
	private double expenditure;
	private double deliveryTime;

	public MailProcessEvent(int day, int month, int year, int time, String staff, String origin, String destination,
			double weight, double volume, Priority priority, double revenue, double expenditure, double deliveryTime) {
		super(day, month, year, time, staff);
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.volume = volume;
		this.priority = priority;
		this.revenue = revenue;
		this.expenditure = expenditure;
		this.deliveryTime = deliveryTime;
		this.revenue = revenue;
		this.expenditure = expenditure;
		this.deliveryTime = deliveryTime;
	}


	//getters

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public double getRevenue() {
		return revenue;
	}


	public double getExpenditure() {
		return expenditure;
	}


	public String getOriginID() {
		return origin;
	}

	public String getDestinationID() {
		return destination;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public String getPriority() {
		return priority.toString();
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("MAIL PROCESS EVENT\n");
		string.append("Date: " + day + ", " + month + ", " + year + "\n");
		string.append("Time: " + time + "\n");
		string.append("Staff responsible: " + employee + "\n");
		string.append("Origin: " + origin + "\n");
		string.append("Destination: " + destination + "\n");
		string.append("Weight: " + weight + "\n");
		string.append("Volume: " + volume + "\n");
		string.append("Priority: " + priority);
		string.append("Revenue: " + revenue);
		string.append("Expenditure: " + expenditure);
		string.append("Delivery time: " + deliveryTime);
		return string.toString();
	}

}
