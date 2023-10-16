package org.lessons.java.pizzeria_crud.controller;

import java.util.List;
import org.lessons.java.pizzeria_crud.db.pojo.Pizza;
import org.lessons.java.pizzeria_crud.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class PizzaController {
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String showIndex(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> pizzas = name == null 
				? pizzaService.findAll()
				: pizzaService.findByName(name);
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String showPizza(Model model, @PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza",pizza);
		
		return "show";
	}
	
	@GetMapping("/create")
	public String createPizza(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "create";
	}
	
	@PostMapping("/create")
	public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.err.println("Error: ");
			bindingResult.getAllErrors().forEach(System.err::println);
			return "create";
		}else {
			try {
				pizzaService.save(pizza);
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return "create";
			}
		}
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String editPizza(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/update/{id}")
	public String updatePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.err.println("Error: ");
			bindingResult.getAllErrors().forEach(System.err::println);
			return "create";
		}else {
			try {
				pizzaService.save(pizza);
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return "create";
			}
		}
		return "redirect:/";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		pizzaService.deletePizza(pizza);
		return "redirect:/";
	}
}
