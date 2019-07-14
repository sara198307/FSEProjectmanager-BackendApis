package com.fse.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable{

  private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Project_ID")
	private long projectId;
    
    @Column(name = "Project")
    private String project;
    
    
    @Column(name = "Priority")
	private long priority;
    
    
    @Column(name = "Start_Date")
	private String startDate;
	
	@Column(name = "End_Date")
	private String endDate;
	
	
	@Column(name = "Manager")
	private String manager;
	
	
	

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
  
	
}
