package com.sosen;

import com.google.gson.annotations.SerializedName;

public class Stat {
	@SerializedName("country_name")
	private String countryName;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("league_id")
	private String leagueId;
	
	@SerializedName("team_name")
	private String teamName;

	@SerializedName("league_name")
	private String leagueName;

	@SerializedName("overall_league_position")
	private int overallPosition;

	@SerializedName("home_league_position")
	private int homePosition;

	@SerializedName("away_league_position")
	private int awayPosition;
	
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getOverallPosition() {
		return overallPosition;
	}

	public void setOverallPosition(int overallPosition) {
		this.overallPosition = overallPosition;
	}

	public int getHomePosition() {
		return homePosition;
	}

	public void setHomePosition(int homePosition) {
		this.homePosition = homePosition;
	}

	public int getAwayPosition() {
		return awayPosition;
	}

	public void setAwayPosition(int awayPosition) {
		this.awayPosition = awayPosition;
	}
}
