package com.sosen.service.data;

import com.google.gson.annotations.SerializedName;

public class League {
	@SerializedName("league_name")
	private String name;
	@SerializedName("league_id")
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
