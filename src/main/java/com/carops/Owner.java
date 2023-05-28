package com.carops;

public class Owner extends Person {
	public Owner(String id, String name, String surname) {
		super(id, name, surname);
	}

	public void changeRole(Engineer engineer, String role) {

		// Ανάλογα με τον ρόλο δημιουργείται ενα αντικείμενο ανάλογου μηχανικού και
		// διαγράφεται το προηγούμενο μετά την πλήρη αντιγραφή του.
		switch (role) {
			case "engineer":
				Engineer newEngineer = new Engineer(engineer.getId(), engineer.getName(), engineer.getSurname(), role);
				newEngineer.setAssignments(engineer.getAssignments());
				EngineerCatalog.removeEngineer(engineer);
				break;
			case "reception":
				ReceptionEngineer newRecEngineer = new ReceptionEngineer(engineer.getId(), engineer.getName(),
						engineer.getSurname(), role);
				newRecEngineer.setAssignments(engineer.getAssignments());
				EngineerCatalog.removeEngineer(engineer);
				break;
			case "supervisor":
				SupervisorEngineer newSupEngineer = new SupervisorEngineer(engineer.getId(), engineer.getName(),
						engineer.getSurname(), role);
				newSupEngineer.setAssignments(engineer.getAssignments());
				EngineerCatalog.removeEngineer(engineer);
				break;
			default:
				break;
		}
	}

}