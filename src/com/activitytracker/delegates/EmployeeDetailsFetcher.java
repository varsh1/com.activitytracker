package com.activitytracker.delegates;
import com.activitytracker.dto.*;

import java.util.logging.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.activitytracker.dao.*;

public class EmployeeDetailsFetcher {
private static Logger exceptionLogger = Logger.getLogger(EmployeeDetailsFetcher.class.getName());
	public static EmployeeDetailsResponse populateEmployeeResponseObject(EmployeeDetailsResponse employeedetailsresponse) throws Exception{
		
		String roleName = getRoleName(employeedetailsresponse);
		employeedetailsresponse.setRoleName(roleName);
		ArrayList<Integer> projectIdList = getProjectDetailsforEmployee(employeedetailsresponse);
		ArrayList<ProjectDetailsResponse> projectList = new ArrayList<ProjectDetailsResponse>();
		for(int projectId : projectIdList) {
				ProjectDetailsResponse project = new ProjectDetailsResponse();
				project.setProjectId(projectId);
				try {
					project = ProjectDetailsFetcher.populateProjectDetails(project);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
					exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
					throw e;
				}
				projectList.add(project);
		}
		employeedetailsresponse.setProjectList(projectList);
		return employeedetailsresponse;
	}
	
	
	public static String getRoleName(EmployeeDetailsResponse employeedetailsresponse) {
		String roleName = EmployeeDetails.getRoleName(employeedetailsresponse.getRoleId());
		return roleName;
	}
	public static ArrayList<Integer> getProjectDetailsforEmployee(EmployeeDetailsResponse employeedetailsresponse) throws SQLException {
		
		ArrayList<Integer> projectIdList = EmployeeDetails.getProjectDetailsforEmployee(employeedetailsresponse.getEmployeeId());
		return projectIdList;
	}
	public static ProjectDetailsResponse getProjectDetailsFromEmployeeObject(int projectid,ArrayList<ProjectDetailsResponse> projectList) {
		
		for(ProjectDetailsResponse p : projectList) {
			if(p.getProjectId()==projectid){
				System.out.println(p.getProjectId());
				return p;
			}
		
		}
		return null;
	}
}
