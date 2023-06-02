package com.carops;

import java.util.LinkedList;

public class Vehicle {

	private String plateNumber;
	private String brand;
	private String model;
	private int prodYear;
	private String vehicleType;

	private LinkedList<Repairfile> repairfiles = new LinkedList<>();

	public Vehicle(String plateNumber, String brand, String model, int prodYear, String vehicleType) {
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.model = model;
		this.prodYear = prodYear;
		this.vehicleType = vehicleType;

		// Αυτόματη προσθήκη του αντικείμενου Vehicle στον κατάλογο των Vehicle
		VehicleCatalog.addVehicle(this);
	}

	public void printData() {
		System.out.printf(" |%-13s |%-8s |%-25s |%-10s |%-10s ",
				this.plateNumber, this.getBrand(), this.getModel(), this.getProdYear(), this.vehicleType);
		if( this instanceof Truck)
		{
			Truck t = (Truck) this;
			System.out.printf(" ~ Capacity : %s", t.getCapacity());
		} else if (this instanceof Motorcycle) {
			Motorcycle m = (Motorcycle) this;
			System.out.printf(" ~ Quantum : %s", m.getQuantum());
		}
		System.out.println();
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	// getters setters
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProdYear() {
		return prodYear;
	}

	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}

	public LinkedList<Repairfile> getRepairfiles() {
		return repairfiles;
	}

	public void addRepairfiles(Repairfile repairfiles) {
		this.repairfiles.add(repairfiles);
		repairfiles.setVehicle(this);
	}
}