package org.lessons.java.pizzeria_crud.db.repo;

import java.util.List;

import org.lessons.java.pizzeria_crud.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
	public List<Pizza> findByName(String name);
	public List<Pizza> findByNameContaining(String name);
	public List<Pizza> findByNameOrDescriptionContaining(String name, String description);
}
