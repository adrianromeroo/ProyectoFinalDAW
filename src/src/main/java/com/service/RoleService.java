package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Role;

public interface RoleService {
	public List<Role>listar();
	public Optional<Role>listarId(long id);
	public int save(Role r);
	public void delete(Role r);
	public Role listarNombre(String nombre);
}
