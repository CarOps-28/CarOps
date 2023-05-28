package com.carops;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Secretary extends Person {

	private int salary;
	private static HashMap<String,Vehicle> vehicles = new HashMap<>();


	public Secretary(String id, String name, String surname){
		super(id, name, surname);
	}
	public void createCustomer(String name, String surname, String phoneNumber, String email, String address) {
//		Generate id from customer list
		Customer customer = new Customer("1111", name, surname,phoneNumber,email,address);

	}

	public boolean createAppointment(String customer, String vehicle, Date date) {
		// TODO - implement Secretary.createAppointment
		throw new UnsupportedOperationException();
	}

	public static boolean createVehicle(String plateNumber, String brand, String model, int prodYear, String type) {
		// TODO - implement Secretary.createVehicle
		return vehicles.put(plateNumber, new Vehicle(plateNumber, brand, model, prodYear, type)) != null ? true:false;
	}

	public Customer searchCustomer(String phoneNumber) {
		// TODO - implement Secretary.searchCustomer
		throw new UnsupportedOperationException();
	}

	public Vehicle searchVehicle(String plateNumbwe) {
		// TODO - implement Secretary.searchVehicle
		return vehicles.get(plateNumbwe);
	}

	public static boolean createMotorcycle(String plateNumber, String brand, String model, int prodYear, String type, int quantum) {
		return vehicles.put(plateNumber,
				new Motorcycle(plateNumber, brand, model, prodYear, type, quantum)) != null
				? true:false;
	}

	public static boolean createTruck(String plateNumber, String brand, String model, int prodYear, String type, float space) {
		return vehicles.put(plateNumber,
				new Truck(plateNumber, brand, model, prodYear, type, space)) != null
				? true:false;
	}

	public void printRepairfile(Repairfile repairfile) {
		// TODO - implement Secretary.printRepairfile
		throw new UnsupportedOperationException();
	}

	public void sendRepairfileWithEmail(Repairfile repairfile) {
		// TODO - implement Secretary.sendRepairfileWithEmail
		throw new UnsupportedOperationException();
	}

}