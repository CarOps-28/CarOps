package com.carops;

import com.catalogs.JobCatalog;
import com.catalogs.RepairfileCatalog;
import javafx.scene.control.CheckBox;

import java.io.Serializable;
import java.util.HashMap;

public class Job implements Serializable {

	private String name, description;
	private int price;

	public String getDescription() {
		return description;
	}

	public Job(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;

		// Αυτόματη προσθήκη του αντικείμενου Job στον κατάλογο των Job
		JobCatalog.addJob(this);
	}

	public int getPrice() {
		return this.price;
	}

	public void printData() {
		System.out.printf(" |%-25s  |%-3d\u20ac\n", name, price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CheckBox getCheckBox(){
		return new CheckBox();
	}
}