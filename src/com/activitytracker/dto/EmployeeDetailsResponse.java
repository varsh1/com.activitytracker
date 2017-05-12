package com.activitytracker.dto;

import java.util.ArrayList;

public class EmployeeDetailsResponse {
	private int employeeId;
	private String employeeName;
	private int roleId;
	private String roleName;
	private String department;
	ArrayList<ProjectDetailsResponse> projectList;
	
	
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the role
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param role the role to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the project
	 */
	public ArrayList<ProjectDetailsResponse> getProjectList() {
		return projectList;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @param project the project to set
	 */
	public void setProjectList(ArrayList<ProjectDetailsResponse> projectList) {
		this.projectList = projectList;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
