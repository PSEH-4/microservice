package com.sosen.service.data;

import com.google.gson.annotations.SerializedName;

public class Country {
	@SerializedName("country_name")
	private String name;
	@SerializedName("country_id")
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
