package com.fse.project.service;

import java.util.List;

import com.fse.project.model.Task;

public interface TaskService {
	
	public Task createTask(Task task);
	
	public Task updateTask(Task task, long taskId);
	
	public Task getTask(long taskId);
	
	public List<Task> getAllTasks();
	
	public String deleteTask(long taskId);

}
