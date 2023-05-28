package com.carops;

import java.util.Date;

public class Secretary extends Person {

	private int salary;

	public Secretary(String id, String name, String surname) {
		super(id, name, surname);
	}

	public void createCustomer(String name, String surname, String phoneNumber, String email, String address) {
		// Generate id from customer list
		Customer customer = new Customer("1111", name, surname, phoneNumber, email, address);

	}

	public boolean createAppointment(String customer, String vehicle, Date date) {
		// TODO - implement Secretary.createAppointment
		throw new UnsupportedOperationException();
	}

	public boolean createVehicle(String plateNumber, String brand, String model, int prodYear, String type,float typeValue ) {
		if (type.equalsIgnoreCase("Truck")){
			return new Truck(plateNumber, brand, model, prodYear, type,typeValue) != null ? true : false;
		}else if (type.equalsIgnoreCase("Motorcycle")){
			return new Truck(plateNumber, brand, model, prodYear, type,typeValue) != null ? true : false;
		}else{
			return new Vehicle(plateNumber, brand, model, prodYear, type) != null ? true : false;
		}
	}

	public Customer searchCustomer(String phoneNumber) {
		// TODO - implement Secretary.searchCustomer
		throw new UnsupportedOperationException();
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