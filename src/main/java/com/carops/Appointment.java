package com.carops;

public class Appointment {

	private String customerId;
	private String vehiclePlateNumber;
	private boolean status;
	private String transactionId;
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

	public Appointment(String customerId_or_plateNumber, DateTime date) {
		this.customerId = customerId_or_plateNumber;
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

	public Appointment(DateTime date) {
		this.date = date;
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

	public boolean isStatus() {
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
}