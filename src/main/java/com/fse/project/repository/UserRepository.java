package com.fse.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.fse.project.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	
}

