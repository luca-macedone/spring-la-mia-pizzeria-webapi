package org.lessons.java.pizzeria_crud.db.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Promo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 128, nullable=false)
	@NotBlank(message="cannot be blank")
	@Length(min = 3, message="must be at least 3 characters")
	private String title;
	
	@Column(nullable=false)
	private LocalDate starting_date;
	
	@Column(nullable=false)
	private LocalDate ending_date;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pizza pizza;
	
	public Promo() {}
	
	public Promo(String title, LocalDate starting_date, LocalDate ending_date, Pizza pizza) {
		setTitle(title);
		setStarting_date(starting_date);
		setEnding_date(ending_date);
		setPizza(pizza);
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
	public LocalDate getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(LocalDate starting_date) {
		this.starting_date = starting_date;
	}
	public LocalDate getEnding_date() {
		return ending_date;
	}
	public void setEnding_date(LocalDate ending_date) {
		this.ending_date = ending_date;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public Pizza getPizza() {
		return pizza;
	}
	
	@Override
	public String toString() {
		return "[" + getId() + "] Promo:\n"
					+ "title: " + getTitle() + "\n"
					+ "starting_date: " + getStarting_date() + "\n"
					+ "ending_date: " + getEnding_date();
	}
	
	public static String formattedDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MMMM yyyy");
		String formattedDate = date.format(formatter);
		return formattedDate;
	}
}
