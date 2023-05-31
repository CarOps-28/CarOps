package com.carops;

public class Job {

	private String name;
	private int price;
	private String description;

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
		System.out.printf("%-25s  |%-3d\u20ac\n", name, price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}