package com.carops;

import com.catalogs.AppointmentCatalog;
import com.catalogs.RepairfileCatalog;
import com.catalogs.VehicleCatalog;
import java.util.ArrayList;

public class ReceptionEngineer extends Engineer {

	public ReceptionEngineer( String name, String surname, String role) {
		super(name, surname, role);
	}

	public void createRepairFile(Vehicle vehicle, ArrayList<Job> jobs, int days) {
		Repairfile rp = new Repairfile(vehicle, jobs, days);
	}

	public Assignment createAssignment(Engineer engineer, Job job, Repairfile repairfile) {
		return new Assignment(engineer, job, repairfile);
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

	// Προστέθηκε για πιστή τήρηση της διαδικασίας δημιουργίας φακέλου επισκευής των
	// λεκτικών και mockup.
	public Vehicle searchVehicle(String plateNumber) {
		return VehicleCatalog.fetchVehicleByPlateNumber(plateNumber);
	}
	public Repairfile searchRepairfile(String plateNumber) {
		return RepairfileCatalog.fetchRepairfilebyVehicle(plateNumber);
	}

}