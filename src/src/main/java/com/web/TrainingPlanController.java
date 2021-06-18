package com.web;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Diet;
import com.model.Routine;
import com.model.TrainingPlan;
import com.service.DietService;
import com.service.RoutineService;
import com.service.TrainingPlanService;

@Controller
@RequestMapping
public class TrainingPlanController {

	@Autowired
	private TrainingPlanService service;
	@Autowired
	private RoutineService serviceroutine;
	@Autowired
	private DietService servicediet;

	@GetMapping("/list-trainingplan")
	public String listar(Model model) {
		List<TrainingPlan>trainingplans=service.listar();
		model.addAttribute("trainingplans",trainingplans);
		model.addAttribute("routine", serviceroutine.listar());
		model.addAttribute("diet", servicediet.listar());
		return "list_trainingplans";
	}
	
	@GetMapping("/new-trainingplan")
	public String agregar(Model model) {
		model.addAttribute("trainingplan",new TrainingPlan());
		model.addAttribute("routines", serviceroutine.listar());
		model.addAttribute("diets", servicediet.listar());
		return "form-plans";
	}
	
	@PostMapping("/save-trainingplan")
	public String save(@ModelAttribute TrainingPlan trainingplan) {
		//Routine routinee = serviceroutine.listarId()
		
		Set<Routine> routines = new HashSet();
		Set<Diet> diets = new HashSet();
		
		for (Routine r : trainingplan.getRoutines()) {
			Routine routine = serviceroutine.listarId(r.getId()).get();
			Set<TrainingPlan> t = routine.getTrainingplans();
			t.add(trainingplan);
			routine.setTrainingplans(t);
			//serviceroutine.save(routine);
			routines.add(routine);
		}
		trainingplan.setRoutines(routines);
		
		for (Diet d : trainingplan.getDiets()) {
			Diet diet = servicediet.listarId(d.getId()).get();
			Set<TrainingPlan> t = diet.getTrainingplans();
			t.add(trainingplan);
			diet.setTrainingplans(t);
			//servicediet.save(diet);
			diets.add(diet);
		}
		trainingplan.setDiets(diets);
		
		service.save(trainingplan);
		
		return "redirect:/list-trainingplan";
	}
	
	@GetMapping("/delete-trainingplan/{id}")
	public String delete(Model model, @PathVariable long id) {
		service.delete(service.listarId(id).get());
		return "redirect:/list-trainingplan";
	}
}
