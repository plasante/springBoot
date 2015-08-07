package com.uniksoft.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniksoft.entities.User;
import com.uniksoft.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void populate() {
		User user = new User("plasante","123456");
		userRepository.saveAndFlush(user);
		user = new User("cspenard","123456");
		userRepository.saveAndFlush(user);
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User saveAndFlush(User user) {
		if (user != null) {
			user = userRepository.saveAndFlush(user);
		}
		return user;
	}
	
	public void delete(long id) {
		userRepository.delete(id);
	}
}
