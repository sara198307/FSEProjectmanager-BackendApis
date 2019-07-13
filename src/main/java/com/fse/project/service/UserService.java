package com.fse.project.service;

import java.util.List;

import com.fse.project.model.User;

public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user,long userId);
	
	public User getUser(long userId);
	
	public List<User> getAllUsers();
	
	public String deleteUser(long userId); 
	
}
