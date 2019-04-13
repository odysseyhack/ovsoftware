package com.ovsoftware.reti.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ovsoftware.reti.domain.Project;

/**
 * Responsible for Project crud operations.
 */

public interface ProjectRepository extends MongoRepository<Project, String> {
	
	public Project findByName(String name);
	
	public List<Project> findByActive(boolean isActive);

}
