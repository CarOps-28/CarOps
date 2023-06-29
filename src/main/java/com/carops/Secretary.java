package com.carops;

import java.util.ArrayList;

import com.catalogs.CustomerCatalog;
import com.catalogs.RepairfileCatalog;
import com.catalogs.VehicleCatalog;

public class Secretary extends Person {

	public static ArrayList<Secretary> secretaryList = new ArrayList<Secretary>();
	private int salary;

	public Secretary(String name, String surname) {
		super(name, surname);
		secretaryList.add(this);
	}

	public Customer createCustomer(String name, String surname, String phoneNumber, String email, String address) {
		Customer c = CustomerCatalog.fetchCustomerByPhoneNumber(phoneNumber);
		if( c != null ){
			return null;
		}
		return new Customer(name, surname, phoneNumber, email, address);
	}

	// Ανάλογα με τα ορίσματα που έδωσε η γραμματεία καλείται ο ανάλογος
	// κατασκευαστής του ραντεβού.
	public Appointment createAppointment(String customer, String vehicle, DateTime date) {
		if (customer.equals("") && vehicle.equals("")) {
			return new Appointment(date);
		} else if (customer.equals("") && !vehicle.equals("")) {
			Appointment a1 = new Appointment(date);
			a1.setVehiclePlateNumber(vehicle);
			return a1;
		} else if (!customer.equals("") && vehicle.equals("")) {
			Appointment a1 = new Appointment(date);
			a1.setCustomerId(customer);
			return a1;
		} else {
			return new Appointment(customer, vehicle, date);
		}
	}

	public void addPlateNumberToAppointment(Appointment appointment, String plateNumber){
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

	public static Secretary searchSecretary(String surname) {
		for (Secretary cr : secretaryList) {
			if (Processes.removeTones(surname)
					.equalsIgnoreCase(Processes.removeTones(cr.getSurname()))) {
				return cr;
			}
		}
		return null;
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