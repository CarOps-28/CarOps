package com.carops;

public class Motorcycle extends Vehicle {

	private float quantum;

	public Motorcycle(String plateNumber, String brand, String model, int prodYear, String vehicleType, float quantum) {
		super(plateNumber, brand, model, prodYear, vehicleType);
		this.quantum = quantum;
	}

	public float getQuantum() {
		return this.quantum;
	}

	public String getVehicleType() {
		return "Motorcycle";
	}

	public String getValue(){
		return String.valueOf(this.quantum);
	}
}