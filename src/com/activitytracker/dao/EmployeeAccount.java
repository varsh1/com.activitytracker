package com.activitytracker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;
import com.activitytracker.dto.*;
import com.activitytracker.utilities.DatabaseUtils;
public class EmployeeAccount {

	public static EmployeeDetailsResponse checkIfEmployeeExists(UserLogin userlogin) {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con= DatabaseUtils.getConnection();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.LOGIN_QUERY);
			preparedstatement.setString(1, userlogin.getUserName());
			preparedstatement.setString(2, userlogin.getPassword());
			rs = preparedstatement.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt(DatabaseFields.EMPLOYEE_ID);
				String employeeName = rs.getString(DatabaseFields.EMPLOYEE_NAME);
				String department = rs.getString(DatabaseFields.DEPARTMENT);
				int roleId = rs.getInt(DatabaseFields.ROLE);
				EmployeeDetailsResponse employeedetails = new EmployeeDetailsResponse();
				employeedetails.setEmployeeId(employeeId);
				employeedetails.setEmployeeName(employeeName);
				employeedetails.setDepartment(department);
				employeedetails.setRoleId(roleId);
				return employeedetails;
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
}
