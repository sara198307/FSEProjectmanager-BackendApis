package com.fse.project.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fse.project.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	
	@Transactional
	@Modifying
	@Query("UPDATE User U SET U.projectId = :projectId WHERE U.firstName = :firstName")
	 public void updateUserProjectId(@Param("projectId") long projectId, @Param("firstName") String firstName);
}
