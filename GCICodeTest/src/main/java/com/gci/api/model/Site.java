package com.gci.api.model;

import com.gci.api.Constants;

public class Site {

	private String name = Constants.UNKNOWN;
	
	private LineItemService service = new LineItemService();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LineItemService getService() {
		return service;
	}

	public void setService(LineItemService service) {
		this.service = service;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	private float price;
}
