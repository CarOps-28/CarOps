
package com.catalogs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.carops.Engineer;
import com.carops.Processes;

public class EngineerCatalog {
	private static ArrayList<Engineer> engineers = new ArrayList<>();

	public static ArrayList<Engineer> fetchEngineers() {
		return engineers;
	}

	public static Engineer fetchEngineerByName(String name) {
		for (Engineer engineer : engineers) {
			if (engineer.getName().equalsIgnoreCase(name)) {
				return engineer;
			}
		}
		return null;
	}

	public static Engineer fetchEngineerById(String id) {
		for (Engineer engineer : engineers) {
			if (engineer.getId().equalsIgnoreCase(id)) {
				return engineer;
			}
		}
		return null;
	}

	public static void printData() {
		System.out.printf("\n> All Engineers in catalog:\nn %-8s  %-15s  %-15s  %-10s\n", "ID", "Name", "Surname",
				"Role");
		int i = 1;

		sortedEngineers();

		for (Engineer engineer : engineers) {
				System.out.printf("%d", i);
				engineer.printData();
				i++;
			}
	}

	public static void sortedEngineers(){
		ArrayList<String> ids = new ArrayList<>();
		for (Engineer engineer : engineers) {
			ids.add(engineer.getId());
		}

		ArrayList<Engineer> newEngineer = new ArrayList<>();
		Collections.sort(ids);

		for (String id : ids) {
			for (Engineer engineer : engineers) {
				if (engineer.getId().equals(id)) {
					newEngineer.add(engineer);
				}
			}
		}
		engineers = newEngineer;
	}
	public static void addEngineer(Engineer engineer) {
		engineers.add(engineer);
	}

	public static void removeEngineer(Engineer engineer) {
		engineers.remove(engineer);
	}

	public static void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Engineers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(engineers);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static boolean refreshDataFromFile() {
		try {
			FileInputStream fileIn = new FileInputStream("engineers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			engineers = (ArrayList<Engineer>) in.readObject();
			fileIn.close();
			in.close();
		} catch (IOException | ClassNotFoundException exc1) {
			return false;
		}
		return true;
	}

	public static Engineer searchEngineerByRole(String surname, String role) {
		for (Engineer engineer : engineers) {
			if (engineer.getRole().equals(role) &&
					Processes.removeTones(surname)
							.equalsIgnoreCase(Processes.removeTones(
									engineer.getSurname()))) {
				return engineer;
			}
		}
		return null;
	}
}