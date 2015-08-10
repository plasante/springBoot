package com.uniksoft.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.common.base.Optional;
import com.uniksoft.entities.User;
import com.uniksoft.forms.UserCreateForm;
import com.uniksoft.repositories.UserRepository;

public class UsersServiceImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getUserById(long id) {
		return Optional.of(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setEmail(form.getEmail());
		user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setRole(form.getRole());
		return userRepository.save(user);
	}
	
	
}
