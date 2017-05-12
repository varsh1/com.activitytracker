<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<c:set var="context" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${context}/css/login.css"></link>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"></link>
		<script type="text/javascript" src="${context}/js/loginvalidation.js"></script>
	</head>
	<body>
	<div class="page-container">
		<div class="container">
			<div class="form-container">
				<form method="post" action="<%=request.getContextPath() %>/Login" onSubmit="return validateCredentials()">
						  <div class="sign-in"> Sign In</div>
						<div class="sign-in-with-email">Sign in with your email </div>
						<div class="errordiv display-none">Invalid username or password!</div>
						<c:if test="${requestScope.error != null}"><div class="errordiv"><%=request.getAttribute("error") %></div></c:if>
						<div class="outer">
					 		<div class="circle"></div>	
					 </div>
					 <div class="input">
						<div><input type ="text" name="username" placeholder="Username"/></div>
						<div><input type="password" name="password" placeholder="Password"/></div>
					</div>	
					<div><input type="submit" name="submit" value="Sign In"/></div>
				</form>
			</div>
		</div>
		<div class="background">
			<img src="${context}/css/images/background-image.jpg" alt="backround-image"></img>
		</div>
		</div>
	</body>
</html>