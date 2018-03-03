package com.sapient.models;

public class Role {

	private String type;

	public Role() {}
	
	public Role(String type) {
		this.type=type;
	}
	public String getType() {
		return type;
	}

	public void setType(String name) {
		this.type = name;
	}
	
}
