package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long>{
	
}
