package com.carops;

import com.catalogs.JobCatalog;

import java.io.Serializable;

public class Job implements Serializable {

	private String name, description;
	private int price;

	public Job(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;

		// Αυτόματη προσθήκη του αντικείμενου Job στον κατάλογο των Job
		JobCatalog.addJob(this);
	}

	public float getPrice() {
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
}