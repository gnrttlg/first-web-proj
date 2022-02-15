package com.tc.web01.controller.entity;

import java.util.Objects;

public class UserInfo {
	private int id;
	private String name;
	private String surname;
	private String login;
	private String address;

	public UserInfo() {
	}

	public UserInfo(String name, String surname, String login, String address) {
		this.id = 0;
		this.name = name;
		this.login = login;
		this.surname = surname;
		this.address = address;
	}

	public UserInfo(int id, String name, String surname, String login, String address) {
		this(name, surname, login, address);
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", surname=" + surname + ", login=" + login + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, login, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

}
