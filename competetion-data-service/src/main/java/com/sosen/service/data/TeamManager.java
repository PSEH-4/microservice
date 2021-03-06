package com.sosen.service.data;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TeamManager extends DataProvider {
	private Gson gson = new GsonBuilder().create();

	public List<Team> getTeamsByLeague(int leagueId) {
		String resp = executeApi("https://apiv2.apifootball.com/?action=get_teams&league_id=" + leagueId + "&APIkey=");

		Type listType = new TypeToken<List<Team>>() {
		}.getType();
		return gson.fromJson(resp, listType);
	}

}
