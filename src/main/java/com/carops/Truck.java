package com.carops;

public class Truck extends Vehicle {

	private float capacity;
	public Truck(String plateNumber, String brand, String model, int prodYear, float vehicleType, float capacity) {
		super(plateNumber, brand, model, prodYear, vehicleType);
		this.capacity = capacity;
	}
	public float getTypeValue() {
		return this.capacity;
	}

	public String getVehicleType() {
		return "Truck";
	}

}