<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<html>
<head>
<meta charset="utf-8">
<title>Users</title>
<style type="text/css">
TABLE {
	width: 100%;
	text-align: center;
}

TD, TH {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div align="left">
		<a href="MyController?command=switchLocale&local=ru"><fmt:message
				bundle="${loc}" key="local.locbutton.name.ru" /></a> <a
			href="MyController?command=switchLocale&local=en"><fmt:message
				bundle="${loc}" key="local.locbutton.name.en" /></a>
	</div>
	<table>
		<tr>
			<td><fmt:message bundle="${loc}" key="table.name" /></td>
			<td><fmt:message bundle="${loc}" key="table.surname" /></td>
			<td><fmt:message bundle="${loc}" key="table.login" /></td>
			<td><fmt:message bundle="${loc}" key="table.address" /></td>
			<td><fmt:message bundle="${loc}" key="table.action" /></td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.surname}" /></td>
				<td><c:out value="${user.login}" /></td>
				<td><c:out value="${user.address}" /></td>
				<td><a
					href="MyController?command=delete_user&id=<c:out value="${user.id}"/>"><fmt:message
							bundle="${loc}" key="action.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${sessionScope.errorMessage!=null}">
		<h2 align="center">
			<c:out value="${sessionScope.errorMessage}" />
			${sessionScope.remove("errorMessage")}
		</h2>
	</c:if>
	<h2 align="center">
		<a href="MyController?command=GO_TO_MAIN_PAGE"><fmt:message
				bundle="${loc}" key="back" /></a>
	</h2>
</body>
</html>