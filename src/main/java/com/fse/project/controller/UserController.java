package com.fse.project.controller;

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
import com.fse.project.model.User;
import com.fse.project.service.UserService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080","http://localhost:8085"},maxAge = 4800, allowCredentials = "false")
public class UserController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	UserService userService;
	
	
	
	@PostMapping("/addUser")
	public User addUser (@RequestBody User user){
		return userService.createUser(user);
	}
	
	@PutMapping("/updateUser/{userId}")
	public String update (@RequestBody User user, @PathVariable Long userId) throws JsonProcessingException{
		User updateUser = new User();
		String response = null;
		updateUser =  userService.updateUser(user, userId);
		if(updateUser.getUserId()!=0){
			response  = objectMapper.writeValueAsString(updateUser);
		}
		else{
			response = "Error";
		}
		return response;
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUser (@PathVariable Long userId){
		return userService.getUser(userId);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser (@PathVariable Long userId){
		return userService.deleteUser(userId);
	}
}
