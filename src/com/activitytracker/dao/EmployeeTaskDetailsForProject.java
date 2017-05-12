package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;

import com.activitytracker.dto.EmployeeTaskDetails;
import com.activitytracker.utilities.DatabaseUtils;

public class EmployeeTaskDetailsForProject {

	private static Logger exceptionLogger = Logger.getLogger(EmployeeTaskDetailsForProject.class.getName());
	private static Logger consoleLogger = Logger.getLogger(EmployeeTaskDetailsForProject.class.getName());
	
	public static ArrayList<EmployeeTaskDetails> getTasksForEmployeesBasedOnProject(int employeeId, int projectId) throws SQLException {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con = DatabaseUtils.getConnection();
		ArrayList<EmployeeTaskDetails> taskList = new ArrayList<EmployeeTaskDetails>();
		try {

			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_TASKS_BASED_ON_EMPLOYEE_AND_PROJECT);
			preparedstatement.setInt(1, projectId);
			preparedstatement.setInt(2, employeeId);
			rs = preparedstatement.executeQuery();
			
			while (rs.next()) {
				int taskId = rs.getInt(DatabaseFields.TASK_ID);
				String taskName = rs.getString(DatabaseFields.TASK_NAME);
				String status = rs.getString(DatabaseFields.STATUS);
				String comments = rs.getString(DatabaseFields.COMMENTS);
				int estimatedTime = rs.getInt(DatabaseFields.ESTIMATED_TIME);
				int hoursLogged = rs.getInt(DatabaseFields.HOURS_LOGGED);
				Date loggedDate = rs.getDate(DatabaseFields.DATE_LOGGED);
				EmployeeTaskDetails task = new EmployeeTaskDetails();
				
				task.setProjectId(projectId);
				task.setAssignee(employeeId);
				task.setTaskName(taskName);
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setStatus(status);
				task.setComments(comments);
				task.setEstimatedTime(estimatedTime);
				task.setHoursLogged(hoursLogged);
				if(loggedDate!=null) {
					java.util.Date logdate = new java.util.Date(loggedDate.getTime());
					task.setLoggedDate(logdate);
					consoleLogger.info(logdate.toString());
				}
				else {
					task.setLoggedDate(loggedDate);
					
				}
				
				taskList.add(task);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} finally {
			DatabaseUtils.closeDatabaseResources(rs, preparedstatement, con);
		}
		return taskList;

	}
	
	public static void addTasksForEmployee(EmployeeTaskDetails employeetasks) throws SQLException {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con = DatabaseUtils.getConnection();
		
		try {

			preparedstatement = con.prepareStatement(DatabaseQueries.ADD_EMPLOYEE_TASKS);
			preparedstatement.setInt(1, employeetasks.getProjectId());
			preparedstatement.setInt(2, employeetasks.getTaskId());
			preparedstatement.setString(3, employeetasks.getTaskName());
			preparedstatement.setString(4, employeetasks.getStatus());
			preparedstatement.setString(5, employeetasks.getComments());
			preparedstatement.setInt(6, employeetasks.getAssignee());
			preparedstatement.setInt(7, employeetasks.getEstimatedTime());
			preparedstatement.setInt(8, employeetasks.getHoursLogged());
			Date date = new java.sql.Date(employeetasks.getLoggedDate().getTime());
			preparedstatement.setDate(9, date);
			
			consoleLogger.info("add task for employee"+date.toString());
			
			preparedstatement.executeUpdate();
			

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
			
		} finally {
			DatabaseUtils.closeDatabaseResources(rs, preparedstatement, con);
			
		}
		
	}

	public static ArrayList<EmployeeTaskDetails> getTasksForProject(int projectId) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con = DatabaseUtils.getConnection();
		ArrayList<EmployeeTaskDetails> taskList = new ArrayList<EmployeeTaskDetails>();
		try {

			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_TASKS_FOR_PROJECT);
			preparedstatement.setInt(1, projectId);
			
			rs = preparedstatement.executeQuery();
			
			while (rs.next()) {
				int taskId = rs.getInt(DatabaseFields.TASK_ID);
				String taskName = rs.getString(DatabaseFields.TASK_NAME);
				String employeeName =rs.getString("employee.employeename");
				String status = rs.getString(DatabaseFields.STATUS);
				String comments = rs.getString(DatabaseFields.COMMENTS);
				int estimatedTime = rs.getInt(DatabaseFields.ESTIMATED_TIME);
				int hoursLogged = rs.getInt(DatabaseFields.HOURS_LOGGED);
				Date loggedDate = rs.getDate(DatabaseFields.DATE_LOGGED);
				EmployeeTaskDetails task = new EmployeeTaskDetails();
				
				task.setProjectId(projectId);
				task.setAssigneeName(employeeName);
				task.setTaskName(taskName);
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setStatus(status);
				task.setComments(comments);
				task.setEstimatedTime(estimatedTime);
				task.setHoursLogged(hoursLogged);
				if(loggedDate!=null) {
				java.util.Date logdate = new java.util.Date(loggedDate.getTime());
				task.setLoggedDate(logdate);
				}
				else {
					task.setLoggedDate(loggedDate);
				}
				
				taskList.add(task);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
			
		} finally {
			DatabaseUtils.closeDatabaseResources(rs, preparedstatement, con);
		}
		return taskList;

		
	}

	public static ArrayList<EmployeeTaskDetails> getTasksForEmployee(int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con = DatabaseUtils.getConnection();
		ArrayList<EmployeeTaskDetails> taskList = new ArrayList<EmployeeTaskDetails>();
		try {

			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_TASKS_FOR_EMPLOYEE);
			
			preparedstatement.setInt(1, employeeId);
			rs = preparedstatement.executeQuery();
			
			while (rs.next()) {
				int projectId = rs.getInt(DatabaseFields.PROJECT_ID);
				String projectName = rs.getString("project.projectname");
				int taskId = rs.getInt(DatabaseFields.TASK_ID);
				String taskName = rs.getString(DatabaseFields.TASK_NAME);
				String status = rs.getString(DatabaseFields.STATUS);
				String comments = rs.getString(DatabaseFields.COMMENTS);
				int estimatedTime = rs.getInt(DatabaseFields.ESTIMATED_TIME);
				int hoursLogged = rs.getInt(DatabaseFields.HOURS_LOGGED);
				Date loggedDate = rs.getDate(DatabaseFields.DATE_LOGGED);
				EmployeeTaskDetails task = new EmployeeTaskDetails();
				
				task.setProjectId(projectId);
				task.setProjectName(projectName);
				task.setAssignee(employeeId);
				task.setTaskName(taskName);
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				task.setStatus(status);
				task.setComments(comments);
				task.setEstimatedTime(estimatedTime);
				task.setHoursLogged(hoursLogged);
				if(loggedDate!=null) {
				java.util.Date logdate = new java.util.Date(loggedDate.getTime());
				
				task.setLoggedDate(logdate);
				}
				else {
					task.setLoggedDate(loggedDate);
				}
				
				taskList.add(task);
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
			
		} finally {
			DatabaseUtils.closeDatabaseResources(rs, preparedstatement, con);
		}
		return taskList;
		
	}
	
	
}
