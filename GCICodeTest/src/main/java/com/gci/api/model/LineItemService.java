package com.gci.api.model;

import com.gci.api.Constants;

public class LineItemService {

	private int id = -1;
	
	private String name = Constants.UNKNOWN;
	
	private String description = Constants.UNKNOWN;;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
