package com.fse.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARENT_TASK")
public class ParentTask implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "Parent_ID")
		private long parentId;
	    
	    @Column(name = "Parent_Task")
	    private String parentTask;

		public long getParentId() {
			return parentId;
		}

		public void setParentId(long parentId) {
			this.parentId = parentId;
		}

		public String getParentTask() {
			return parentTask;
		}

		public void setParentTask(String parentTask) {
			this.parentTask = parentTask;
		}
	    
	    
	    
}
