package com.example.project_managment_system.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_managment_system.entity.Project;
import com.example.project_managment_system.exception.ProjectNotFoundException;
import com.example.project_managment_system.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@Validated

@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping("/create")
	ResponseEntity<?> createProject(@Valid @RequestBody Project project){
		return projectService.createProject(project);
	}
	
	@GetMapping("/getall")
	ResponseEntity<?> getAllProject(){
		return projectService.getAllProject();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> findProjectById(@PathVariable int id){
try {
	
	return projectService.findProjectById(id);

}
	
	
	catch (NoSuchElementException e) {

            throw new ProjectNotFoundException("Project not found with provided ID: " + id);
        }
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteProjectById(@PathVariable int id){
		return  projectService.deleteProjectById(id);
	}
	
	@PutMapping("/update")
	ResponseEntity<?> updateProject(@Valid @RequestBody Project project){
		return projectService.updateProject(project);
	}
	
}
