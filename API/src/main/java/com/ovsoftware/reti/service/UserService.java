package com.ovsoftware.reti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ovsoftware.reti.domain.User;
import com.ovsoftware.reti.repository.UserRepository;

/**
 * Responsible for processing User actions.
 */

@Component
public class UserService {
	
	@Autowired
	private UserRepository repository;
		
	public void createUser(User user) {
		repository.save(user);
	}
	
	public User getUser(String username) {	
		return repository.findByUsername(username);
	}
	
	public void deleteUser(User user) {	
		repository.delete(user);
	}
}