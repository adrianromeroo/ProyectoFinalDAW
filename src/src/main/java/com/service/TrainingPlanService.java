package com.service;

import java.util.List;
import java.util.Optional;

import com.model.TrainingPlan;

public interface TrainingPlanService {
	public List<TrainingPlan>listar();
	public Optional<TrainingPlan>listarId(long id);
	public int save(TrainingPlan t);
	public void delete(TrainingPlan t);
}
