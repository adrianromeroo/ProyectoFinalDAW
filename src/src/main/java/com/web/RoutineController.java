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
import com.model.Routine;
import com.service.RoutineService;

@Controller
@RequestMapping
public class RoutineController {
	
	@Autowired
	private RoutineService service;

	@GetMapping("/list-routines")
	public String listar(Model model) {
		List<Routine>routines=service.listar();
		model.addAttribute("routines",routines);
		return "list_routines";
	}
	
	@GetMapping("/new-routine")
	public String agregar(Model model) {
		model.addAttribute("routine",new Routine());
		return "form-routine";
	}
	
	@PostMapping("/save-routine")
	public String save(@Validated Routine r, Model Model) {
		service.save(r);
		return "redirect:/list-routines";
	}
	
	@GetMapping("/delete-routine/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(service.listarId(id).get());
		return "redirect:/list-routines";
	}
	
	@GetMapping("/edit-routine/{id}")
	public String edit(@PathVariable long id, Model model) {
		Optional<Routine>routine=service.listarId(id);
		model.addAttribute("routine",routine);
		return "form-routine";
	}
	
}
