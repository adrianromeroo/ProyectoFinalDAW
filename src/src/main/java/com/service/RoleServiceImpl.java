package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Role;
import com.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository data;

	@Override
	public List<Role> listar() {
		return (List<Role>)data.findAll();	
	}

	@Override
	public Optional<Role> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(Role r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Role r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role listarNombre(String nombre) {
		return data.findByName(nombre);
		
	}
}
