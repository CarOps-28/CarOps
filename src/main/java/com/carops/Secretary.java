package com.carops;

import java.util.Date;

public class Secretary extends Person {

	private int salary;

	public Secretary(String id, String name, String surname) {
		super(id, name, surname);
	}

	public boolean createCustomer(String name, String surname, String phoneNumber, String email, String address) {
		return new Customer(CustomerCatalog.generateId(), name, surname, phoneNumber, email, address) != null ? true
				: false;

	}

	// Ανάλογα με τα ορίσματα που έδωσε η γραμματεία καλείται ο ανάλογος
	// κατασκευαστής του ραντεβού.
	public boolean createAppointment(String customer, String vehicle, Date date) {
		if (customer.equals("")) {
			return new Appointment(vehicle, date) != null ? true : false;
			// Αυτόματη προσθήκη του αντικείμενου Appointment στον κατάλογο των Appointment
		} else if (vehicle.equals("")) {
			return new Appointment(customer, date) != null ? true : false;
		} else {
			return new Appointment(customer, vehicle, date) != null ? true : false;
		}
	}

	// Ανάλογα με τον τύπο του οχήματος καλείται ο ανάλογος κατασκευαστής του οχήματος.
	public boolean createVehicle(String plateNumber, String brand, String model, int prodYear, String type,
			float typeValue) {
		if (type.equalsIgnoreCase("Truck")) {
			return new Truck(plateNumber, brand, model, prodYear, type, typeValue) != null ? true : false;
		} else if (type.equalsIgnoreCase("Motorcycle")) {
			return new Truck(plateNumber, brand, model, prodYear, type, typeValue) != null ? true : false;
		} else {
			return new Vehicle(plateNumber, brand, model, prodYear, type) != null ? true : false;
		}
	}

	public Customer searchCustomer(String phoneNumber) {
		return CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
	}

	public Vehicle searchVehicle(String plateNumber) {
		return VehicleCatalog.fetchVehicleByPlateNumber(plateNumber);
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