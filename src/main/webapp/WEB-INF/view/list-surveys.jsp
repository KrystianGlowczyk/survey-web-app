<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		</tr>
		
		<c:forEach var="tempSurvey" items="${surveys}">
		
		<c:url var="updateLink" value="/survey/showFormForUpdate">
			<c:param name="surveyId" value="${tempSurvey.id}" />
		</c:url>
		
		<!-- construct an "delete" link with customer id -->
		<c:url var="deleteLink" value="/survey/delete">
			<c:param name="surveyId" value="${tempSurvey.id}" />
		</c:url>
		
		<tr>
			<td>${tempSurvey.id}</td>
			<td>${tempSurvey.title}</td>
			<td><a href="${updateLink}">Edytuj</a></td>
			<td><a href="${deleteLink}" onclick="if (!(confirm('Serio kurwa?'))) return false">Usuń</a></td>
		</tr>
		
		</c:forEach>
	</table>


</body>
</html>