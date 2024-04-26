package com.example.project_managment_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice

public class GlobalExceptionHandler {

	
	
	 @ExceptionHandler(ProjectNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    @ResponseBody
	    public ResponseEntity<?> handleProjectNotFoundException(ProjectNotFoundException ex) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", HttpStatus.NOT_FOUND.value());
	        response.put("message", "Project not found with provided ID");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
}
