package com.carops;
import com.carops.Assignment;
import com.carops.Person;
import com.carops.SparePart;

import java.util.ArrayList;

public class Engineer extends Person {

	private String role;
	private ArrayList<Assignment> assignments;
	private int salary;

	public Engineer(String id, String name, String surname, String role){
		super(id, name, surname);
		this.role = role;
	}
	public void addSpaceParts(Assignment assignment, SparePart sparePart, int quantity) {
		assignment.addSparePart(sparePart,quantity);
	}

	public ArrayList<Assignment> getAssignments() {
		return this.assignments;
	}

	public void setAssignmentStatus(Assignment assignment, boolean status) {
		assignment.setStatus(status);
	}

}