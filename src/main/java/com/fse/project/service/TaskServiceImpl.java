package com.fse.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.Task;
import com.fse.project.model.User;
import com.fse.project.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public Task createTask(Task task) {
		Task newTask = taskRepository.save(task);
		return newTask;

	}

	@Override
	public Task updateTask(Task task, long taskId) {
		Optional<Task> taskfromDb = taskRepository.findById(taskId);
		Task updateTask = new Task();
		if(taskfromDb.isPresent()){
			updateTask = taskfromDb.get();
			updateTask.setTaskId(taskId);
			updateTask.setParentId(task.getParentId());
			updateTask.setProjectId(task.getProjectId());
			updateTask.setTask(task.getTask());
			updateTask.setPriority(task.getPriority());
			updateTask.setStatus(task.getStatus());
			updateTask.setStartDate(task.getStartDate());
			updateTask.setEndDate(task.getEndDate());
			taskRepository.save(updateTask);
		}
		else{
			updateTask = new Task();
		}
		return updateTask;
	}

	@Override
	public Task getTask(long taskId) {
		Optional<Task> getTask = taskRepository.findById(taskId);
		String task = "";
		Task taskInfo = null; 
		if(getTask.isPresent()){
			taskInfo = getTask.get();
		}	
		return taskInfo;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks= (List<Task>)taskRepository.findAll();	
		return tasks;
	}

	@Override
	public String deleteTask(long taskId) {
		String status = null;
		try{
			taskRepository.deleteById(taskId);
		 status = "Success";
		}
		catch(Exception e){
			status = "Error";
		}
		return status; 
	}	
	

}
