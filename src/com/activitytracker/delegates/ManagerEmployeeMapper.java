package com.activitytracker.delegates;

import java.util.ArrayList;
import java.util.HashSet;

import com.activitytracker.dao.ManagerEmployeeDetails;
import com.activitytracker.dto.*;
public class ManagerEmployeeMapper {

	public static HashSet<BasicEmployeeDetails> getEmployeesUnderManager(int managerId, HashSet<Integer>projectList) {
		HashSet<BasicEmployeeDetails> finalEmployeeSet = new HashSet<BasicEmployeeDetails>();
		for(int projectId: projectList) {
			ArrayList<BasicEmployeeDetails> employeeList = ManagerEmployeeDetails.getEmployeeManagertDetails(managerId,projectId);
			finalEmployeeSet.addAll(employeeList);
			
		}
		return finalEmployeeSet;
	}
}
