package com.ovsoftware.reti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ovsoftware.reti.domain.Project;
import com.ovsoftware.reti.service.ProjectService;

/**
 * Responsible for processing http requests for Projects.
 */

@RestController
@CrossOrigin
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseEntity<Project> getProject(@RequestBody String name) {
		Project project = projectService.getProject(name);
		
		if(project != null) {
			return new ResponseEntity<>(project, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}	
    }
	
	@RequestMapping(value = "getActive", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getActiveProjects() {
		List<Project> projects = projectService.getActiveProjects();
		
		if(projects.isEmpty()) {
			return new ResponseEntity<>(projects, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}	
    }
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> createProject(@RequestBody String name, @RequestBody String description, @RequestBody String category, @RequestBody int target) {
		projectService.createProject(name, description, category, target);
        return ResponseEntity.ok().build();
    }
	
	@RequestMapping(value = "updateProgress", method = RequestMethod.POST)
    public ResponseEntity<?> updateProject(@RequestBody String name, @RequestBody int progress) {
		projectService.updateProgress(name, progress);
        return ResponseEntity.ok().build();
    }
}
