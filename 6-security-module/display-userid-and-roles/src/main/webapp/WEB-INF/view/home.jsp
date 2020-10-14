<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company home Page</h2>
	<hr>
	
	Welcome to the Company Home Page
</body>

		<!-- display the username and role -->
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>	


	<!-- Add an loggout button -->
	<form:form  action="${pageContext.request.contextPath}/logout"
			   method="POST">
	
		<input type="submit" value="Logout"/>
	
	</form:form>
	
</html>