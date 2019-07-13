package com.fse.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.fse.project.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

}
