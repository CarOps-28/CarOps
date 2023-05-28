package com.carops;

import java.util.ArrayList;
import java.util.HashMap;

public class Assignment {

	private int worktime;
	private boolean status;
	private HashMap<SparePart, Integer> spareParts = new HashMap<SparePart, Integer>();

	private Repairfile repairfile;
	private Job job;

	private Engineer engineer;

	public Assignment(Engineer engineer, Job job, Repairfile repairfile){
		this.engineer = engineer;
		this.job = job;
		this.repairfile = repairfile;
	}

	public int getSparePartsPrice() {
		int price = 0;
		for (SparePart sparePart : spareParts.keySet()) {
			price = price + sparePart.getPrice() * spareParts.get(sparePart);
		}
		return price;
	}

	public void addSparePart(SparePart sparePart, int quantityOfSparePart) {
		this.spareParts.put(sparePart, quantityOfSparePart);
	}

	public boolean isStatus() {
		return status;
	}

	public void setSpareParts(HashMap<SparePart, Integer> spareParts) {
		this.spareParts = spareParts;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setStatus(boolean newStatus) {
		this.status = newStatus;
	}

	public void setWorktime(int worktime) {
		this.worktime = worktime;
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

	public void setRepairfile(Repairfile rp) {
		this.repairfile = rp;
	}

	public int getWorktime() {
		return this.worktime;
	}

	public HashMap<SparePart, Integer> getSpareParts(){ return this.spareParts;}

}