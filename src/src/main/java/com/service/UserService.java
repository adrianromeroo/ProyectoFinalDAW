package com.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.model.User;
import com.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
