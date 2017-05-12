package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
import java.util.logging.Level;

import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;
import com.activitytracker.dto.*;
import com.activitytracker.utilities.DatabaseUtils;
import java.util.logging.*;

public class ProjectDetails {
private static Logger exceptionLogger = Logger.getLogger(ProjectDetails.class.getName());
	public static ProjectDetailsResponse getProjectDetails(int projectId) throws SQLException {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con= DatabaseUtils.getConnection();
		ProjectDetailsResponse projectdetailsresponse = new ProjectDetailsResponse();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.FETCH_PROJECT_DETAILS);
			preparedstatement.setInt(1, projectId);
			System.out.println(projectId);
			rs = preparedstatement.executeQuery();
			while(rs.next()) {
				
				String projectName = rs.getString(DatabaseFields.PROJECT_NAME);
				int managerId = rs.getInt(DatabaseFields.MANAGER);
				Date startDate = rs.getDate(DatabaseFields.START_DATE);
				Date endDate = rs.getDate(DatabaseFields.END_DATE);
				projectdetailsresponse.setProjectId(projectId);
				projectdetailsresponse.setProjectName(projectName);
				projectdetailsresponse.setManagerId(managerId);
				projectdetailsresponse.setStartDate(startDate.toString());
				projectdetailsresponse.setEndDate(endDate.toString());
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
			
		}
		finally {
			DatabaseUtils.closeResultSet(rs);
			DatabaseUtils.closePreparedStatement(preparedstatement);
			DatabaseUtils.closeConnection(con);
		}
		
		return projectdetailsresponse;
	}
	
	public static String getManagerName(int employeeId) throws SQLException {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		
		Connection con= DatabaseUtils.getConnection();
		String managerName = null;
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_EMPLOYEENAME_FOR_EMPLOYEE);
			preparedstatement.setInt(1, employeeId);
			rs = preparedstatement.executeQuery();
			while(rs.next()) {
				
				managerName = rs.getString(DatabaseFields.EMPLOYEE_NAME);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
		finally {
			DatabaseUtils.closeResultSet(rs);
			DatabaseUtils.closePreparedStatement(preparedstatement);
			DatabaseUtils.closeConnection(con);
		}
		
		
		return managerName;
		
	}
}
