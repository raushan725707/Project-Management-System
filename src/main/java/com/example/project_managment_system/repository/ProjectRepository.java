package com.example.project_managment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project_managment_system.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
