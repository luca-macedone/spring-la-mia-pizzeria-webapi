package org.lessons.java.pizzeria_crud;

import org.lessons.java.pizzeria_crud.db.pojo.Ingredient;
import org.lessons.java.pizzeria_crud.db.pojo.Pizza;
import org.lessons.java.pizzeria_crud.db.pojo.Role;
import org.lessons.java.pizzeria_crud.db.pojo.User;
import org.lessons.java.pizzeria_crud.db.serv.IngredientService;
import org.lessons.java.pizzeria_crud.db.serv.PizzaService;
import org.lessons.java.pizzeria_crud.db.serv.RoleService;
import org.lessons.java.pizzeria_crud.db.serv.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired 
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Ingredient ingr1 = new Ingredient("Tomato", "A rich, tangy, and savory condiment, perfect for pasta and pizza");
		Ingredient ingr2 = new Ingredient("Mozzarella", "Creamy, milky cheese, beloved in pizza, salads, and more");
		Ingredient ingr3 = new Ingredient("Basil", "A fragrant herb used in cooking, especially in Italian cuisine, known for its strong, sweet aroma and flavor");
		Ingredient ingr4 = new Ingredient("Olive Oil", null);
		Ingredient ingr5 = new Ingredient("Spicy Pepperoni slices", null);
		Ingredient ingr6 = new Ingredient("Pineapple", null);
		Ingredient ingr7 = new Ingredient("Ham", "Savory, smoked pork; a culinary delight");
		Ingredient ingr8 = new Ingredient("Anichokes", null);
		Ingredient ingr9 = new Ingredient("Mushorooms", null);
		Ingredient ingr10 = new Ingredient("Olives", "Olives are small, flavorful, and often brine-cured, versatile for salads, pizzas, and Mediterranean dishes");
		Ingredient ingr11 = new Ingredient("Sausages slices", "Delicately seasoned, savory, and perfectly thin cuts of flavorful meat, ideal for sandwiches, pizzas, or as a breakfast side");
		Ingredient ingr12 = new Ingredient("Vegetables", null);
		
		ingredientService.save(ingr1);
		ingredientService.save(ingr2);
		ingredientService.save(ingr3);
		ingredientService.save(ingr4);
		ingredientService.save(ingr5);
		ingredientService.save(ingr6);
		ingredientService.save(ingr7);
		ingredientService.save(ingr8);
		ingredientService.save(ingr9);
		ingredientService.save(ingr10);
		ingredientService.save(ingr11);
		ingredientService.save(ingr12);
		
		Pizza pizza1 = new Pizza("Margherita", "Thin crust, tomato sauce, fresh mozzarella, basil, and olive oil. Iconic Italian classic.", "https://images.unsplash.com/photo-1564936281291-294551497d81?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2852&q=80", 4.99f, ingr1, ingr2, ingr3, ingr4);
		Pizza pizza2 = new Pizza("Pepperoni", "Pepperoni american pizza features a classic dough base topped with tomato sauce, mozzarella cheese, and slices of spicy pepperoni.", "https://plus.unsplash.com/premium_photo-1668771085743-1d2d19818140?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80", 8.99f, ingr1, ingr2, ingr5);
		Pizza pizza3 = new Pizza("Hawaiian", "Hawaiian pizza includes ham and pineapple on a tomato sauce and cheese-covered dough base. Sweet and savory flavor combo.", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=781&q=80", 10.99f, ingr1, ingr2, ingr6);
		Pizza pizza4 = new Pizza("Four Seasons", "It typically includes ham, artichokes, mushrooms, and olives, each in its own quadrant, symbolizing the ingredients that are in season during different times of the year.", "https://cdn.cook.stbm.it/thumbnails/ricette/144/144880/hd750x421.jpg", 8.59f, ingr1, ingr7, ingr8, ingr9, ingr10);
		Pizza pizza5 = new Pizza("Wurstel", "Wurstel Pizza: Pizza topped with sliced sausages. A savory choice with a delightful blend of flavors.", "https://www.lospicchiodaglio.it/img/ricette/pizzawurstel.jpg", 6.79f, ingr1, ingr2, ingr11);
		Pizza pizza6 = new Pizza("Veggie supreme", "Veggie Supreme Pizza: Colorful mix of fresh vegetables on tomato sauce and mozzarella cheese-covered crust. Vegetarian delight!", "https://www.acouplecooks.com/wp-content/uploads/2019/04/Pizza-036.jpg", 12.00f, ingr2, ingr12);
		
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		pizzaService.save(pizza5);
		pizzaService.save(pizza6);
		
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");
		
		roleService.save(admin);
		roleService.save(user);
		
		final String pwsAdmin = new BCryptPasswordEncoder().encode("pws");
		final String pwsUser = new BCryptPasswordEncoder().encode("pws");
		
		User defAdmin = new User("admin", pwsAdmin, admin, user);
		User defUser = new User("user", pwsUser, user);
		
		userService.save(defAdmin);
		userService.save(defUser);
		
		System.out.println("!!--------!! Seeded the db with success !!--------!!");
	}

}
