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
import com.model.User;
import com.service.RoleService;
import com.service.UserService;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService service;
	@Autowired
	private RoleService roleservice;

	@GetMapping("/list")
	public String listar(Model model) {
		List<User>users=service.listar();
		model.addAttribute("users",users);
		model.addAttribute("roles", roleservice.listar());
		return "list_users";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable long id) {
		service.delete(service.listarId(id).get());
		return "redirect:/list";
	}
	
	@PostMapping("/save")
	public String save(@Validated User u, Model Model) {
		service.save(u);
		return "redirect:/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<User>user=service.listarId(id);
		model.addAttribute("user", user);
		model.addAttribute("roles", roleservice.listar());
		return "form-user";
	}
}
