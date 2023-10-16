package org.lessons.java.pizzeria_crud.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.lessons.java.pizzeria_crud.api.dto.PizzaDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 128, nullable=false)
	@NotBlank(message="cannot be blank")
	@Length(min = 3, message="must be at least 3 characters")
	private String name;
	
	@NotBlank(message="cannot be blank")
	@Length(min = 3, max = 255, message="must be at least 3 character and less of 255")
	private String description;
	
	@NotBlank(message="cannot be empty")
	private String picture;
	
	@Positive(message="must be strictly positive")
	private float price;
	
	@OneToMany(mappedBy = "pizza")
	@JsonManagedReference
	private List<Promo> promos;
	
	@ManyToMany
	@JsonManagedReference
	private List<Ingredient> ingredients;
	
	public Pizza() {}
	public Pizza(String name, String description, String picture, float price, Ingredient... ingredients) {
		setName(name);
		setDescription(description);
		setPicture(picture);
		setPrice(price);
		setIngredients(Arrays.asList(ingredients));
	}
	public Pizza(PizzaDTO pizza) {
		setName(pizza.getName());
		setDescription(pizza.getDescription());
		setPicture(pizza.getPicture());
		setPrice(pizza.getPrice());
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
	
	public List<Promo> getPromos() {
		return promos;
	}
	public void setPromos(List<Promo> promos) {
		this.promos = promos;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public boolean hasIngredient(Ingredient ingredient) {
		if(getIngredients() == null) return false;
		
		for(Ingredient tempIngredient : getIngredients()) {
			if(tempIngredient.getId() == ingredient.getId()) return true;
		}
		
		return false;
	}
	
	public void addIngredients(Ingredient... ingredients) {
		getIngredients().addAll(Arrays.asList(ingredients));
	}
	
	public void fillFromPizzaDTO(PizzaDTO pizzaDTO) {
		setName(pizzaDTO.getName());
		setDescription(pizzaDTO.getDescription());
		setPicture(pizzaDTO.getPicture());
		setPrice(pizzaDTO.getPrice());
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pizza)) return false;
		Pizza incomingPizza = (Pizza)obj;
		return getId() == incomingPizza.getId();
	}
	
	public void removeIngredients(Ingredient... ingredients) {
		getIngredients().removeAll(Arrays.asList(ingredients));
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
