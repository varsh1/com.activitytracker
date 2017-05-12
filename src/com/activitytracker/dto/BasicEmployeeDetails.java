package com.activitytracker.dto;



public class BasicEmployeeDetails {

	int employeeId;
	String employeeName;
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
	
	@Override
	public boolean equals(Object obj)
	{
		BasicEmployeeDetails empdetails = (BasicEmployeeDetails)obj;
		return (getEmployeeId()==empdetails.getEmployeeId());
			
	}
	
	@Override
	public int hashCode()
	{
		int hash=3;
		hash = 4 * hash + this.employeeName.hashCode();
		return hash;
	}
}
