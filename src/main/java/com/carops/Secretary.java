package com.carops;

import java.util.ArrayList;

public class Secretary extends Person {

	public static ArrayList<Secretary> secretaryList = new ArrayList<Secretary>();

	private int salary;

	public Secretary(String id, String name, String surname) {
		super(id, name, surname);
		secretaryList.add(this);
	}

	public Customer createCustomer(String name, String surname, String phoneNumber, String email, String address) {
		return new Customer(CustomerCatalog.generateId(), name, surname, phoneNumber, email, address);
	}

	// Ανάλογα με τα ορίσματα που έδωσε η γραμματεία καλείται ο ανάλογος
	// κατασκευαστής του ραντεβού.
	public Appointment createAppointment(String customer, String vehicle, DateTime date) {
		if (customer.equals("")) {
			return new Appointment(vehicle, date);
			// Αυτόματη προσθήκη του αντικείμενου Appointment στον κατάλογο των Appointment
		} else if (vehicle.equals("")) {
			return new Appointment(customer, date);
		} else {
			return new Appointment(customer, vehicle, date);
		}
	}

	// Ανάλογα με τον τύπο του οχήματος καλείται ο ανάλογος κατασκευαστής του
	// οχήματος.
	public Vehicle createVehicle(String plateNumber, String brand, String model, int prodYear, String type,
			float typeValue) {
		if (type.equalsIgnoreCase("Truck")) {
			return new Truck(plateNumber, brand, model, prodYear, type, typeValue);
		} else if (type.equalsIgnoreCase("Motorcycle")) {
			return new Truck(plateNumber, brand, model, prodYear, type, typeValue);
		} else {
			return new Vehicle(plateNumber, brand, model, prodYear, type);
		}
	}

	public Customer searchCustomer(String phoneNumber) {
		return CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
	}

	public Vehicle searchVehicle(String plateNumber) {
		return VehicleCatalog.fetchVehicleByPlateNumber(plateNumber);
	}

	public Repairfile searchRepairfile(String plateNumber) {
		return RepairfileCatalog.fetchRepairfilebyVehicle(plateNumber);
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