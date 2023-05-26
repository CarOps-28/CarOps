package com.carops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Repairfile {

	private float price;
	private int worktime;
	private String status;
	private Vehicle vehicle;
	private ArrayList<Job> jobs = new ArrayList<>();
	private ArrayList<Assignment> asgm = new ArrayList<>();

	public ArrayList<Assignment> getAssigments() {
		// TODO - implement Repairfile.getAssigments
		return asgm;
	}

	public void addAssignment(Assignment assignment) {
		// TODO - implement Repairfile.addAssignment
		asgm.add(assignment);
	}

	public float getTotalCost() {
		// TODO - implement Repairfile.calculatePrice
		float sum = 0;
		for (Job j : jobs) {
			sum += j.getPrice();
		}
		
		for (Assignment a : asgm) {
			HashMap<SparePart, Integer> h = a.getSpareParts();
			for (Map.Entry<SparePart, Integer> sparePartIntegerEntry : h.entrySet()) {
				sum += ((SparePart) sparePartIntegerEntry.getKey()).getPrice();
			}
		}
		return sum;
	}

	public void printData(){
		System.out.printf("%-25d |%-4f\n", worktime, getTotalCost());
	}

	// getters & setters
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

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

	public ArrayList<Assignment> getAsgm() {
		return asgm;
	}

	public void setAsgm(ArrayList<Assignment> asgm) {
		this.asgm = asgm;
	}

	public Vehicle getVehicle() {
		// TODO - implement Repairfile.getVehicle
		return vehicle;
	}



}