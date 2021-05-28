<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>

<head>
<title>Dodaj Odpowiedz do pytania</title>
</head>

<body>

	<h2>Dodaj odpoweidz do pytania</h2>

	<form:form action="saveAnswer" modelAttribute="answer"
		method="POST">
		<form:hidden path="id"/>
		<form:hidden path="question" value="${param.questionId}" />

		<table>
			<tbody>
				<tr>
					<td><label>Treść odpowiedzi:</label></td>
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

	<a href="${pageContext.request.contextPath}/">Powrót do strony
		głównej</a>

</body>

</html>









