<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Task</title>
		<c:set var="context" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/addtask.css"></link>
		
	</head>
	<body>
		<c:choose>
		<c:when test="${sessionScope.employeeresponseobject != null}">
			<%@include file="header.jsp"%>
			<%@include file="sidebar.jsp" %>
		
			<c:set var="projectid" value="${requestScope.project}"></c:set>
			<div class ="container">
			<div class="form-heading">
				<h3>Enter your tasks </h3>
				<div class="success-message display-none">Submitted Response Successfully!</div>
				<div class="error-message display-none">Some Internal error occurred! Please try again later!</div>
			</div>
				<div class="form-container">
				<form method="post" action="">
					<input type="hidden" name="project" value="<%=request.getParameter("project") %>"></input>
					
					<input type="number" name="taskid" placeholder="Task Id" readonly></input>
					
					<input type="text" name="taskname" placeholder="Task Name"></input>
					
					<input type="text" name="status" placeholder="Status"></input>
					
					<input type="text" name="comments" placeholder="Comments(not more than thirty characters)"></input>
					
					<input type="number" name="estimatedtime" min="1" max="100" placeholder="Estimated time in hours"></input>
					
					<input type="number" name="hourslogged" min="1" max="100" placeholder="Hours logged"></input>
					
					<input type="text" id="datepicker" size="30" placeholder="date" name="datelogged"></input>
					
					<button type="button" name="addtask" value="add task"> Add Task</button>
				</form>
			</div>
			
		</div>
			<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 		<script>var context = "${pageContext.request.contextPath}"</script>
	  		<script src="${context}/js/addtask.js"></script>
  		</c:when>
  		<c:otherwise>
  			<%
  				RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
  				rd.forward(request, response);
  			%>
  		</c:otherwise>
  		</c:choose>
	</body>
</html>