package com.carops;

import java.util.ArrayList;


public class RepairfileCatalog {
	private ArrayList<Repairfile> repairfiles = new ArrayList<Repairfile>();

	public static ArrayList<Repairfile> fetchRepairfiles() {
		// TODO - implement RepairfileCatalog.fetchRepairfiles
		throw new UnsupportedOperationException();
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

}