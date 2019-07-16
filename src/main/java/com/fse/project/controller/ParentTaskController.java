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
import com.fse.project.model.ParentTask;
import com.fse.project.service.ParentService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080","http://localhost:8085"},maxAge = 4800, allowCredentials = "false")
public class ParentTaskController {
	

	
	private static final Logger logger = LoggerFactory.getLogger(ParentTaskController.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Autowired
	ParentService parentService;
	
	
	@PostMapping("/addParentTask")
	public ParentTask addParentTask(@RequestBody ParentTask parent){
		return parentService.createParent(parent);
	}
	
	@PutMapping("/updateParentTask/{parentId}")
	public String updateParentTask(@RequestBody ParentTask parent, @PathVariable Long parentId) throws JsonProcessingException{
		ParentTask updateParent = new ParentTask();
		String response = null;
		updateParent =  parentService.updateParent(parent, parentId);
		if(updateParent.getParentId()!=0){
			response  = objectMapper.writeValueAsString(updateParent);
		}
		else{
			response = "Error";
		}
		return response;
	}
	
	@GetMapping("/getParent/{parentId}")
	public ParentTask getParent (@PathVariable Long parentId){
		return parentService.getParent(parentId);
	}
	
	@GetMapping("/getAllParent")
	public List<ParentTask> getAllParent(){
		return parentService.getAllParent();
	}
	
	@GetMapping("/deleteParent/{parentId}")
	public String deleteParent (@PathVariable Long parentId){
		return parentService.deleteParent(parentId);
	}



}
