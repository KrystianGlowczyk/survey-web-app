<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>

<title>Lista Ankiet</title>

</head>
<body>
	<h2>Lista Ankiet:</h2>

	<table>
		<tr>
			<th>Id</th>
			<th>Tytuł</th>
			<th>Edytuj</th>
			<th>Usuń</th>
			<th>Dodaj pytanie</th>
			<th>Wyświetl pytania</th>
		</tr>

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
				<td><a href="${updateLink}">Edytuj</a></td>
				<td><a href="${deleteLink}"
					onclick="if (!(confirm('Serio?'))) return false">Usuń</a></td>
				<td><a href="${addQuestion}">Dodaj pytanie</a></td>
				<td><a href="${showQuestions}">Wyswietl pytania</a>
			</tr>

		</c:forEach>
	</table>


	<hr>

	<a href="${pageContext.request.contextPath}/">Powrót do strony
		głównej</a>



	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>