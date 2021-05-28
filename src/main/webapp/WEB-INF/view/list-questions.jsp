<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Pytania</title>

</head>
<body>
<div class="container">
	<h2>Lista Pytań Ankiety:</h2>

	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Pytanie</th>
			<th>Edytuj</th>
			<th>Usuń</th>
			<th>Dodaj odpowiedz do pytania</th>
		</tr>
		</thead>
		<c:forEach var="tempQuest" items="${questions}">

			<c:url var="updateLink" value="/question/updateQuestion">
				<c:param name="questionId" value="${tempQuest.id}" />
			</c:url>

			<!-- construct an "delete" link with customer id -->
			<c:url var="deleteLink" value="/question/deleteQuestion">
				<c:param name="questionId" value="${tempQuest.id}" />
			</c:url>
			
			<c:url var="addAnswer" value="/answer/addAnswer">
				<c:param name="questionId" value="${tempQuest.id}" />
			</c:url>


			<tr>
				<td>${tempQuest.id}</td>
				<td>${tempQuest.title}</td>
				<td><a href="${updateLink}"
					   class="btn btn-outline-secondary">Edytuj</a></td>
				<td><a href="${deleteLink}"
					   class="btn btn-outline-danger"
					onclick="if (!(confirm('Serio?'))) return false">Usuń</a></td>
				<td><a href="${addAnswer}"
					   class="btn btn-outline-success ">Dodaj odpowiedz do pytania</a>
			</tr>

		</c:forEach>
	</table>


	<hr>

	<a href="${pageContext.request.contextPath}/"
	   class="btn btn-secondary btn-sm ">Powrót do strony
		głównej</a>

<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>
</div>
</body>
</html>