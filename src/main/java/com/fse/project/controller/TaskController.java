package com.fse.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.Task;
import com.fse.project.service.TaskService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080","http://localhost:8085"},maxAge = 4800, allowCredentials = "false")
public class TaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	TaskService taskService;
	
	
	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task){
		return taskService.createTask(task);
	}
	
	@PutMapping("/updateTask/{taskId}")
	public String updateTask(@RequestBody Task task, @PathVariable Long taskId) throws JsonProcessingException{
		Task updateTask = new Task();
		String response = null;
		updateTask =  taskService.updateTask(task, taskId);
		if(updateTask.getTaskId()!=0){
			response  = objectMapper.writeValueAsString(updateTask);
		}
		else{
			response = "Error";
		}
		return response;
	}
	
	@GetMapping("/getTask/{taskId}")
	public Task getTask (@PathVariable Long taskId){
		return taskService.getTask(taskId);
	}
	
	@GetMapping("/getAllTasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("/getTasksbyProjectId/{projectId}")
	public List<Task> getTasksbyProjectId(@PathVariable long projectId){
		return taskService.getTasksbyProjectId(projectId);
	}
	
	@GetMapping("/deleteTask/{taskId}")
	public String deleteTask (@PathVariable Long taskId){
		return taskService.deleteTask(taskId);
	}

}
