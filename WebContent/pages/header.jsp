<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${context}/css/header.css"></link>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"></link>
	</head>
	<body>
	<header>
					<div class="welcome">Welcome <c:if test="${sessionScope.employeeresponseobject != null}"> ${sessionScope.employeeresponseobject.getEmployeeName()}</c:if></div>
					<form class="header" method="post" action="${context}/LogOut">
						<div class="signout"><input type="submit" value="Logout"></input></div>
					</form>
	</header>
	</body>
</html>