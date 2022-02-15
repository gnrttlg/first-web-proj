package com.tc.web01.controller.entity;

import java.util.Objects;

public class Good {
	String title;
	float Price;
	String description;
	int storageID;
	int countInStorage;

	public Good() {
	}

	public Good(String title, float price, String description, int storageID, int countInStorage) {
		this.title = title;
		Price = price;
		this.description = description;
		this.storageID = storageID;
		this.countInStorage = countInStorage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStorageID() {
		return storageID;
	}

	public void setStorageID(int storageID) {
		this.storageID = storageID;
	}

	public int getCountInStorage() {
		return countInStorage;
	}

	public void setCountInStorage(int countInStorage) {
		this.countInStorage = countInStorage;
	}

	@Override
	public String toString() {
		return "Good [title=" + title + ", Price=" + Price + ", description=" + description + ", storageID=" + storageID
				+ ", countInStorage=" + countInStorage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Price, countInStorage, description, storageID, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Good other = (Good) obj;
		return Float.floatToIntBits(Price) == Float.floatToIntBits(other.Price)
				&& countInStorage == other.countInStorage && Objects.equals(description, other.description)
				&& storageID == other.storageID && Objects.equals(title, other.title);
	}

}
