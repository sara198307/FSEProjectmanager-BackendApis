package com.fse.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fse.project.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

	@Query("SELECT bk FROM Task bk WHERE bk.projectId = ?1")
	 public List<Task> GetTaskByProjectId(@Param("projectId") long projectId);
}
