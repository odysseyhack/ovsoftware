package com.ovsoftware.reti;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ovsoftware.reti.domain.Project;
import com.ovsoftware.reti.service.ProjectService;

/**
 * Responsible for running Project tests.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RetiApplication.class,}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProjectTests {

	@Autowired
	private ProjectService projectService;

	@Test
	public void testProjectFlow() {
		String name = "Test";
		String description = "This is a test";
		String category = "Testing";
		int target = 100;
		Project project = projectService.createProject(name, description, category, target);
		Project created = projectService.getProject(project.getName());
		assertEquals(project.getName(), created.getName());
		assertEquals(project.getDescription(), created.getDescription());
		assertEquals(project.getCategory(), created.getCategory());
		assertEquals(project.getTarget(), created.getTarget());
		projectService.deleteProject(created);
	}

}
