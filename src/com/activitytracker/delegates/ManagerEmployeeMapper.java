package com.activitytracker.delegates;

import java.util.ArrayList;
import java.util.HashSet;

import com.activitytracker.dao.ManagerEmployeeDetails;
import com.activitytracker.dto.*;
public class ManagerEmployeeMapper {

	public static HashSet<EmployeeManagerDetails> getEmployeesUnderManager(int managerId, HashSet<Integer>projectList) {
		HashSet<EmployeeManagerDetails> finalEmployeeSet = new HashSet<EmployeeManagerDetails>();
		for(int projectId: projectList) {
			ArrayList<EmployeeManagerDetails> employeeList = ManagerEmployeeDetails.getEmployeeManagertDetails(managerId,projectId);
			finalEmployeeSet.addAll(employeeList);
			
		}
		return finalEmployeeSet;
	}
}
