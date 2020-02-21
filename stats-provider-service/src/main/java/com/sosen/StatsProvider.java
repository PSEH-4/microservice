package com.sosen;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class StatsProvider {

	public List<Stat> getStatFor(int league, int team) {
		String resp = new DataProvider()
				.executeApi("https://apiv2.apifootball.com/?action=get_standings&league_id=" + league + "&APIkey=");

		Gson gson = new GsonBuilder().create();
		Type listType = new TypeToken<List<Stat>>() {
		}.getType();
		List<Stat> stats = gson.fromJson(resp, listType);
		
		List<Stat> selectedStats = new ArrayList<Stat>();
		
		for(Stat stat : stats) {
			if(stat.getTeamId() == team) {
				selectedStats.add(stat);
			}
		}
		
		return selectedStats;
	}

}
