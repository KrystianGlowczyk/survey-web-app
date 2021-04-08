<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
	<title>Odmowa Dostępu</title>
</head>

<body>

	<h2>Odmowa dostępu - nie masz uprawnień dostępu do tego zasobu.</h2>

	<hr>
	
	<a href="${pageContext.request.contextPath}/">Powrót do strony głównej.</a>
	<hr>
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>

</html>