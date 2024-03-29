package com.fse.project.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.Project;
import com.fse.project.service.ProjectService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080","http://localhost:8085"},maxAge = 4800, allowCredentials = "false")
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Autowired
	ProjectService projectService;
	
	
	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project){
		
		Project project1 = new Project();
		project1 = projectService.createProject(project);
		System.out.println(project.getManager());
		//projectService.updateuser(project1.getProjectId(),project1.getManager());
		return project1; 
	}
	
	@PutMapping("/updateProject/{projectId}")
	public String updateProject(@RequestBody Project project, @PathVariable Long projectId) throws JsonProcessingException{
		Project updateProject = new Project();
		String response = null;
		updateProject =  projectService.updateProject(project, projectId);
		if(updateProject.getProjectId()!=0){
			response  = objectMapper.writeValueAsString(updateProject);
		}
		else{
			response = "Error";
		}
		return response;
	}
	
	@GetMapping("/getProject/{projectId}")
	public Project getProject (@PathVariable Long projectId){
		return projectService.getProject(projectId);
	}
	
	@GetMapping("/getAllProjects")
	public List<Project> getAllProjects() throws ParseException{
		return projectService.getAllProjects();
	}
	
	@DeleteMapping("/deleteProject/{projectId}")
	public String deleteProject (@PathVariable Long projectId){
		return projectService.deleteProject(projectId);
	}

}
