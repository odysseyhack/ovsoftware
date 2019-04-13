package com.ovsoftware.reti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ovsoftware.reti.domain.User;

/**
 * Responsible for User crud operations.
 */

public interface UserRepository extends MongoRepository<User, String> {
	
    public User findByUsername(String username);
    
    public List<User> findAll();
    
    public List<User> findByActiveParticipant(boolean isActiveParticipant);

}