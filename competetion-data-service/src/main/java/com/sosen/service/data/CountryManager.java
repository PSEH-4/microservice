package com.sosen.service.data;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class CountryManager extends DataProvider {
	private Gson gson = new GsonBuilder().create();

	public List<Country> getCountries() {
		String resp = executeApi("https://apiv2.apifootball.com/?action=get_countries&APIkey=");

		Type listType = new TypeToken<List<Country>>() {
		}.getType();
		return gson.fromJson(resp, listType);
	}

}
