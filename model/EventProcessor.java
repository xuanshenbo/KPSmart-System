package model;

public class EventProcessor {

	private EventProcessor(){}

	public static void changeRoute(int routeID, String updatedCarrier, double updatedDuration, double updatedCustPriceWeight, double custPriceVolume,
			double transPriceWeight, double transPriceVolume) {
		// not yet implemented
		System.out.println("BEP.changeRoute not yet implemented");
	};

	public static void addRoute(int toSiteID, int fromSiteID, String carrier, double duration, double custPriceWeight, double custPriceVolume,
			double transPriceWeight, double transPriceVolume) {
		// not yet implemented
		System.out.println("BEP.addRoute not yet implemented");
	};

	//is this different from changeRoute?? should we separate all change types out?
	//should this cover customer price, transport price.. both?
	public static void changePrice() {
		// not yet implemented
		System.out.println("BEP.changePrice not yet implemented");
	}

	public static void processMail(int originSiteID, int destSiteID, double price, double weight, double volume, int priority) {
		// not yet implemented
		System.out.println("BEP.processMail not yet implemented");
	}

	public static void disconRoute(int routeID) {
		// not yet implemented
		System.out.println("BEP.disconRoute not yet implemented");
	}

	public static void pushEvent() {
		// not yet implemented
		System.out.println("BEP.pushEvent not yet implemented");
	}

	public static void createEvent() {
		// not yet implemented
		System.out.println("BEP.createEvent not yet implemented");
	}
}