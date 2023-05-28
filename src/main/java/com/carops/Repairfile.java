package com.carops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repairfile {

	private int worktime;
	private String status;
	private Vehicle vehicle;
	private ArrayList<Job> jobs = new ArrayList<>();
	private ArrayList<Assignment> assignments = new ArrayList<>();

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	public int getTotalCost() {
		int sum = 0;

		for(Assignment assignment: assignments) {

			sum+= assignment.getJob().getPrice();

			for(SparePart part : assignment.getSpareParts().keySet()) {
				int usedQuantity = assignment.getSpareParts().get(part);

				for (SparePart sparepart : SparePartsCatalog.fetchSpareParts()) {
					if (part.equals(sparepart.getName()))
						sum += usedQuantity * sparepart.getPrice();
				}
			}
		}
		return sum;
	}


	public void printData(){
		System.out.printf("%-25d |%-4f\n", worktime, getTotalCost());
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
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	public void addJobs(Job jobs) {
		this.jobs.add(jobs);
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