package com.carops;

import com.carops.Assignment;
import com.carops.Job;

public class SupervisorEngineer extends Engineer {

	public SupervisorEngineer(String id, String name, String surname, String role){
		super(id, name, surname,role);
	}
	public void addAssignmentToEngineer(Engineer engineer, Assignment assignment) {
		// TODO - implement SupervisorEngineer.addAssignmentToEngineer
		throw new UnsupportedOperationException();
	}

	public void createAssignment(Engineer engineer, Job job, Repairfile repairfile) {
		// TODO - implement SupervisorEngineer.createAssignment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vehiclePlateNumber
	 */
	public void changeRepairfileStatusToCompleted(String vehiclePlateNumber) {
		// TODO - implement SupervisorEngineer.changeRepairfileStatusToCompleted
		throw new UnsupportedOperationException();
	}

}