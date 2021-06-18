package com.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Diet;
import com.service.DietService;

@Controller
@RequestMapping
public class DietController {

	@Autowired
	private DietService service;

	@GetMapping("/list-diets")
	public String listar(Model model) {
		List<Diet>diets=service.listar();
		model.addAttribute("diets",diets);
		return "list_diets";
	}
	
	@GetMapping("/new-diet")
	public String agregar(Model model) {
		model.addAttribute("diet",new Diet());
		return "form-diet";
	}
	
	@PostMapping("/save-diet")
	public String save(@Validated Diet d, Model Model) {
		service.save(d);
		return "redirect:/list-diets";
	}
	
	@GetMapping("/delete-diet/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(service.listarId(id).get());
		return "redirect:/list-diets";
	}
	
	@GetMapping("/edit-diet/{id}")
	public String edit(@PathVariable long id, Model model) {
		Optional<Diet>diet=service.listarId(id);
		model.addAttribute("diet",diet);
		return "form-diet";
	}
	
}
