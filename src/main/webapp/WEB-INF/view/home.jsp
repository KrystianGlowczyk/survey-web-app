<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

	<title>Aplikacja do ankietowania</title>
</head>

<body>
<div class="container">
	<h2>Strona Główna</h2>
	<hr>
	
	<p>
	Witaj na stronie głównej aplikacji. 
	</p>
	
	<hr>
	
	<!-- display user name and role -->
	<h3>Zalogowano jako:</h3>
	<p>
		Użytkownik: <security:authentication property="principal.username" />
		<br><br>
		<!--  Role(s): <security:authentication property="principal.authorities" /> -->
		Imię: ${user.firstName}, Nazwisko: ${user.lastName}, Email: ${user.email}
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/survey/addSurvey" class="btn btn-outline-success ">Dodaj ankiete</a>
		<a href="${pageContext.request.contextPath}/survey/list" class="btn btn-outline-info ">Wyświetl ankiety</a>
	</p>	
	
	
	<security:authorize access="hasRole('ADMIN')">  

		<!-- Add a link to point to /systems ... this is for the admins -->
		
		<p>
			<a href="${pageContext.request.contextPath}/systems/showUsers" class="btn btn-outline-warning">Panel Administratora</a>
			(Only for Admin peeps)
		</p>
	
	</security:authorize>
	
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</div>
</body>

</html>









