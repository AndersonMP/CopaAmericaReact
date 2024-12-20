package com.krakedev.copa.entidades;

public class Forecast {

	private int fcastId;
	private User user;
	private FootballMatch match;
	private Country team1;
	private int scoreT1;
	private Country team2;
	private int scoreT2;

	public Forecast() {

	}

	// Constructor
	public Forecast(int fcastId, User user, FootballMatch match, Country team1, int scoreT1, Country team2,
			int scoreT2) {
		this.fcastId = fcastId;
		this.user = user;
		this.match = match;
		this.team1 = team1;
		this.scoreT1 = scoreT1;
		this.team2 = team2;
		this.scoreT2 = scoreT2;
	}

	// Constructor
	public Forecast(User user, FootballMatch match, Country team1, int scoreT1, Country team2, int scoreT2) {
		this.user = user;
		this.match = match;
		this.team1 = team1;
		this.scoreT1 = scoreT1;
		this.team2 = team2;
		this.scoreT2 = scoreT2;
	}

	// Getters y Setters
	public int getFcastId() {
		return fcastId;
	}

	public void setFcastId(int fcastId) {
		this.fcastId = fcastId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FootballMatch getMatch() {
		return match;
	}

	public void setMatch(FootballMatch match) {
		this.match = match;
	}

	public Country getTeam1() {
		return team1;
	}

	public void setTeam1(Country team1) {
		this.team1 = team1;
	}

	public int getScoreT1() {
		return scoreT1;
	}

	public void setScoreT1(int scoreT1) {
		this.scoreT1 = scoreT1;
	}

	public Country getTeam2() {
		return team2;
	}

	public void setTeam2(Country team2) {
		this.team2 = team2;
	}

	public int getScoreT2() {
		return scoreT2;
	}

	public void setScoreT2(int scoreT2) {
		this.scoreT2 = scoreT2;
	}
}
