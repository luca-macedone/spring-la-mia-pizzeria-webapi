package org.lessons.java.pizzeria_crud.db.repo;


import org.lessons.java.pizzeria_crud.db.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUsername(String name);
}
