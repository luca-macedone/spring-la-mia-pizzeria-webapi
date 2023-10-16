package org.lessons.java.pizzeria_crud.api.dto;

public class PizzaDTO {
	private int id;
	private String name;
	private String description;
	private String picture;
	private float price;
	
	public PizzaDTO() {}
	public PizzaDTO(String name) {
		setName(name);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] Pizza:\n"
					+ "name: " + getName() + "\n"
					+ "description: " + getDescription() + "\n"
					+ "picture_url: " + getPicture() + "\n"
					+ "price: " + getPrice();
	}
}
