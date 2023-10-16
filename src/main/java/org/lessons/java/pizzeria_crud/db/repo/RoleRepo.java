package org.lessons.java.pizzeria_crud.db.repo;

import org.lessons.java.pizzeria_crud.db.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
