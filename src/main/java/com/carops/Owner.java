package com.carops;

import java.util.ArrayList;

public class Owner extends Person {
	public static ArrayList<Owner> owners = new ArrayList<Owner>();

	public Owner(String name, String surname) {
		super( name, surname);
	}
	public void setId(){
		this.id = "OWN" + (owners.size() + 1 );
	}

	public void changeRole(Engineer engineer, String role) {

		// Ανάλογα με τον ρόλο δημιουργείται ενα αντικείμενο ανάλογου μηχανικού και
		// διαγράφεται το προηγούμενο μετά την πλήρη αντιγραφή του.
		switch (role) {
			case "engineer":
				Engineer newEngineer = new Engineer(engineer.getName(), engineer.getSurname(), role);
				newEngineer.setAssignments(engineer.getAssignments());
				newEngineer.setId(engineer.getId());
				EngineerCatalog.removeEngineer(engineer);
				break;
			case "reception":
				ReceptionEngineer newRecEngineer = new ReceptionEngineer( engineer.getName(),
						engineer.getSurname(), role);
				newRecEngineer.setAssignments(engineer.getAssignments());
				newRecEngineer.setId(engineer.getId());
				EngineerCatalog.removeEngineer(engineer);
				break;
			case "supervisor":
				SupervisorEngineer newSupEngineer = new SupervisorEngineer( engineer.getName(),
						engineer.getSurname(), role);
				newSupEngineer.setAssignments(engineer.getAssignments());
				newSupEngineer.setId(engineer.getId());
				EngineerCatalog.removeEngineer(engineer);
				break;
			default:
				break;
		}
	}

}