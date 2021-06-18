package com.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Diet;
import com.model.TrainingPlan;
import com.repository.DietRepository;

@Service
public class DietServiceImpl implements DietService{

	@Autowired
	private DietRepository data;
	
	@Override
	public List<Diet> listar() {
		return (List<Diet>)data.findAll();	
	}

	@Override
	public Optional<Diet> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(Diet d) {
		int res=0;
		Diet diet=data.save(d);
		if(!diet.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Diet d) {
		if(d != null) {
			Set<TrainingPlan> trainingplans = d.getTrainingplans();
			for (TrainingPlan t : trainingplans) {
				Set<Diet> die = t.getDiets();
				Set<Diet> newDie = new HashSet<Diet>();
				for(Diet di : die) {
					if(di.getId() != d.getId()) {
						newDie.add(di);
					}
				}
				t.setDiets(newDie);
			}
			data.delete(d);
		}
	}

}
