package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Routine;

public interface RoutineService {
	public List<Routine>listar();
	public Optional<Routine>listarId(long id);
	public int save(Routine r);
	public void delete(Routine r);
}
