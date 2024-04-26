package com.example.project_managment_system.exception;

public class ProjectNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectNotFoundException(String message) {
        super(message);
    }
}
