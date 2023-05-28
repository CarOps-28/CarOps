package com.carops;

import java.util.ArrayList;

public class SparePartsCatalog {
	private static ArrayList<SparePart> spareParts = new ArrayList<>();

	public static ArrayList<SparePart> fetchSpareParts() {
		return spareParts;
	}

	public static void printData() {
		int i = 1;
		System.out.printf("\n> All Spare part:\nn %-25s  %10s\n", "Name", "Price per unit");
		for (SparePart sp : spareParts) {
			System.out.printf("%d|", i);
			sp.printData();
			i++;
		}
	}

	public static SparePart findSpareByName(String name) {
		for (SparePart sparePart : spareParts) {
			if (name.equalsIgnoreCase(sparePart.getName())) {
				return sparePart;
			}
		}
		return null;
	}

	public static void addSparePart(SparePart sparep) {
		spareParts.add(sparep);
	}
}