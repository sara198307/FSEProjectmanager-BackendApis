package com.fse.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fse.project.config.SpringDatabaseConfig;
import com.fse.project.model.ParentTask;
import com.fse.project.model.Project;
import com.fse.project.model.Task;
import com.fse.project.model.User;
import com.fse.project.service.ParentServiceImpl;
import com.fse.project.service.ProjectServiceImpl;
import com.fse.project.service.TaskServiceImpl;
import com.fse.project.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDatabaseConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FseProjectManagerApplicationTests {

	@Autowired
	ProjectServiceImpl projectServiceImpl ;
	
	@Autowired
	TaskServiceImpl taskServiceImpl ;
	
	@Autowired
	UserServiceImpl userServiceImpl ;
	
	@Autowired
	ParentServiceImpl parentServiceImpl ;
	
	//Adding  Project
		 @Test
		 public void AddProject()
		 {
		 Project pro = new Project();
		 pro.setProject("TestProject");
		 pro.setManager("TestManager");
		 pro.setPriority(13);
		 pro.setStartDate("2019-07-23");
		 pro.setEndDate("2020-07-23");
		 pro = projectServiceImpl.createProject(pro);
		 System.out.println("Project Added"+pro.getProjectId());
		 assertEquals("TestProject", pro.getProject());
		  }
		 
		//Update  Project
		 @Test
		 public void updateProject()
		 {
		 Project pro = new Project();
		 pro.setProject("TestProjectUpdated");
		 pro.setManager("TestManagerUpdate");
		 pro.setPriority(14);
		 pro.setStartDate("2019-07-23");
		 pro.setEndDate("2020-07-23");
		 pro = projectServiceImpl.updateProject(pro,18);
		 System.out.println("Project Updated:"+pro.getProjectId());
		 assertEquals("TestProjectUpdated", pro.getProject());
		  }
		 
		// Retrieving the Project
		   @Test
		   public void getProjectById()
		   {
		      Project pro = projectServiceImpl.getProject(18);
		      System.out.println("Project Exists"+pro.getProject());
		      assertEquals("TestProject", pro.getProject());
		  
		    }
		   
		 //Adding  Task
		   @Test
			 public void AddTask()
			 {
			 Task task = new Task();
			 task.setTask("Testtask");
			 task.setStartDate("2019-07-23");
			 task.setEndDate("2020-07-23");
			 task.setStatus("Active");
			 task.setParentId(18);
			 task.setPriority(10);
			 task = taskServiceImpl.createTask(task);
			 System.out.println("Task Added:"+task.getTask());
			 assertEquals("Testtask", task.getTask());
			  }
		   
		   //Update  Task
		   @Test
			 public void updateTask()
			 {
			 Task task = new Task();
			 task.setTask("TesttaskUpdated");
			 task.setStartDate("2019-07-23");
			 task.setEndDate("2020-07-23");
			 task.setStatus("Completed");
			 task.setParentId(18);
			 task.setPriority(6);
			 task = taskServiceImpl.updateTask(task,2);
			 System.out.println("Task Updated:"+task.getTask());
			 assertEquals("TesttaskUpdated", task.getTask());
			  }
		   
		   
		// Retrieving the Task
		   @Test
		   public void getTaskById()
		   {
		      Task task = taskServiceImpl.getTask(18);
		      System.out.println("Task Exists"+task.getTask());
		      assertEquals("Testtask", task.getTask());
		    }
		   
		 //Adding  User
		   @Test
			 public void AddUser()
			 {
			 User user = new User();
			 user.setFirstName("TestFirstName");
			 user.setLastName("LastName");
			 user.setEmpId(287564);
			 user = userServiceImpl.createUser(user);
			 System.out.println("User Added"+user.getFirstName());
			 assertEquals("TestFirstName", user.getFirstName());
			  }
		   //Update  User
		   @Test
			 public void updateUser()
			 {
			 User user = new User();
			 user.setFirstName("FirstNameUpdated");
			 user.setLastName("LastNameUpdated");
			 user.setEmpId(287534);
			 user = userServiceImpl.updateUser(user, 3);
			 System.out.println("User Updated:"+user.getFirstName());
			 assertEquals("FirstNameUpdated", user.getFirstName());
			  }
		   
		// Retrieving the User
		   @Test
		   public void getUserById()
		   {
		      User user = userServiceImpl.getUser(12);
		      System.out.println("User Exists"+user.getFirstName());
		      assertEquals("TestFirstName", user.getFirstName());
		    }
		   
		   //Adding  the Parent
		   @Test
			 public void AddParentTask()
			 {
			 ParentTask ptask = new ParentTask();
			 ptask.setParentTask("ParentTask");;

			 ptask = parentServiceImpl.createParent(ptask);
			 System.out.println("ParentTask Added"+ptask.getParentTask());
			 assertEquals("ParentTask", ptask.getParentTask());
			  }
}
