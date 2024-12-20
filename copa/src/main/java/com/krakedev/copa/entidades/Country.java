package com.krakedev.copa.entidades;

public class Country {

	private int countryCode;
	private String countryName;
	private String countryIso3;
	
	public Country() {
		
	}

	// Constructor
	public Country(int countryCode, String countryName, String countryIso3) {
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.countryIso3 = countryIso3;
	}

	// Constructor
	public Country(String countryName) {
		this.countryName = countryName;

	}

	// Getters y Setters
	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryIso3() {
		return countryIso3;
	}

	public void setCountryIso3(String countryIso3) {
		this.countryIso3 = countryIso3;
	}
}
