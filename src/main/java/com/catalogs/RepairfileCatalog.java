package com.catalogs;

import com.carops.Assignment;
import com.carops.Customer;
import com.carops.Repairfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class RepairfileCatalog {
	private static ArrayList<Repairfile> repairfiles = new ArrayList<>();

	public static Collection<Repairfile> fetchRepairfiles() {
		return repairfiles;
	}

	public static void addRepairfile(Repairfile repairfile) {
		repairfiles.add(repairfile);
	}

	public static Repairfile fetchRepairfilebyVehicle(String plateNumber) {
		Repairfile vehicleRepairfile = null; // vehicle not found
		for (Repairfile repairfile : repairfiles) {
			if (repairfile.getVehicle().getPlateNumber().equalsIgnoreCase(plateNumber))
				vehicleRepairfile = repairfile;
		}
		return vehicleRepairfile;
	}

	public static void printData() {
		int i = 1;
		System.out.printf("\n> All Repair Files in catalog:\nn %-25s  %-10s  %-13s  %-10s  %-8s  %-8s  %-4s\n",
				"Repair duration in days", "Status",
				"Plate number", "Type", "Est. Jobs", "Assigned Jobs", "Total Cost");
		for (Repairfile rp : repairfiles) {
			System.out.printf("%d", i);
			rp.printData();
			i++;
		}
	}

	public static void printAssignments() {
		System.out.println("\n> All Assignments with pending completion:");
		for(Repairfile repairfile : fetchRepairfiles()){
			System.out.println("Repair file with plate number " + repairfile.getVehicle().getPlateNumber() + ":");
			System.out.printf("%-20s |%-20s |%-10s |%-15s\n", "Engineer surname", "Job name", "Worktime", "Status");
			for(Assignment assignment : repairfile.getAssignments()){
				if(!assignment.getStatus())
					assignment.printData();
			}
		}
	}

	public void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream("repairfiles.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(repairfiles);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public ArrayList<Repairfile> getRepairfilesFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream("repairfiles.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			repairfiles = (ArrayList<Repairfile>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			exc1.printStackTrace();
		}
		return repairfiles;
	}

}