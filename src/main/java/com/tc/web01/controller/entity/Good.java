package com.tc.web01.controller.entity;

import java.util.Objects;

public class Good{
	private int id;
	private String title;
	private float price;
	private String description;
	private int storageID;
	private int countInStorage;
	private boolean inCart;

	public Good() {
	}

	public Good(int id, String title, float price, String description, int storageID, int countInStorage) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.storageID = storageID;
		this.countInStorage = countInStorage;
		inCart = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public boolean isInCart() {
		return inCart;
	}

	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", title=" + title + ", Price=" + price + ", description=" + description
				+ ", storageID=" + storageID + ", countInStorage=" + countInStorage + ", isInCart=" + inCart + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, countInStorage, description, id, inCart, storageID, title);
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
		return Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& countInStorage == other.countInStorage && Objects.equals(description, other.description)
				&& id == other.id && inCart == other.inCart && storageID == other.storageID
				&& Objects.equals(title, other.title);
	}



}
