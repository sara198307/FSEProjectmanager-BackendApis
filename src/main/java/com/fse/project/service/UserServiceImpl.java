package com.fse.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fse.project.model.User;
import com.fse.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	ObjectMapper objectMapper = new ObjectMapper();

	
	@Autowired
	UserRepository userRepository;
	
	
	public User createUser(User user) {
		
		User newuser = userRepository.save(user);
		return newuser;
	}


	@Override
	public User getUser(long userId) {
		Optional<User> getUser = userRepository.findById(userId);
		String user = "";
		User userInfo = null; 
		if(getUser.isPresent()){
			userInfo = getUser.get();
		}	
		return userInfo;
	}


	@Override
	public List<User> getAllUsers() {
    List<User> users= (List<User>) userRepository.findAll();	
		return users;		
	}


	@Override
	public String deleteUser(long userId) {
		String status = null;
		try{
			userRepository.deleteById(userId);
		 status = "Success";
		}
		catch(Exception e){
			status = "Error";
		}
		return status; 
	}


	@Override
	public User updateUser(User user, long userId) {
		Optional<User> userfromDb = userRepository.findById(userId);
		User updateUser = new User();
		if(userfromDb.isPresent()){
			updateUser = userfromDb.get();
			updateUser.setUserId(userId);;
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setEmpId(user.getEmpId());
			updateUser.setProjectId(user.getProjectId());
			updateUser.setTaskId(user.getTaskId());
			userRepository.save(updateUser);
		}
		else{
			updateUser = new User();
		}
		return updateUser;
	}	

}
