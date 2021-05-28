<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<title>Dodaj Pytanie</title>
</head>

<body>

	<h2>Dodaj pytanie do ankiety</h2>

	<form:form action="saveQuestion" modelAttribute="question"
		method="POST">


		<form:hidden path="id" />
		<form:hidden path="survey" value="${param.surveyId}" />
		<table>
			<tbody>
				<tr>
					<td><label>Treść pytania:</label></td>
					<td><form:input path="title" />
				</tr>

				<tr>
					<td><label>Typ pytania:</label></td>
					<td><form:radiobutton path="type" value="1"
							label="Jedna odpowiedz"></form:radiobutton></td>
					<td><form:radiobutton path="type" value="2"
							label="Wiele odpowiedzi"></form:radiobutton></td>
					<td><form:radiobutton path="type" value="3"
							label="Lista odpowiedzi"></form:radiobutton></td>
					<td><form:radiobutton path="type" value="4"
							label="Otwarta odpowiedz"></form:radiobutton></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Zapisz" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>



	<hr>

	<a href="${pageContext.request.contextPath}/">Powrót do strony
		głównej</a>

</body>

</html>









