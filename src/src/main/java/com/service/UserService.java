package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.model.User;
import com.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	public List<User>listar();
	public Optional<User>listarId(long id);
	public int save(User u);
	public void delete(User u);
}
