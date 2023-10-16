package org.lessons.java.pizzeria_crud.db.serv;

import java.util.List;

import org.lessons.java.pizzeria_crud.db.pojo.Pizza;
import org.lessons.java.pizzeria_crud.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepo pizzaRepo;
	
	public void save(Pizza pizza) {
		pizzaRepo.save(pizza);
	}
	
	public List<Pizza> findAll(){
		return pizzaRepo.findAll();
	}
	
	public Pizza findById(int id) {
		return pizzaRepo.findById(id).get();
	}
	
	public List<Pizza> findByName(String name){
		return pizzaRepo.findByNameOrDescriptionContaining(name, name);
	}
	
	public void deletePizza(Pizza pizza) {
		pizzaRepo.delete(pizza);
	}
}
