package com.example.project_managment_system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_managment_system.entity.Project;
import com.example.project_managment_system.exception.ProjectNotFoundException;
import com.example.project_managment_system.repository.ProjectRepository;

@Service
public class ProjectService {

	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ResponseEntity<?> createProject(Project project){
		Project p=projectRepository.save(project);
		Map<Object, Object> m=new HashMap<>();
		m.put("status", 200);
		m.put("response", p);
		m.put("msg", "Project createdSuccessfully");
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<?> getAllProject(){
	List<Project> project=	projectRepository.findAll();
	if(project.size()==0) {
		Map<Object, Object> m=new HashMap<>();
		m.put("status", 404);
		m.put("msg", "No project found!!!!");
		return new ResponseEntity<>(m,HttpStatus.NOT_FOUND);
	}
	Map<Object, Object> m=new HashMap<>();
	m.put("status", 200);
	m.put("response", project);
	m.put("msg", "Project createdSuccessfully");
	return new ResponseEntity<>(m,HttpStatus.OK);
	}




	public ResponseEntity<?> findProjectById(int id) {
	Project p=	projectRepository.findById(id).orElseThrow();
	if(p==null) {
        throw new ProjectNotFoundException("Project not found with provided ID: " + id);

	}
	Map<Object,Object> m=new HashMap<>();
	m.put("status", 200);
	m.put("response",p );
	m.put("msg", "Project Found");
		return new ResponseEntity<>(m,HttpStatus.OK);
	}




	public ResponseEntity<?> deleteProjectById(int id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            projectRepository.deleteById( id);
            return ResponseEntity.ok("Project with ID " + id + " deleted successfully");
        } else {
            throw new ProjectNotFoundException("Project not found with ID: " + id);
        }
    }




	 public ResponseEntity<?> updateProject(Project project) {
	        int projectId = project.getId(); 

	        Optional<Project> existingProjectOptional = projectRepository.findById(projectId);
	        if (existingProjectOptional.isPresent()) {
	            Project existingProject = existingProjectOptional.get();
	            existingProject.setName(project.getName());
	            existingProject.setDescription(project.getDescription());
	            existingProject.setStartDate(project.getStartDate());
	            existingProject.setEndDate(project.getEndDate());
	            projectRepository.save(existingProject);
	            return ResponseEntity.ok("Project with ID " + projectId + " updated successfully");
	        } else {
	            throw new ProjectNotFoundException("Project not found with ID: " + projectId);
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
}
