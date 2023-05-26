package com.carops;

public class Vehicle {

	private String plateNumber;
	private String brand;
	private String model;
	private int prodYear;
	private float vehicleType;

	public Vehicle(String plateNumber, String brand, String model, int prodYear, float vehicleType) {
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.model = model;
		this.prodYear = prodYear;
		this.vehicleType = vehicleType;
	}

	public String getPlateNumber() {return plateNumber;}

	public float getTypeValue() {
		return -1;
	}

	public String getVehicleType() {
		return "Vehicle";
	}

}