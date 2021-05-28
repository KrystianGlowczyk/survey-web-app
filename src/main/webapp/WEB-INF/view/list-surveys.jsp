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
<title>Lista Ankiet</title>

</head>

<body>
<div class="container">
	<h2>Lista Ankiet:</h2>

	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Tytuł</th>
			<th>Edytuj</th>
			<th>Usuń</th>
			<th>Dodaj pytanie</th>
			<th>Wyświetl pytania</th>
		</tr>
		</thead>

		<c:forEach var="tempSurvey" items="${surveys}">

			<c:url var="updateLink" value="/survey/showFormForUpdate">
				<c:param name="surveyId" value="${tempSurvey.id}" />
			</c:url>

			<!-- construct an "delete" link with customer id -->
			<c:url var="deleteLink" value="/survey/delete">
				<c:param name="surveyId" value="${tempSurvey.id}" />
			</c:url>

			<c:url var="addQuestion" value="/question/addQuestion">
				<c:param name="surveyId" value="${tempSurvey.id}" />
			</c:url>

			<c:url var="showQuestions" value="/question/list">
				<c:param name="surveyId" value="${tempSurvey.id}" />
			</c:url>

			<tr>
				<td>${tempSurvey.id}</td>
				<td>${tempSurvey.title}</td>
				<td><a href="${updateLink}"
					   class="btn btn-outline-secondary">Edytuj</a></td>
				<td><a href="${deleteLink}"
					   class="btn btn-outline-danger"
					onclick="if (!(confirm('Serio?'))) return false">Usuń</a></td>
				<td><a href="${addQuestion}"
					   class="btn btn-outline-success ">Dodaj pytanie</a></td>
				<td><a href="${showQuestions}"
					   class="btn btn-outline-info ">Wyswietl pytania</a>
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