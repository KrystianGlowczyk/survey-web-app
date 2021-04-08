<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<title>Dodaj Ankiete</title>
</head>

<body>

	<h2>Dodaj ankiete</h2>

	<form:form action="saveSurvey" modelAttribute="survey" method="POST">

		<form:hidden path="id" />
		<table>
			<tbody>
				<tr>
					<td><label>Tytuł:</label></td>
					<td><form:input path="title" />
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Zapisz" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>



	<hr>

	<a href="${pageContext.request.contextPath}/">Powrót do strony głównej</a>

</body>

</html>









