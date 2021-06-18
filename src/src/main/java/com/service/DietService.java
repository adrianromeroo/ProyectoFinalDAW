package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Diet;

public interface DietService {
	public List<Diet>listar();
	public Optional<Diet>listarId(long id);
	public int save(Diet d);
	public void delete(Diet d);
}
