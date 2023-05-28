package com.carops;
import java.util.HashMap;

public class Assignment {

	private int worktime;
	private boolean status;
	private HashMap<SparePart, Integer> spareParts = new HashMap<SparePart, Integer>();

	private Repairfile repairfile;
	private Job job;
	public Assignment(int worktime, boolean status, HashMap<SparePart, Integer> spareParts) {
		this.worktime = worktime;
		this.status = status;
		this.spareParts = spareParts;
	}

	public void addSparePart(SparePart sparePart, int quantityOfSparePart) {
		this.spareParts.put(sparePart, quantityOfSparePart);
	}

	public boolean isStatus() {
		return status;
	}

	public HashMap<SparePart, Integer> getSpareParts() {
		return spareParts;
	}

	public void setSpareParts(HashMap<SparePart, Integer> spareParts) {
		this.spareParts = spareParts;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setStatus(boolean newStatus){
		this.status = newStatus;
	}
	public void setWorktime(int worktime){
		this.worktime = worktime;
	}
	public boolean getStatus(){
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

	public HashMap<SparePart, Integer> getSpareParts() { return spareParts; }
}