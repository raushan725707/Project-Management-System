package com.example.project_managment_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.project_managment_system.entity.Project;
import com.example.project_managment_system.exception.ProjectNotFoundException;
import com.example.project_managment_system.repository.ProjectRepository;
import com.example.project_managment_system.service.ProjectService;


@SpringBootTest
class ProjectManagmentSystemApplicationTests {
	@Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;
	
	
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	public void testCreateProject_Failure() {
	    Project project = new Project();
	    project.setName("Test Project");
	    project.setDescription("Description of Test Project");

	    Mockito.when(projectRepository.save(project)).thenThrow(RuntimeException.class);

	    assertThrows(RuntimeException.class, () -> projectService.createProject(project));
	}

	@Test
	public void testGetAllProject_Success() {
	    List<Project> projects = new ArrayList<>();
	    projects.add(new Project(1, "Project 1", "Description 1"));
	    projects.add(new Project(2, "Project 2", "Description 2"));

	    Mockito.when(projectRepository.findAll()).thenReturn(projects);

	    ResponseEntity<?> response = projectService.getAllProject();

	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertTrue(response.getBody() instanceof Map);
	    Map<?, ?> responseBody = (Map<?, ?>) response.getBody();
	    assertEquals(projects.size(), ((List<?>) responseBody.get("response")).size());
	}

	@Test
	public void testFindProjectById_ProjectFound() {
	    int projectId = 1;
	    Project project = new Project(1, "Project 1", "Description 1");

	    Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

	    ResponseEntity<?> response = projectService.findProjectById(projectId);

	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertTrue(response.getBody() instanceof Map);
	    Map<?, ?> responseBody = (Map<?, ?>) response.getBody();
	    assertEquals("Project Found", responseBody.get("msg"));
	    assertEquals(project, responseBody.get("response"));
	}

	@Test
	public void testDeleteProjectById_Success() {
	    int projectId = 1;
	    Project project = new Project(1, "Project 1", "Description 1");

	    Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

	    ResponseEntity<?> response = projectService.deleteProjectById(projectId);

	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertEquals("Project with ID 1 deleted successfully", response.getBody());
	}

	@Test
	public void testDeleteProjectById_Failure() {
	    int projectId = 1;

	    Mockito.when(projectRepository.findById(projectId)).thenReturn(Optional.empty());

	    assertThrows(ProjectNotFoundException.class, () -> projectService.deleteProjectById(projectId));
	}

	@Test
	public void testUpdateProject_Success() {
	    Project existingProject = new Project(1, "Project 1", "Description 1");
	    Project updatedProject = new Project(1, "Updated Project 1", "Updated Description 1");

	    Mockito.when(projectRepository.findById(existingProject.getId())).thenReturn(Optional.of(existingProject));
	    Mockito.when(projectRepository.save(updatedProject)).thenReturn(updatedProject);

	    ResponseEntity<?> response = projectService.updateProject(updatedProject);

	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertEquals("Project with ID 1 updated successfully", response.getBody());
	}
	
	

}
