package com.fse.project.service;

import java.util.List;

import com.fse.project.model.Project;

public interface ProjectService {

	
	public Project createProject(Project project);
	
	public Project updateProject(Project project, long projectId);
	
	public Project getProject(long projectId);
	
	public List<Project> getAllProjects();
	
	public String deleteProject(long projectId);
}
