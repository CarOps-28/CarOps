
package com.carops;

import java.util.ArrayList;

public class EngineerCatalog {
	private static ArrayList<Engineer> engineers = new ArrayList<Engineer>();

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

	public static void printData() {
		System.out.printf("\n> All Engineers in catalog:\nn %-25s  %-10s\n", "Name", "Role");
		int i = 1;
		for (Engineer engineer : engineers) {
			System.out.printf("%d|", i);
			engineer.printData();
			i++;
		}
	}

	public static void addEngineer(Engineer engineer) {
		engineers.add(engineer);
	}

	public static void removeEngineer(Engineer engineer) {
		engineers.remove(engineer);
	}

}