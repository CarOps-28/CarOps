package com.carops;

import java.util.ArrayList;

import com.catalogs.EngineerCatalog;

public class Owner extends Person {
	public static ArrayList<Owner> owners = new ArrayList<>();

	public Owner(String name, String surname) {
		super(name, surname);
		this.setId();
	}
	private void setId() {
		this.id = "OWN" + (owners.size() + 1);
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
				ReceptionEngineer newRecEngineer = new ReceptionEngineer(engineer.getName(),
						engineer.getSurname(), role);
				newRecEngineer.setAssignments(engineer.getAssignments());
				newRecEngineer.setId(engineer.getId());
				EngineerCatalog.removeEngineer(engineer);
				break;
			case "supervisor":
				SupervisorEngineer newSupEngineer = new SupervisorEngineer(engineer.getName(),
						engineer.getSurname(), role);
				newSupEngineer.setAssignments(engineer.getAssignments());
				newSupEngineer.setId(engineer.getId());
				EngineerCatalog.removeEngineer(engineer);
				break;
			default:
				break;
		}
	}

	public static Owner searchOwner(String surname) {
		for (Owner owner : owners) {
			if (Processes.removeTones(surname)
					.equalsIgnoreCase(Processes.removeTones(owner.getSurname()))) {
				return owner;
			}
		}
		return null;
	}

}