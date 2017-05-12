<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.activitytracker.dto.*" %>
<%@ page import="java.util.ArrayList" %>
 <% 
	response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma","no-cache");
	String userName = (String) session.getAttribute("username");
	
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->	
		<title>Manager Dashboard</title>
		<c:set var="context" value="${pageContext.request.contextPath}" />
			<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/managerdashboard.css"></link>
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<%@ include file="sidebar.jsp" %>
		
		<section class="employeedetails">
					<c:if test="${sessionScope.employeeresponseobject != null}">
						<div class="heading">Choose your report type</div>
						<form method="post">
						<div class="reportType">
							<button type="button" name ="projectsummary" value="projectsummary">Project</button>
							<button type="button" name="employeesummary" value="employeesummary">Employee</button>
						</div>
						<div class="error-message display-none">Some Internal error occurred! Please try again later!</div>
						<div class="projectList hidden">
						<label for="project" name="project">Choose your project</label>
							<select name="project" >
								<c:forEach var="project" items="${sessionScope.employeeresponseobject.projectList}" >
									<option value="${project.projectId}"> ${project.projectName}</option>
				   				</c:forEach>
							</select>
							<button type="button" name="getprojectreport" value="getinformation">Get Project Report</button>
						</div>
							<div class="employeeList hidden">
								<label for="employeeList" name="employeeList">Choose your employee</label>
								<input type="text" name="employeeList" value=""></input>
								<label name ="chooseAtleastOneMessage" class="hidden validationMessage">Please choose an employee</label>
								<input type="hidden" name="employeeid" value=""></input>
								<button type="button" name="getemployeereport" value="employeereport">Generate Employee Report</button>
							</div>
							
						</form>        
					</c:if>
					
			</section>
			<div class="table">	
					<table id="projectdetails" class="hidden">
						<thead>
							<th>Task Id</th>
							<th>Task Name</th>
							<th>Assignee</th>
							<th>Status</th>
							<th>Comments</th>
							<th>Estimated Time</th>
							<th>Hours Logged</th>
							<th>Logged Date</th>
						</thead>
					</table>	
				</div>
				<div class="table">	
					<table id="employeetaskdetails" class="hidden">
						<thead>
							<th>Project Id</th>
							<th>Project Name</th>
							<th>Task Id</th>
							<th>Task Name</th>
							<th>Status</th>
							<th>Comments</th>
							<th>Estimated Time</th>
							<th>Hours Logged</th>
							<th>Logged Date</th>
						</thead>
					</table>	
				</div>
			<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 			<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
			<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>-->
			<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
			<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
			<script>var context = "${pageContext.request.contextPath}"</script>
			<script src="${context}/js/managerdashboard.js"></script>
	</body>
</html>