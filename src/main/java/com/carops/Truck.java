package com.carops;

public class Truck extends Vehicle {

	private float capacity;

	public Truck(String plateNumber, String brand, String model, int prodYear, String vehicleType, float capacity) {
		super(plateNumber, brand, model, prodYear, vehicleType);
		this.capacity = capacity;
	}

	public float getCapacity() {
		return this.capacity;
	}

	public String getVehicleType() {
		return "Truck";
	}

}