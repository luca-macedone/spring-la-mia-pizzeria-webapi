package org.lessons.java.pizzeria_crud.db.repo;

import org.lessons.java.pizzeria_crud.db.pojo.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

}
