<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" href="${context}/css/font-awesome-4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="${context}/css/sidebar.css"></link>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"></link>
		
</head>
<body>
	<aside>
			
			<c:set var="roleName" value="${sessionScope.employeeresponseobject.roleName}"></c:set>
			<c:choose>
				<c:when test="${not fn:containsIgnoreCase(roleName, 'manager')}">
					<div><a href="${context}/pages/employeedashboard.jsp"><i class="fa fa-home fa-3x" aria-hidden="true"></i></div>
					<div>Home</div></a>
				</c:when>
				<c:otherwise>
					<div><a href="${context}/pages/managerdashboard.jsp"><i class="fa fa-home fa-3x" aria-hidden="true"></i></div>
					<div>Home</div></a>
				</c:otherwise>
			</c:choose>
			<div><a href="${context}/pages/employeeprofile.jsp"><i class="fa fa-user fa-3x" aria-hidden="true"></i></div>
			<div>Profile</div></a>
	</aside>
</body>
</html>