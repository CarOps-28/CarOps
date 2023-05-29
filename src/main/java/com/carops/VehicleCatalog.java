package com.carops;

import java.util.ArrayList;

public class VehicleCatalog {

	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public static Vehicle fetchVehicleByPlateNumber(String plateNumber) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getPlateNumber().equalsIgnoreCase(plateNumber)) {
				return vehicle;
			}
		}
		return null;
	}

	public static void printData() {
		System.out.printf("\n> All Vehicles in catalog:\nn %-25s  %-10s\n", "PlateNumber", "Vehicle Type");
		int i = 1;
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%d|", i);
			vehicle.printData();
			i++;
		}
	}

	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

}