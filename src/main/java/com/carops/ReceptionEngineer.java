package com.carops;

import java.util.ArrayList;


public class ReceptionEngineer extends Engineer {


	public ReceptionEngineer(String id, String name, String surname, String role){
		super(id, name, surname,role);
	}
	public void createRepairFile(Vehicle vehicle, ArrayList<Job> jobs, int days) {

	}

	public void createAssignment(Engineer engineer, Job job, Repairfile repairfile) {
		// TODO - implement ReceptionEngineer.createAssignment
		throw new UnsupportedOperationException();
	}

}