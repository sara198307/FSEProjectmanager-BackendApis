package com.fse.project.service;

import java.util.List;

import com.fse.project.model.ParentTask;

public interface ParentService {

	
public ParentTask createParent(ParentTask task);
	
	public ParentTask updateParent(ParentTask parentTask, long taskId);
	
	public ParentTask getParent(long taskId);
	
	public List<ParentTask> getAllParent();
	
	public String deleteParent(long taskId);
}
