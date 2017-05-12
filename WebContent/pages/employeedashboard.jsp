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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org /TR/html4/loose.dtd">
<html>
	<head>

		<meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
		<title>Employee Dashboard</title>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		
		<link rel="stylesheet" href="${context}/css/font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>
		
		
	</head>
	<body>

		<div class="container">
			
			<% int count=0; 
			ArrayList<ProjectDetailsResponse> projectList;
			String projectName;
			%>
			
			<c:set var="projectList" value="${sessionScope.employeeresponseobject.projectList}"></c:set>
			<%@include file="header.jsp" %>
			<%@include file="sidebar.jsp" %>
			
			<%
				EmployeeDetailsResponse employeeresponseobj = (EmployeeDetailsResponse)session.getAttribute("employeeresponseobject");
				projectList = employeeresponseobj.getProjectList();
				count = projectList.size();
				pageContext.setAttribute("count", count);
			%> 
			<section class="options">			
				<c:if test="${count == 1}">
					<div class="projectcount">You have <%=count %> active project</div>
				</c:if>	
				<c:if test="${count> 1}">
					<div class="projectcount">You have <%=count %> active projects</div>
				</c:if>	
				<form method="post"  name="project">
					<span>Choose your project:</span>
					<select name="project">
					<c:forEach var="project" items="${sessionScope.employeeresponseobject.projectList}" >
						<option value="${project.projectId}"> ${project.projectName}</option>
				   	</c:forEach>
					</select>

					<div>
						
						<button type ="submit" value="Add Task" name="addtask">Add Task</button> 
						<button type="submit" name="projectdetails" value="projectdetails">View Project Details</button>
						<button type="button" name="choose" value="View Task History">View Task History</button>
					
					</div>
				</form>
			</div>	
			<div class="error-message display-none">Some Internal error occurred! Please try again later!</div>
			<div class="table">	
			<table id="projectdetails" class="hidden">
				<thead>
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
		<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
		<script>var context = "${pageContext.request.contextPath}"</script>
		<script src="${context}/js/employeedashboard.js"></script>
	</body>
</html>