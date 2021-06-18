package com.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.Diet;
import com.model.Role;
import com.model.Routine;
import com.model.TrainingPlan;
import com.model.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RoleService roleservice;
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getName(),
				registrationDto.getLastname(), registrationDto.getUsername(),
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getAge(),
				Arrays.asList(roleservice.listarNombre("cliente")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));	
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Autowired
	private UserRepository data;
	
	@Override
	public List<User> listar() {		
		return (List<User>)data.findAll();		
	}

	@Override
	public Optional<User> listarId(long id) {
		return data.findById(id);
	}

	@Override
	public int save(User u) {
		int res=0;
		
		if(u.getPassword() != null) {
			String password = passwordEncoder.encode(u.getPassword());
			u.setPassword(password);
		}
		User user = data.save(u);
		
		if(!user.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(User u) {
		if(u != null) {
			u.setRoles(null);
			data.delete(u);
		}
	}
}



