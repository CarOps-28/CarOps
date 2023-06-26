package com.carops;

import com.catalogs.AppointmentCatalog;
import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;

import java.io.Serializable;

public class Appointment implements Serializable {

	private String customerId = "", vehiclePlateNumber = "", transactionId;
	private boolean status;
	private Repairfile repairfile;
	private DateTime date;

	// Constructors
	public Appointment(String customerId, String plateNumber, DateTime date) {
		this.customerId = customerId;
		this.vehiclePlateNumber = plateNumber;
		this.date = date;

		// Αυτόματη προσθήκη του αντικείμενου Appointment στον κατάλογο των Appointment
		AppointmentCatalog.addAppointment(this);
	}

	public Appointment(DateTime date) {
		this.date = date;
		// Αυτόματη προσθήκη του αντικείμενου Appointment στον κατάλογο των Appointment
		AppointmentCatalog.addAppointment(this);
	}

	public void printData() {
		Customer c = CustomerCatalog.fetchCustomerById(this.customerId);
		Vehicle v = VehicleCatalog.fetchVehicleByPlateNumber(this.vehiclePlateNumber);
		System.out.printf(" |%-25s |%-15s |%-14s |%-20s |%-20s |%-20s |%-20s\n",
				date.getDateTime(),
				c==null ? "No customer" : c.getName(),
				c==null ? " - " : c.getSurname(),
				c==null ? " - " : c.getPhoneNumber(),
				v==null ? "No vehicle" : v.getPlateNumber(),
				v==null ? " - " : v.getBrand(),
				v==null ? " - " : v.getVehicleType());
	}


	// getters
	public Repairfile getRepairfile() {
		return this.repairfile;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public String getVehiclePlateNumber() {
		return this.vehiclePlateNumber;
	}

	public boolean getStatus() {
		return this.status;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	// setters
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setRepairfile(Repairfile repairfile) {
		this.repairfile = repairfile;
	}

	public String toString(){
		Customer c = CustomerCatalog.fetchCustomerById(this.customerId);
		Vehicle v = VehicleCatalog.fetchVehicleByPlateNumber(this.vehiclePlateNumber);

		return date.getDateTime() + " Customer: " + (c==null ? "No customer" : c.getSurname() )+ " Vehicle: " +(v==null ? "No vehicle" : v.getPlateNumber());
	}
	public String getDate(){
		return this.date.getDateTime();
	}
}