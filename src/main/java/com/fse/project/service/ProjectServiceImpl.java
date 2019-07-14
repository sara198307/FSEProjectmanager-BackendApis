package com.fse.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.Project;
import com.fse.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public Project createProject(Project project) {
		Project newProject = projectRepository.save(project);
		return newProject;
	}
	public void updateuser(long projectId, String projectManager) {
		projectRepository.updateUserProjectId(projectId,projectManager);
	}
	
	@Override
	public Project updateProject(Project project, long projectId) {
		Optional<Project> projectfromDb = projectRepository.findById(projectId);
		Project updateProject = new Project();
		if(projectfromDb.isPresent()){
			updateProject = projectfromDb.get();
			updateProject.setProjectId(projectId);
			updateProject.setProject(project.getProject());
			updateProject.setPriority(project.getPriority());
			updateProject.setStartDate(project.getStartDate());
			updateProject.setEndDate(project.getEndDate());
			updateProject = projectRepository.save(updateProject);
		}
		else{
			updateProject = new Project();
		}
		return updateProject;
	}

	@Override
	public Project getProject(long projectId) {
		Optional<Project> getProject = projectRepository.findById(projectId);
		Project projectInfo = null; 
		if(getProject.isPresent()){
			projectInfo = getProject.get();
		}	
		return projectInfo;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects= (List<Project>)projectRepository.findAll();	
		return projects;
	}

	@Override
	public String deleteProject(long projectId) {
		String status = null;
		try{
			projectRepository.deleteById(projectId);
		 status = "Success";
		}
		catch(Exception e){
			status = "Error";
		}
		return status; 
	}	
	
}
