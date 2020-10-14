<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company home Page</h2>
	<hr>
	
	<p>
		Welcome to the Company Home Page
	</p>
	
	<hr>
	
		<!-- display the username and role -->
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>	
	
		<security:authorize access="hasRole('MANAGER')">
		
			<!-- Add a link to point to /leaders ... Managers Only -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				Managers Only
			</p>
		
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
		
		<!-- Add a link to point to /systems ... Admins Only -->
		<p>
			<a href="${pageContext.request.contextPath}/admins">Admin Meeting</a>
			Admins Only
		</p>
		
		</security:authorize>
		
	<hr>
	
	<!-- Add an loggout button -->
	<form:form  action="${pageContext.request.contextPath}/logout"
			   method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>
		
	
</body>
</html>