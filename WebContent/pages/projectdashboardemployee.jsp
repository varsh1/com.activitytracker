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
		<link rel="stylesheet" type="text/css" href="${context}/css/employeedashboard.css"></link>	
</head>
<body>
<%@include file="header.jsp" %>
 <% ProjectDetailsResponse project = (ProjectDetailsResponse)request.getAttribute("project");%>
	<section class="employeedetails">
		  <c:if test="${sessionScope.employeeresponseobject != null}">
				<table>
					<thead>
						<th>Project  Information</th>
					</thead>
					<tbody>
						<tr><td>ProjectId</td><td>${requestScope.project.getProjectId()}</td></tr>
						<tr><td>Project Name</td><td>${requestScope.project.projectName}</td></tr>
						<tr><td>Manager Name</td><td>${requestScope.project.managerName}</td></tr>
						<tr><td>Start Date</td><td>${requestScope.project.startDate}</td></tr>
						<tr><td>End Date</td><td>${requestScope.project.endDate}</td></tr>
					</tbody>
				</table>          
		  </c:if>
	</section>
	<%request.getSession(true).setAttribute("project",project); %>
	<section>
		<c:if test="${requestScope.taskdetailslist !=null }">
			<table>
				<thead>
					<tr>
					<th>Task Information</th>
					</tr>
					<tr>
						<th>Task Id</th>
						<th>Task Name</th>
						<th>Status</th>
						<th>Comments</th>
						<th>Estimated Time</th>
						<th>Hours Logged</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${requestScope.taskdetailslist}">
						<tr>
							<td>${task.getTaskId()}</td>
							<td>${task.taskName}</td>
							<td>${task.status}</td>
							<td>${task.comments}</td>
							<td>${task.estimatedTime}</td>
							<td>${task.hoursLogged}</td>
						</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</section>
	<section class="button-section">
		<form method="post" action="${context}/pages/addtask.jsp">
			<input type ="submit" value="Add Task"></input>
		</form>
		<form method="post" action="${context}/EmployeeTaskHistory">
			<input type ="submit" value="View Task History"></input>
		</form>
	</section>
	</section>
</body>
</html>