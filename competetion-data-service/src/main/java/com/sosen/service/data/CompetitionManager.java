package com.sosen.service.data;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class CompetitionManager extends DataProvider {
	private Gson gson = new GsonBuilder().create();
	
	public List<League> getLeaguesForCountry(int countryCode) {
		String resp = executeApi("https://apiv2.apifootball.com/?action=get_leagues&country_id="+countryCode+"&APIkey=");

		Type listType = new TypeToken<List<League>>() {
		}.getType();
		return gson.fromJson(resp, listType);
	}	
}
