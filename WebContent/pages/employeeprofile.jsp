<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
		<title>My Profile</title>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/employeeprofile.css"></link>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/sidebar.css"></link>
		<link rel="stylesheet" href="${context}/css/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
	<%@include file="header.jsp" %>
	<%@include file="sidebar.jsp" %>
	<section class="employeedetails">
				<c:if test="${sessionScope.employeeresponseobject != null}">
					<h3>employee information</h3>
					<table>
						<tbody>
							<tr><td>EmployeeId</td><td>${sessionScope.employeeresponseobject.getEmployeeId()}</td></tr>
							<tr><td>Employee Name</td><td>${sessionScope.employeeresponseobject.getEmployeeName()}</td></tr>
							<tr><td>Designation</td><td>${sessionScope.employeeresponseobject.roleName}</td></tr>
							<tr><td>Department</td><td>${sessionScope.employeeresponseobject.department}</td></tr>
						</tbody>
					</table>          
				</c:if>
		</section>
</body>
</html>