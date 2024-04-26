package com.example.project_managment_system.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_managment_system.entity.Project;
import com.example.project_managment_system.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping("/create")
	ResponseEntity<?> createProject(@RequestBody Project project){
		return projectService.createProject(project);
	}
	
	@GetMapping("/getall")
	ResponseEntity<?> getAllProject(){
		return projectService.getAllProject();
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> findProjectById(@PathVariable long id){
		return projectService.findProjectById(id);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteProjectById(@PathVariable long id){
		return  projectService.deleteProjectByid(id);
	}
	
	@PutMapping("/update")
	ResponseEntity<?> updateProject(@RequestBody Project project){
		return projectService.updateProject(project);
	}
	
}
