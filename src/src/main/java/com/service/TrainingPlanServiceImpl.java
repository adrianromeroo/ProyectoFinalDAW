package com.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Diet;
import com.model.Routine;
import com.model.TrainingPlan;
import com.repository.TrainingPlanRepository;

@Service
public class TrainingPlanServiceImpl implements TrainingPlanService {

	@Autowired
	private TrainingPlanRepository data;
	@Autowired
	private RoutineService serviceroutine;
	@Autowired
	private DietService servicediet;
	
	@Override
	public List<TrainingPlan> listar() {
		return (List<TrainingPlan>)data.findAll();	
	}

	@Override
	public Optional<TrainingPlan> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(TrainingPlan t) {
		data.save(t);
		return 0;
	}

	@Override
	public void delete(TrainingPlan t) {
		if(t != null) {
			for(Routine r : t.getRoutines()) {
				Routine ro = serviceroutine.listarId(r.getId()).get();
				Set<TrainingPlan> trainings = ro.getTrainingplans();
				Set<TrainingPlan> newTrainings = new HashSet<TrainingPlan>();
				for (TrainingPlan tp : trainings) {
					if(tp.getId() != t.getId()) {
						newTrainings.add(tp);
					}
				}
				ro.setTrainingplans(newTrainings);
				serviceroutine.save(ro);
			}
			
			for(Diet d : t.getDiets()) {
				Diet di = servicediet.listarId(d.getId()).get();
				Set<TrainingPlan> trainings = di.getTrainingplans();
				Set<TrainingPlan> newTrainings = new HashSet<TrainingPlan>();
				for (TrainingPlan tp : trainings) {
					if(tp.getId() != t.getId()) {
						newTrainings.add(tp);
					}
				}
				di.setTrainingplans(newTrainings);
				servicediet.save(di);
			}
			data.delete(t);
		}
	}

}
