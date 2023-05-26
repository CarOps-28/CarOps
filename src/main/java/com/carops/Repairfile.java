package com.carops;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Repairfile {

	private int price;
	private int worktime;
	private String status;
	private ArrayList<Assignment> assignments;
	private Vehicle vehicle;


	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void calculatePrice() {
		price = 0;

		if(status != "Accepted"){ // Estimated price calculation based solely on the estimated jobs.
			for(Assignment assignment: assignments) price += assignment.getJob().getPrice();
		}
		else if(status == "Completed"){ //Price calculation after repairs.

			for(Assignment assignment: assignments) {

				for(SparePart part : assignment.getSpareParts().keySet()){
					int partPrice = 0;
					int usedQuantity = assignment.getSpareParts().get(part);

					for(SparePart sparepart : SparePartsCatalog.fetchSpareParts()){
						if(part.equals(sparepart.getName()))
							partPrice = usedQuantity * sparepart.getPrice();
					}
					price += partPrice;
				}
			}
		}
	}

	public String getStatus() { return this.status; }

}