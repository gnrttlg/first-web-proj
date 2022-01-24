package com.tc.web01.controller.entity;

public class UserInfo {
	private String name;
	private String surname;
	private String login;
	private String password;
	private String address;
	public UserInfo(String name, String surname, String login, String password, String address) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
