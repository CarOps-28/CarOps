package com.catalogs;

import com.carops.SparePart;
import com.carops.Vehicle;

import java.io.*;
import java.util.ArrayList;

public class VehicleCatalog {
	private static String url = "files/vehicles.ser";

	private static ArrayList<Vehicle> vehicles = new ArrayList<>();

	public static ArrayList<Vehicle> getVehicles() {
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
		System.out.printf("\n> All Vehicles in catalog:\nn %-13s  %-8s  %-25s  %-10s  %-10s   Other Data\n",
				"Plate Number", "Brand", "Model", "ProdYear","Vehicle Type");
		int i = 1;
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%d", i);
			vehicle.printData();
			i++;
		}
	}

	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public static void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream(url);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(vehicles);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public static boolean refreshDataFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream(url);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			vehicles = (ArrayList<Vehicle>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			return false;
		}
		return true;
	}
}