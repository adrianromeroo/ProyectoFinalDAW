package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.TrainingPlan;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long>{
	
}
