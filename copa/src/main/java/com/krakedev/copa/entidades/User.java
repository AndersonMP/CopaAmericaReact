package com.krakedev.copa.entidades;

public class User {

	private int userId;
	private String cedula;
	private String userName;
	private String userLastName;

	public User() {

	}

	// Constructor
	public User(int userId, String cedula, String userName, String userLastName) {
		this.userId = userId;
		this.cedula = cedula;
		this.userName = userName;
		this.userLastName = userLastName;
	}

	// Constructor
	public User(String cedula, String userName, String userLastName) {
		this.cedula = cedula;
		this.userName = userName;
		this.userLastName = userLastName;
	}
	
	// Constructor
		public User(int userId) {
			this.userId = userId;
		}

	// Getters y Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
}
