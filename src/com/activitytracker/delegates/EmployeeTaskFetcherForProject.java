package com.activitytracker.delegates;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;
import com.activitytracker.dao.EmployeeTaskDetailsForProject;
import com.activitytracker.dto.*;

public class EmployeeTaskFetcherForProject {
	private static Logger exceptionLogger = Logger.getLogger(EmployeeTaskDetailsForProject.class.getName());

	public static ArrayList<EmployeeTaskDetails> getEmployeeTaskDetailsForProject(EmployeeDetailsResponse employeedetails,int projectId) throws Exception {
		// TODO Auto-generated method stub
		
		int employeeId = employeedetails.getEmployeeId();
		ArrayList<EmployeeTaskDetails> taskList = EmployeeTaskDetailsForProject.getTasksForEmployeesBasedOnProject(employeeId, projectId);
		return taskList;
	}
	
	
	public static ArrayList<EmployeeTaskDetails> getTasksForProject(int projectId) throws Exception {
		ArrayList<EmployeeTaskDetails> taskList = null;
		try{
			 taskList = EmployeeTaskDetailsForProject.getTasksForProject(projectId);

		}catch(Exception e) {
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
		return taskList;
	}
	public static ArrayList<EmployeeTaskDetails> getTasksForEmployee(int employeeId) throws SQLException {
		
		ArrayList<EmployeeTaskDetails> taskList = EmployeeTaskDetailsForProject.getTasksForEmployee(employeeId);
		return taskList;
	}
	
}
