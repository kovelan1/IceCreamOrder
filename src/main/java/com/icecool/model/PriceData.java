package com.icecool.model;

import java.util.List;

public class PriceData {

	private List<Flavor> flavors;
	private List<Condiment> condiments;
	private List<Cone> cones;
	
	
	public List<Flavor> getFlavors() {
		return flavors;
	}
	public void setFlavors(List<Flavor> flavors) {
		this.flavors = flavors;
	}
	public List<Condiment> getCondiments() {
		return condiments;
	}
	public void setCondiments(List<Condiment> condiments) {
		this.condiments = condiments;
	}
	public List<Cone> getCones() {
		return cones;
	}
	public void setCones(List<Cone> cones) {
		this.cones = cones;
	}
	
	
}
