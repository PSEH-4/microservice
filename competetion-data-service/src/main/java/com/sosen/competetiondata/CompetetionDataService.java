package com.sosen.competetiondata;

import java.util.List;

import com.sosen.service.AbstractService;
import com.sosen.service.data.CompetitionManager;
import com.sosen.service.data.Country;
import com.sosen.service.data.CountryManager;
import com.sosen.service.data.League;
import com.sosen.service.data.Team;
import com.sosen.service.data.TeamManager;

public class CompetetionDataService extends AbstractService {
	public CompetetionDataService() {
	}

	public List<Country> getCountries(String notUsed) {
		return new CountryManager().getCountries();

	}

	public List<Team> getTeams(String leagueId) {
		return new TeamManager().getTeamsByLeague(Integer.parseInt(leagueId));
	}

	public List<League> getLeagues(String countryCode) {
		return new CompetitionManager().getLeaguesForCountry(Integer.parseInt(countryCode));
	}
}
