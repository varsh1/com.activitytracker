package com.activitytracker.constants;

public interface DatabaseQueries {
	
	String LOGIN_QUERY = "Select employee.employeeid, employee.employeename,employee.department,employee.role from employee INNER JOIN  login ON employee.employeeid=login.employeeid and login.username=? and login.password=? ";
	String SELECT_ROLENAME_FROM_ROLEID = "Select rolename from roles where roleid=?";
	String SELECT_PROJECT_FOR_EMPLOYEE = "Select projectid from employeeprojectmapping where employeeid=?";
	String FETCH_PROJECT_DETAILS = "Select projectname,manager,startDate,endDate from project where projectid=?";
	String SELECT_EMPLOYEENAME_FOR_EMPLOYEE = "Select employeename from employee where employeeid=?";
	String SELECT_TASK_DETAILS = "SELECT * from taskdetails where taskname like ?";
	String ADD_EMPLOYEE_TASKS = "INSERT INTO employeetaskreport values (?,?,?,?,?,?,?,?,?)";
	String SELECT_PROJECTS_FOR_EMPLOYEE = "SELECT employeeidfrom employeeprojectmapping where projectid=?";
	String SELECT_EMPLOYEE_UNDER_MANAGER = "select employee.employeeid, employee.employeename from employeeprojectmapping inner join employee on employee.employeeid= employeeprojectmapping.employeeid and employeeprojectmapping.projectid=? and employeeprojectmapping.employeeid<>?;";
	String SELECT_TASKS_FOR_PROJECT = "Select taskid, taskname,employee.employeename,status,comments,estimatedtime,hourslogged,logdate from employeetaskreport inner join employee on employeetaskreport.assignee=employee.employeeid and  projectid=?";
	String SELECT_TASKS_FOR_EMPLOYEE = "Select project.projectid,project.projectname,taskid, taskname,status,comments,estimatedtime,hourslogged,logdate from employeetaskreport inner join project on employeetaskreport.projectid=project.projectid and assignee=?";
	String SELECT_TASKS_BASED_ON_EMPLOYEE_AND_PROJECT = "Select taskid, taskname,status,comments,estimatedtime,hourslogged,logdate from employeetaskreport where projectid=? and assignee=?";
}
