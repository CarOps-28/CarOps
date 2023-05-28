package com.carops;

import java.util.Date;

public class Appointment {

	private String customerId;
	private String vehiclePlateNumber;
	private boolean status;
	private String transactionId;

	private Repairfile repairfile;
	private Date date;

	// Constructors

	public Appointment(String customerId, String plateNumber, Date date) {
		this.customerId = customerId;
		this.vehiclePlateNumber = plateNumber;
		this.date = date;

		AppointmentCatalog.addAppointment(this);
	}

	public Appointment(String customerId_or_plateNumber, Date date) {
		this.customerId = customerId_or_plateNumber;
		this.date = date;

		AppointmentCatalog.addAppointment(this);
	}

	public Appointment(Date date) {
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