package com.carops;

import java.util.ArrayList;

public class VehicleCatalog {

	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public static Vehicle fetchVehicleByPlateNumber(String plateNumber) {
		for(Vehicle vehicle: vehicles){
			if(vehicle.getPlateNumber().equalsIgnoreCase(plateNumber)){
				return vehicle;
			}
		}
		return null;
	}

	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

}