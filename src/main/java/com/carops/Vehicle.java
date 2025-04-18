package com.carops;

import com.catalogs.CustomerCatalog;
import com.catalogs.VehicleCatalog;

import java.io.Serializable;

public class Vehicle implements Serializable {

	private String id, plateNumber, brand, model, vehicleType;
	private int prodYear;


	public Vehicle(String plateNumber, String brand, String model, int prodYear, String vehicleType) {
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.model = model;
		this.prodYear = prodYear;
		this.vehicleType = vehicleType;

		this.setId();
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

	public int getProdYear() {
		return prodYear;
	}
	public String toString(){
		return this.plateNumber + " " + this.model + " " + this.prodYear + " " + this.vehicleType;
	}
	public String getValue(){
		return " - ";
	}
	public String getId(){
		return id;
	}
	private void setId(){
		this.id = "VEH" + (VehicleCatalog.getVehicles().size() + 1 );
	}


}