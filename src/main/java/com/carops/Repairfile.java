package com.carops;

import java.util.ArrayList;
import java.util.HashMap;

public class Repairfile {

	private int worktime;
	private String status;
	private Vehicle vehicle;
	private ArrayList<Job> estimatedJobs;
	private ArrayList<Assignment> assignments = new ArrayList<>();

	private HashMap<SparePart, Integer> totalSparePartsUsed = new HashMap<SparePart, Integer>();

	public Repairfile(Vehicle vehicle, ArrayList<Job> estimatedJobs, int estimatedHours) {
		this.worktime = estimatedHours;
		this.vehicle = vehicle;
		this.estimatedJobs = estimatedJobs;

		RepairfileCatalog.addRepairfile(this);
	}

	public void recordTotalSpareParts(){
		for (Assignment assignment : this.assignments){
			HashMap<SparePart, Integer> currentAssignmentHashMap = assignment.getSpareParts();

			for (SparePart sparePart : currentAssignmentHashMap.keySet()) {
				if (this.totalSparePartsUsed.containsKey(sparePart)){

					Integer newValue = this.totalSparePartsUsed.get(sparePart) + currentAssignmentHashMap.get(sparePart);

					this.totalSparePartsUsed.replace(sparePart, newValue);
				}

				this.totalSparePartsUsed.put(sparePart,currentAssignmentHashMap.get(sparePart));

			}
		}
	}

	public void automaticChangeWorktime(){
		this.worktime = 0;
		for (Assignment assignment : assignments){
			this.worktime += assignment.getWorktime();
		}
	}
	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	public int getTotalCost() {
		int totalPrice = 0;

		for (Assignment assignment : assignments) {

			totalPrice += assignment.getJob().getPrice();

			totalPrice += assignment.getSparePartsPrice();

		}
		return totalPrice;
	}

	public void printData() {
		System.out.printf("%-25d  |%-4d\u20ac\n", worktime/8, getTotalCost());
	}

	// getters & setters
	public int getWorktime() {
		return worktime;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
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

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}