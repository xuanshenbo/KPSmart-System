package model.events;

import model.map.Type;

public class CustPriceChangeEvent extends BusinessEvent {
	private String origin;
	private String destination;
	private String company;
	private Type mode;
	private double newWeightCost;
	private double newVolumeCost;

	public CustPriceChangeEvent(int day, int month, int year, int time, String staff, String origin,
			String destination, String company, Type mode, double newWeightCost, double newVolumeCost) {
		super(day, month, year, time, staff);
		this.origin = origin;
		this.destination = destination;
		this.company = company;
		this.mode = mode;
		this.newWeightCost = newWeightCost;
		this.newVolumeCost = newVolumeCost;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("CUSTOMER PRICE CHANGE EVENT\n");
		string.append("Date: " + day + ", " + month + ", " + year + "\n");
		string.append("Time: " + time + "\n");
		string.append("Staff responsible: " + employee + "\n");
		string.append("Origin: " + origin + "\n");
		string.append("Destination: " + destination + "\n");
		string.append("Company: " + company + "\n");
		string.append("Mode: " + mode + "\n");
		string.append("Weight Cost: " + newWeightCost + "\n");
		string.append("Volume Cost: " + newVolumeCost);
		return string.toString();
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getCompany() {
		return mode.toString();
	}
	
	public String getMode() {
		return mode.toString();
	}

	public double getNewWeightCost() {
		return newWeightCost;
	}

	public double getNewVolumeCost() {
		return newVolumeCost;
	}



}
