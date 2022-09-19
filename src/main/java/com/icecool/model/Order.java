package com.icecool.model;

import java.util.List;

public class Order {

	private String flavor;
	private List<String> condiments;
	private String cone;
	
	
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public List<String> getCondiments() {
		return condiments;
	}
	public void setCondiments(List<String> condiments) {
		this.condiments = condiments;
	}
	public String getCone() {
		return cone;
	}
	public void setCone(String cone) {
		this.cone = cone;
	}
	
	
	
	
}
