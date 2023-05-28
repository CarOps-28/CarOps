package com.carops;

import java.util.ArrayList;
import java.util.Collection;


public class RepairfileCatalog {
	private static ArrayList<Repairfile> repairfiles = new ArrayList<Repairfile>();

	public static Collection<Repairfile> fetchRepairfiles() {
		return repairfiles;
	}

	public static void addRepairfile(Repairfile repairfile) {
		repairfiles.add(repairfile);
	}

	public static Repairfile fetchRepairfilebyVehicle(String plateNumber) {
		Repairfile vehicleRepairfile = null;
		for(Repairfile repairfile : repairfiles){
			if(repairfile.getVehicle().getPlateNumber().equals(plateNumber))
				vehicleRepairfile = repairfile;
		}
		return vehicleRepairfile;
	}

	public static void printData(){
		int i=1;
		System.out.printf("\n> All Repair File:\nn %-25s  %-10s\n", "Time in hour", "Total Cost");
		for (Repairfile rp :
				repairfiles) {
			System.out.printf("%d|",i);
			rp.printData();
			i++;
		}
	}


}