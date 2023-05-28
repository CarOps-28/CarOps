
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

	public static void addEngineer(Engineer engineer) {
		engineers.add(engineer);
	}

}