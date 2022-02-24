package com.tc.web01.controller.entity;

import java.util.Objects;

public class Storage {
	private int id;
	private String name;
	private String address;
	
	public Storage() {
	}
	
	public Storage(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Storage [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Storage other = (Storage) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name);
	}
	
	

}
