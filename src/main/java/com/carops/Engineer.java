package com.carops;

import java.util.ArrayList;

public class Engineer extends Person {

	private String role;
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private int salary;

	public Engineer(String id, String name, String surname, String role) {
		super(id, name, surname);
		this.role = role;

		EngineerCatalog.addEngineer(this);
	}

	public void addSpaceParts(Assignment assignment, SparePart sparePart, int quantity) {
		assignment.addSparePart(sparePart, quantity);
	}

	public void setAssignmentWorktime(Assignment assignment, int worktime){
		assignment.setWorktime(worktime);
	}
	public void addAssignment(Assignment assignment){
		this.assignments.add(assignment);
	}
	public ArrayList<Assignment> getAssignments() {
		return this.assignments;
	}

	public void setAssignmentStatus(Assignment assignment, boolean status) {
		assignment.setStatus(status);
	}

}