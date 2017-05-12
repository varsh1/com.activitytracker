package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;
import com.activitytracker.dto.BasicEmployeeDetails;
import com.activitytracker.dto.EmployeeManagerDetails;
import com.activitytracker.utilities.DatabaseUtils;

public class ManagerEmployeeDetails {

	public static ArrayList<EmployeeManagerDetails> getEmployeeManagertDetails(int managerId,int projectId) {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con= DatabaseUtils.getConnection();
		ArrayList<EmployeeManagerDetails> employeeList = new ArrayList<EmployeeManagerDetails>();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_EMPLOYEE_UNDER_MANAGER);
			preparedstatement.setInt(1, projectId);
			preparedstatement.setInt(2, managerId);
			System.out.println(projectId);
			rs = preparedstatement.executeQuery();
			
			while(rs.next()) {
				
				int employeeId = rs.getInt(DatabaseFields.EMPLOYEE_EMPLOYEE_ID);
				String employeeName = rs.getString(DatabaseFields.EMPLOYEE_EMPLOYEE_NAME);
				EmployeeManagerDetails employeedetails = new EmployeeManagerDetails();
				employeedetails.setValue(Integer.toString(employeeId));
				employeedetails.setLabel(employeeName);
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
