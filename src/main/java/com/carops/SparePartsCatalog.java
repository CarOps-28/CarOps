package com.carops;

import com.carops.SparePart;

import java.util.ArrayList;
import java.util.LinkedList;

public class SparePartsCatalog {
	private static ArrayList<SparePart> spareParts = new ArrayList<>();

	public static ArrayList<SparePart> fetchSpareParts() {
		// TODO - implement SparePartsCatalog.fetchSpareParts
		return spareParts;
	}

	public static void printData(){
		int i=1;
		System.out.printf("\n> All Spare part:\nn %-25s  %10s\n", "Name", "Price per quantity");
		for (SparePart sp :
				spareParts) {
			System.out.printf("%d|",i);
			sp.printData();
			i++;
		}
	}

	public static SparePart findSpareByName(String s){
		SparePart outsp = null;
		for (SparePart sp :
				spareParts) {
			if (s.equalsIgnoreCase(sp.getName())){
				outsp = sp;
				break;
			}
		}
		return outsp;
	}

	public static void addSparePart(SparePart sparep) {
		spareParts.add(sparep);
	}
}