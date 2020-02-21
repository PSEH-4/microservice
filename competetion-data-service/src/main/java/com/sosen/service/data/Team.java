package com.sosen.service.data;

import com.google.gson.annotations.SerializedName;

public class Team {
	@SerializedName("team_name")
	private String name;
	@SerializedName("team_key")
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
