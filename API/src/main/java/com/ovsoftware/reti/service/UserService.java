package com.ovsoftware.reti.service;

import java.util.List;

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
		
	public User createUser(String username, String walletAdress) {
		boolean isActiveParticipant = true;
		User user = new User(username, walletAdress, isActiveParticipant);
		repository.save(user);
		return user;
	}
	
	public User getUser(String username) {	
		return repository.findByUsername(username);
	}
	
	public List<User> getActiveUsers() {	
		boolean isActiveParticipant = true;
		return repository.findByActiveParticipant(isActiveParticipant);
	}
	
	public void deleteUser(User user) {	
		repository.delete(user);
	}
}