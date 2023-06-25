package com.carops;

import com.catalogs.RepairfileCatalog;

import java.util.ArrayList;
import java.util.HashMap;

public class Repairfile {

	private int worktime;
	private String status = "";
	private Vehicle vehicle;
	private ArrayList<Job> estimatedJobs;
	private ArrayList<Assignment> assignments = new ArrayList<>();

	// Χρήση HashMap για τη συγκέντρωση των ανταλλακτικών και του πλήθους τους από
	// όλες τις αναθέσεις
	// μετά την ολοκλήρωση των επιμέρους εργασιών της επισκευής από τους μηχανικούς.
	private HashMap<SparePart, Integer> totalSparePartsUsed = new HashMap<SparePart, Integer>();

	public Repairfile(Vehicle vehicle, ArrayList<Job> estimatedJobs, int estimatedDays) {
		this.worktime = estimatedDays;
		this.vehicle = vehicle;
		this.estimatedJobs = estimatedJobs;

		this.status= "Awaiting";
		// Αυτόματη προσθήκη του αντικείμενου Repairfile στον κατάλογο των Repairfile
		RepairfileCatalog.addRepairfile(this);
	}

	// Από κάθε εργασία ζητάμε όλα τα ανταλλακτικά της και τα ομαδοποιούμε σε ένα
	// HashMap του repairfile.
	public void recordTotalSpareParts() {
		for (Assignment assignment : this.assignments) {
			HashMap<SparePart, Integer> currentAssignmentHashMap = assignment.getSpareParts();

			for (SparePart sparePart : currentAssignmentHashMap.keySet()) {
				if (this.totalSparePartsUsed.containsKey(sparePart)) {

					Integer newValue = this.totalSparePartsUsed.get(sparePart)
							+ currentAssignmentHashMap.get(sparePart);

					this.totalSparePartsUsed.replace(sparePart, newValue);
				}

				this.totalSparePartsUsed.put(sparePart, currentAssignmentHashMap.get(sparePart));

			}
		}
	}

	// Συνάρτηση που ενημερώνει αυτόματα τις ώρες εργασίας του RepairFile σύμφωνα με
	// τις ολοκληρωμένες εργασίες
	public void automaticChangeWorktime() {
		this.worktime = 0;
		for (Assignment assignment : assignments) {
			this.worktime += assignment.getWorktime();
		}
	}

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}


	// Συνάρτηση που υπολογίζει το εκτιμώμενο κόστος λαμβάνοντας τις τιμές των εκτιμώμενων εργασιών
	// η το τελικό κόστος λαμβάνοντας τις τιμές από όλες τις δουλειές και από όλα τα ανταλλακτικά της επισεκυής.
	public int getTotalCost() {
		int totalPrice = 0;

		if(this.status=="Awaiting"){// υπολογισμός ΕΚΤΙΜΩΜΕΝΟΥ κόστους
			for(Job job: this.estimatedJobs){
				totalPrice += job.getPrice();
			}
		}
		else{ //υπολογισμός ΤΕΛΙΚΟΥ κόστους

			for (Assignment assignment : assignments) {

				// άθροισμα της τιμής της κάθε δουλειάς.
				totalPrice += assignment.getJob().getPrice();
			}

			for (Assignment assignment : assignments)
				// Άθροισμα κόστους των ανταλλακτικών της εργασίας.
				totalPrice += assignment.getSparePartsPrice();
		}

		return totalPrice;
	}

	public void printData() {
		System.out.printf(" |%-25d |%-10s |%-13s |%-10s |%-8d |%-14d |%-4d\u20ac\n",
				worktime / 8, this.status==null ? " - " : this.status, vehicle.getPlateNumber(),
				vehicle.getVehicleType(), estimatedJobs.size(), assignments.size(),  getTotalCost());
	}

	// getters & setters
	public int getWorktime() {
		return worktime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	protected void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ArrayList<Job> getJobs() {
		return estimatedJobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.estimatedJobs = jobs;
	}

	public void addJobs(Job jobs) {
		this.estimatedJobs.add(jobs);
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}