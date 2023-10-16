package org.lessons.java.pizzeria_crud.db.repo;

import java.util.List;

import org.lessons.java.pizzeria_crud.db.pojo.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepo extends JpaRepository<Promo, Integer> {
	public List<Promo> findByTitle(String title);
}
