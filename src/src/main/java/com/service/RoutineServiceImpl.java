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
import com.repository.RoutineRepository;

@Service
public class RoutineServiceImpl implements RoutineService {

	@Autowired
	private RoutineRepository data;
	
	@Override
	public List<Routine> listar() {
		return (List<Routine>)data.findAll();	
	}

	@Override
	public Optional<Routine> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(Routine r) {
		int res=0;
		Routine routine=data.save(r);
		if(!routine.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Routine r) {
		if(r != null) {
			Set<TrainingPlan> trainingplans = r.getTrainingplans();
			for (TrainingPlan t : trainingplans) {
				Set<Routine> rou = t.getRoutines();
				Set<Routine> newRou = new HashSet<Routine>();
				for(Routine ro : rou) {
					if(ro.getId() != r.getId()) {
						newRou.add(ro);
					}
				}
				t.setRoutines(newRou);
			}
			data.delete(r);
		}
	}

}
