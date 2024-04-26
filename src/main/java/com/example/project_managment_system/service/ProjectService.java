package com.example.project_managment_system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_managment_system.entity.Project;
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




	public ResponseEntity<?> findProjectById(long id) {
		// TODO Auto-generated method stub
		return null;
	}




	public ResponseEntity<?> deleteProjectByid(long id) {
		// TODO Auto-generated method stub
		return null;
	}




	public ResponseEntity<?> updateProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
