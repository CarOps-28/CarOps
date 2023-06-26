package com.catalogs;

import com.carops.Repairfile;
import com.carops.SparePart;

import java.io.*;
import java.util.ArrayList;

public class SparePartsCatalog {
	private static String url = "files/spareParts.ser";

	private static ArrayList<SparePart> spareParts = new ArrayList<>();

	public static ArrayList<SparePart> fetchSpareParts() {
		return spareParts;
	}

	public static void printData() {
		int i = 1;
		System.out.printf("\n> All Spare Parts in catalog:\nn %-25s  |%-4s %10s\n", "Name", "A-Q","Price per unit");
		for (SparePart sp : spareParts) {
			System.out.printf("%d", i);
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

	// Παραλήφθηκε στο class diagram και προστίθεται τώρα.
	public static void addSparePart(SparePart sparePart) {
		spareParts.add(sparePart);
	}

	public static void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream(url);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(spareParts);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public static boolean refreshDataFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream(url);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			spareParts = (ArrayList<SparePart>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			return false;
		}
		return true;
	}
}