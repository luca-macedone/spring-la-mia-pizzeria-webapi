package org.lessons.java.pizzeria_crud.db.serv;

import java.util.List;

import org.lessons.java.pizzeria_crud.db.pojo.Ingredient;
import org.lessons.java.pizzeria_crud.db.repo.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepo ingredientRepo;
	
	public List<Ingredient> findAll(){
		return ingredientRepo.findAll();
	}
	
	public Ingredient findById(int id) {
		return ingredientRepo.findById(id).get();
	}
	
	public void save(Ingredient ingredient) {
		ingredientRepo.save(ingredient);
	}
	
	public void deleteIngredient(Ingredient ingredient) {
		ingredientRepo.delete(ingredient);
	}
}
