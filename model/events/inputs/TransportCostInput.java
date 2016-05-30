package model.events.inputs;

public class TransportCostInput {

	private String origin;
	private String destination;
	private String company;
	private String type;
	private String weightCost;
	private String volumeCost;

	public TransportCostInput(String origin, String destination, String company, String type, String weightCost,
			String volumeCost) {
		this.origin = origin;
		this.destination = destination;
		this.company = company;
		this.type = type;
		this.weightCost = weightCost;
		this.volumeCost = volumeCost;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getCompany() {
		return company;
	}

	public String getType() {
		return type;
	}

	public String getWeightCost() {
		return weightCost;
	}

	public String getVolumeCost() {
		return volumeCost;
	}

}
