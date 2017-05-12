package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;
import com.activitytracker.dto.BasicEmployeeDetails;

import com.activitytracker.utilities.DatabaseUtils;

public class ManagerEmployeeDetails {

	public static ArrayList<BasicEmployeeDetails> getEmployeeManagertDetails(int managerId,int projectId) {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con= DatabaseUtils.getConnection();
		ArrayList<BasicEmployeeDetails> employeeList = new ArrayList<BasicEmployeeDetails>();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_EMPLOYEE_UNDER_MANAGER);
			preparedstatement.setInt(1, projectId);
			preparedstatement.setInt(2, managerId);
			System.out.println(projectId);
			rs = preparedstatement.executeQuery();
			
			while(rs.next()) {
				
				int employeeId = rs.getInt(DatabaseFields.EMPLOYEE_EMPLOYEE_ID);
				String employeeName = rs.getString(DatabaseFields.EMPLOYEE_EMPLOYEE_NAME);
				BasicEmployeeDetails employeedetails = new BasicEmployeeDetails();
				employeedetails.setEmployeeId(employeeId);
				employeedetails.setEmployeeName(employeeName);
				employeeList.add(employeedetails);
				
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
		
		return employeeList;
	}
}
