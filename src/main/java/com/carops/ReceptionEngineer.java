package com.carops;

import java.util.ArrayList;

public class ReceptionEngineer extends Engineer {

	public ReceptionEngineer(String id, String name, String surname, String role) {
		super(id, name, surname, role);
	}

	public void createRepairFile(Vehicle vehicle, ArrayList<Job> jobs, int days) {
		vehicle.addRepairfiles(new Repairfile(vehicle, jobs, days));
	}

	// public void createAssignment(Engineer engineer, Job job, Repairfile
	// repairfile) {
	// return new Assignment(plateNumber, brand, model, prodYear, type) != null ?
	// true:false;
	// }

	public boolean createVehicle(String plateNumber, String brand, String model, int prodYear, String type,float typeValue ) {
		if (type.equalsIgnoreCase("Truck")){
			return new Truck(plateNumber, brand, model, prodYear, type,typeValue) != null ? true : false;
		}else if (type.equalsIgnoreCase("Motorcycle")){
			return new Truck(plateNumber, brand, model, prodYear, type,typeValue) != null ? true : false;
		}else{
			return new Vehicle(plateNumber, brand, model, prodYear, type) != null ? true : false;
		}
	}

	public Vehicle searchVehicle(String plateNumber) {
		return VehicleCatalog.fetchVehicleByPlateNumber(plateNumber);
	}

}