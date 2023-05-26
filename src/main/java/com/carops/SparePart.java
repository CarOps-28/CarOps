package com.carops;

public class SparePart {

	private String name;
	private int availableQuantity;
	private int price;

	public SparePart(String name, int availableQuantity, int price) {
		this.name = name;
		this.availableQuantity = availableQuantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}