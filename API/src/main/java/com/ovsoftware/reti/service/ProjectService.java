package com.ovsoftware.reti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ovsoftware.reti.domain.Project;
import com.ovsoftware.reti.repository.ProjectRepository;

/**
 * Responsible for processing Project actions.
 */

@Component
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
		
	public void createProject(String name, String description, String category, int target) {
		Project project = new Project(name, description, category, target);
		repository.save(project);
	}
	
	public Project getProject(String name) {	
		return repository.findByName(name);
	}
	
	public List<Project> getActiveProjects() {	
		boolean isActive = true;
		return repository.findByActive(isActive);
	}
	
	public void updateProgress(String name, int progress) {	
		Project project = getProject(name);
		project.setProgress(progress);
		repository.save(project);
	}
	
	public void deleteProject(Project project) {	
		repository.delete(project);
	}
}
