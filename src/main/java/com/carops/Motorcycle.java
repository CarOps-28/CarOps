package com.carops;

public class Motorcycle extends Vehicle {

	private float quantum;
	public Motorcycle(String plateNumber, String brand, String model, int prodYear, float vehicleType, float quantum) {
		super(plateNumber, brand, model, prodYear, vehicleType);
		this.quantum = quantum;
	}
	public float getTypeValue() {
		return this.quantum;
	}

	public String getVehicleType() {
		return "Motorcycle";
	}
}