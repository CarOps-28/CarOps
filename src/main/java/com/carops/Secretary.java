package com.carops;

import java.util.Date;

public class Secretary extends Person {

	private int salary;

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

	public boolean createVehicle(String plateNumber, String brand, String model, int prodYear, String type) {
		// TODO - implement Secretary.createVehicle

		throw new UnsupportedOperationException();
	}

	public Customer searchCustomer(String phoneNumber) {
		// TODO - implement Secretary.searchCustomer
		throw new UnsupportedOperationException();
	}

	public Vehicle searchVehicle(String plateNumbwe) {
		// TODO - implement Secretary.searchVehicle
		throw new UnsupportedOperationException();
	}

	public boolean createMotorcycle(String plateNumber, String brand, String model, int prodYear, String type, int quantum) {
		// TODO - implement Secretary.createMotorcycle
		throw new UnsupportedOperationException();
	}

	public boolean createTruck(String plateNumber, String brand, String model, int prodYear, String type, float space) {
		// TODO - implement Secretary.createTruck
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