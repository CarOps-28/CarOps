package com.carops;
public class Job {

	private String name;
	private float price;
	private String description;

	public Job(String name, float price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public float getPrice(){
		return this.price;
	}

	public void printData(){
		System.out.printf("%-25s |%-10f\n", name, price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}