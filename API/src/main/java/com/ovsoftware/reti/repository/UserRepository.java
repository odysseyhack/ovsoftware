package com.ovsoftware.reti.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ovsoftware.reti.domain.User;

/**
 * Responsible for User crud operations.
 */

public interface UserRepository extends MongoRepository<User, String> {
	
    public User findByUsername(String username);

}