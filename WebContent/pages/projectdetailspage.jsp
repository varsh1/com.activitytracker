<%@ page language="java" %>
<%@ page errorPage="error.jsp" %>
<%@ page import="com.activitytracker.dto.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
<!--  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
		<title>Insert title here</title>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>	
		
		<link rel="stylesheet" type="text/css" href="${context}/css/employeeprofile.css"></link>
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="sidebar.jsp" %>
 <% ProjectDetailsResponse project = (ProjectDetailsResponse)request.getAttribute("project");%>
	<section class="employeedetails">
		  <c:if test="${sessionScope.employeeresponseobject != null}">
		  <h3>Project Details</h3>
				<table>
					
					<tbody>
						<tr><td>Project Id</td><td>${requestScope.project.getProjectId()}</td></tr>
						<tr><td>Project Name</td><td>${requestScope.project.projectName}</td></tr>
						<tr><td>Manager Name</td><td>${requestScope.project.managerName}</td></tr>
						<tr><td>Start Date</td><td>${requestScope.project.startDate}</td></tr>
						<tr><td>End Date</td><td>${requestScope.project.endDate}</td></tr>
					</tbody>
				</table>          
		  </c:if>
	</section>
</body>
</html>