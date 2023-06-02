package com.carops;

import java.util.HashMap;

public class Assignment {

	private int worktime;
	private boolean status;
	private HashMap<SparePart, Integer> spareParts = new HashMap<>();
	private Repairfile repairfile;
	private Job job;
	private Engineer engineer;

	public Assignment(Engineer engineer, Job job, Repairfile repairfile) {
		this.engineer = engineer;
		this.job = job;
		this.repairfile = repairfile;
	}

	// Συνάρτηση που υπολογίζει και επιστρέφει το συνολικό κόστος όλων των
	// ανταλλακτικών της εργασίας. Προστέθηκε για διευκόλυνση του υπολογισμού του
	// τελικού κόστους.
	public int getSparePartsPrice() {
		int price = 0;
		for (SparePart sparePart : spareParts.keySet()) {
			price = price + sparePart.getPrice() * spareParts.get(sparePart);
		}
		return price;
	}

	public void setSpareParts(HashMap<SparePart, Integer> spareParts) {
		//for(){

		//}
		this.spareParts = new HashMap<>(spareParts);
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setStatus(boolean newStatus) {
		this.status = newStatus;
	}

	// Προστέθηκε με βάση τη σχεδίαση των λεκτικών και των mockup.
	public void setWorktime(int worktime) {
		this.worktime = worktime;
		// Αυτόματη ενημέρωση των ωρών του Repairfile κάθε φορά που μια εργασία
		// ολοκληρώνεται.
		repairfile.automaticChangeWorktime();
	}

	public boolean getStatus() {
		return this.status;
	}

	public Job getJob() {
		return this.job;
	}

	public Repairfile getRepairfile() {
		return this.repairfile;
	}

	public void setRepairfile(Repairfile repairfile) {
		this.repairfile = repairfile;
	}

	public int getWorktime() {
		return this.worktime;
	}

	public HashMap<SparePart, Integer> getSpareParts() {
		return this.spareParts;
	}


	public void printData(){
		String assignmentStatus;
		if(this.status==true)
			assignmentStatus = "Completed";
		else
			assignmentStatus = "Pending";

		System.out.printf("%-15s |%-15s |%-4s |%-5s\n", "Engineer name", "Job name", "Work Time", "Status");

		System.out.printf("%-15s |%-15s |%-4d |%-5s\n",
				this.engineer.getName(), this.job.getName(), this.worktime,
				assignmentStatus);
	}
}