package com.fse.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.ParentTask;
import com.fse.project.model.Task;
import com.fse.project.repository.ParentTaskRepository;

@Service
public class ParentServiceImpl implements ParentService{

	
	private static final Logger logger = LoggerFactory.getLogger(ParentServiceImpl.class);
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Autowired
	ParentTaskRepository parentRepository;
	@Override
	public ParentTask createParent(ParentTask task) {
		ParentTask parentTask = parentRepository.save(task);
		return parentTask;
	}

	@Override
	public ParentTask updateParent(ParentTask parentTask, long taskId) {
		Optional<ParentTask> parentfromDb = parentRepository.findById(taskId);
		ParentTask updateParent = new ParentTask();
		if(parentfromDb.isPresent()){
			updateParent = parentfromDb.get();
			updateParent.setParentId(taskId);
			updateParent.setParentTask(parentTask.getParentTask());
			updateParent = parentRepository.save(updateParent);
		}
		else{
			updateParent = new ParentTask();
		}
		return updateParent;
	}

	@Override
	public ParentTask getParent(long taskId) {
		Optional<ParentTask> getParentTask = parentRepository.findById(taskId);
		ParentTask taskInfo = null; 
		if(getParentTask.isPresent()){
			taskInfo = getParentTask.get();
		}	
		return taskInfo;

	}

	@Override
	public List<ParentTask> getAllParent() {
		List<ParentTask> tasks= (List<ParentTask>)parentRepository.findAll();	
		return tasks;
	}

	@Override
	public String deleteParent(long taskId) {
		String status = null;
		try{
			parentRepository.deleteById(taskId);
		 status = "Success";
		}
		catch(Exception e){
			status = "Error";
		}
		return status; 
	}
	
	

}
