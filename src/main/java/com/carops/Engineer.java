package com.carops;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Engineer extends Person  {

	private String role;
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private int salary;

	public Engineer(String name, String surname, String role) {
		super( name, surname);
		this.role = role;
		this.setId();

		// Αυτόματη προσθήκη του αντικείμενου Engineer στον κατάλογο των Engineer
		EngineerCatalog.addEngineer(this);
	}

	public void setAssignmentWorktime(Assignment assignment, int worktime) {
		assignment.setWorktime(worktime);
	}

	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
	}

	public ArrayList<Assignment> getAssignments() {
		return this.assignments;
	}

	public void setAssignmentStatus(Assignment assignment, boolean status) {
		assignment.setStatus(status);
	}

	public String getRole() {
		return this.role;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}


	public void printData(){
		System.out.printf(" |%-8s |%-15s |%-15s |%-10s\n", this.getId(), this.getName(), this.getSurname(), this.role);
	}

	public void setId(){
		this.id = "MHX" + (EngineerCatalog.fetchEngineers().size() + 1 );
	}

}