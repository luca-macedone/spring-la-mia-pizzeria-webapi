package org.lessons.java.pizzeria_crud.api;

import java.util.List;
import java.util.Optional;

import org.lessons.java.pizzeria_crud.api.dto.PizzaDTO;
import org.lessons.java.pizzeria_crud.db.pojo.Pizza;
import org.lessons.java.pizzeria_crud.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PizzaRestController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getAll() {
		List<Pizza> pizzas = pizzaService.findAll();
		return new ResponseEntity<List<Pizza>>(pizzas, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody PizzaDTO pizzaDTO){
		Pizza pizza = new Pizza(pizzaDTO);
		pizza = pizzaService.save(pizza);
		
		return new ResponseEntity<>(pizza.getId(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pizza> getPizza(@PathVariable int id){
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		
		if (pizzaOpt.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else {
		   return new ResponseEntity<>(pizzaOpt.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping("{id}")
	public ResponseEntity<Pizza> updatePizza(@PathVariable int id, @RequestBody PizzaDTO pizzaDTO){
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		
		if (pizzaOpt.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Pizza pizza = pizzaOpt.get();
		pizza.fillFromPizzaDTO(pizzaDTO);
		
		try {
			pizza = pizzaService.save(pizza);
			return new ResponseEntity<>(pizza, HttpStatus.OK);
		}catch(Exception E) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deletePizza(@PathVariable int id){
		Optional<Pizza> pizzaOpt = pizzaService.findById(id);
		
		if(pizzaOpt.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Pizza pizza = pizzaOpt.get();
		pizzaService.deletePizza(pizza);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
