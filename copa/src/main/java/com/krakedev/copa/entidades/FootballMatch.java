package com.krakedev.copa.entidades;

import java.sql.Timestamp;

public class FootballMatch {

	private int matchId;
	private Country team1;
	private Country team2;
	private Timestamp matchDate;
	private String fechaFormateada;

	public FootballMatch() {

	}

	// Constructor
	public FootballMatch(int matchId, Country team1, Country team2, Timestamp matchDate) {
		this.matchId = matchId;
		this.team1 = team1;
		this.team2 = team2;
		this.matchDate = matchDate;
	}

	// Constructor
	public FootballMatch(Country team1, Country team2, Timestamp matchDate) {
		this.team1 = team1;
		this.team2 = team2;
		this.matchDate = matchDate;
	}

	// Constructor
	public FootballMatch(int matchId) {
		this.matchId = matchId;
	}

	public FootballMatch(Country team1, Country team2, String fechaFormateada) {
		// TODO Auto-generated constructor stub
		this.team1 = team1;
		this.team2 = team2;
		this.setFechaFormateada(fechaFormateada);
	}

	// Getters y Setters
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Country getTeam1() {
		return team1;
	}

	public void setTeam1(Country team1) {
		this.team1 = team1;
	}

	public Country getTeam2() {
		return team2;
	}

	public void setTeam2(Country team2) {
		this.team2 = team2;
	}

	public Timestamp getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Timestamp matchDate) {
		this.matchDate = matchDate;
	}

	public String getFechaFormateada() {
		return fechaFormateada;
	}

	public void setFechaFormateada(String fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}
}
