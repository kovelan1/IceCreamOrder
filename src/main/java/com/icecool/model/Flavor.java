package com.icecool.model;

import java.util.List;

public class Flavor {

	private String name;
	private double price;
	private List<Condiment> availableCondiments;
	
	public Flavor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public List<Condiment> getAvailableCondiments() {
		return availableCondiments;
	}

	public void setAvailableCondiments(List<Condiment> availableCondiments) {
		this.availableCondiments = availableCondiments;
	}
}
