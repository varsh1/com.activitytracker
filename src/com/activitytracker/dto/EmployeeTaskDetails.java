package com.activitytracker.dto;

import java.util.Date;

public class EmployeeTaskDetails {

	private int assignee;
	private int projectId;
	private String projectName;
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	private int taskId;
	private String taskName;
	private String status;
	private String comments;
	private int estimatedTime;
	private int hoursLogged;
	private Date loggedDate;
	private String assigneeName;
	/**
	 * @return the assigneeName
	 */
	public String getAssigneeName() {
		return assigneeName;
	}
	/**
	 * @param assigneeName the assigneeName to set
	 */
	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	/**
	 * @return the loggedDate
	 */
	public Date getLoggedDate() {
		return loggedDate;
	}
	/**
	 * @param loggedDate the loggedDate to set
	 */
	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}
	/**
	 * @return the assignee
	 */
	public int getAssignee() {
		return assignee;
	}
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(int assignee) {
		this.assignee = assignee;
	}
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the estimatedTime
	 */
	public int getEstimatedTime() {
		return estimatedTime;
	}
	/**
	 * @param estimatedTime the estimatedTime to set
	 */
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	/**
	 * @return the hoursLogged
	 */
	public int getHoursLogged() {
		return hoursLogged;
	}
	/**
	 * @param hoursLogged the hoursLogged to set
	 */
	public void setHoursLogged(int hoursLogged) {
		this.hoursLogged = hoursLogged;
	}
	
	
}
