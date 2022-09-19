package com.icecool.model;

import java.util.List;

public class IceCream {

	private Flavor flavor;
	private List<Condiment> condiments;
	private Cone cone;
	
	
	public IceCream() {
		// TODO Auto-generated constructor stub
	}


	public Flavor getFlavor() {
		return flavor;
	}


	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}


	public List<Condiment> getCondiments() {
		return condiments;
	}


	public void setCondiments(List<Condiment> condiments) {
		this.condiments = condiments;
	}


	public Cone getCone() {
		return cone;
	}


	public void setCone(Cone cone) {
		this.cone = cone;
	}
	
	
	
	
}
