package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.*;

import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;
import com.activitytracker.utilities.DatabaseUtils;



public class EmployeeDetails {
	private static Logger exceptionLogger = Logger.getLogger(EmployeeDetails.class.getName());
	public static String getRoleName(int roleId) {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con= DatabaseUtils.getConnection();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_ROLENAME_FROM_ROLEID);
			preparedstatement.setInt(1, roleId);
			rs = preparedstatement.executeQuery();
			while(rs.next()) {
				
				String roleName = rs.getString(DatabaseFields.ROLENAME);
				return roleName;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseUtils.closeResultSet(rs);
			DatabaseUtils.closePreparedStatement(preparedstatement);
			DatabaseUtils.closeConnection(con);
		}
		return null;
	
	}
	
	public static ArrayList<Integer> getProjectDetailsforEmployee(int employeeId) throws SQLException {
		
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		ArrayList<Integer>projectIdList=new ArrayList<Integer>();
		Connection con= DatabaseUtils.getConnection();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_PROJECT_FOR_EMPLOYEE);
			preparedstatement.setInt(1, employeeId);
			rs = preparedstatement.executeQuery();
			while(rs.next()) {
				
				int projectId = rs.getInt(DatabaseFields.PROJECT_ID);
				projectIdList.add(projectId);
				
			}
			//return projectIdList;
			
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
	
		return projectIdList;
	}
}
