package com.carops;

import com.catalogs.RepairfileCatalog;
import com.catalogs.VehicleCatalog;

public class SupervisorEngineer extends Engineer {

	public SupervisorEngineer(String name, String surname, String role) {
		super(name, surname, role);
	}

	public void addAssignmentToEngineer(Engineer engineer, Assignment assignment) {
		engineer.addAssignment(assignment);
	}

	public Assignment createAssignment(Engineer engineer, Job job, Repairfile repairfile) {
		Assignment a1 = new Assignment(engineer, job, repairfile);
		repairfile.addAssignment(a1);
		this.addAssignmentToEngineer(engineer, a1);
		return a1;
	}

	public void changeRepairfileStatusToCompleted(String vehiclePlateNumber) {
		RepairfileCatalog.fetchRepairfilebyVehicle(vehiclePlateNumber).setStatus("Completed");
	}

	// Προστέθηκε για τη καταγραφή των ανταλλακτικών που χρησιμοποιήθηκαν αφού
	// ολοκληρωθεί η επισκευή.
	public void callRecordTotalSparePartsFromRepairfile(Repairfile repairfile) {
		repairfile.recordTotalSpareParts();
	}

	// Προστέθηκε για πιστή τήρηση της διαδικασίας ανάθεσης εργασιών σε μηχανικό
	// βάσει των λεκτικών και mockup.
	public Vehicle searchVehicle(String plateNumber) {
		return VehicleCatalog.fetchVehicleByPlateNumber(plateNumber);
	}

	public Repairfile searchRepairfile(String plateNumber) {
		return RepairfileCatalog.fetchRepairfilebyVehicle(plateNumber);
	}
}