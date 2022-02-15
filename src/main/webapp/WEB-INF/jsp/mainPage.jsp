<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MAIN PAGE</title>
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
	<h1 align="center">Main page</h1>
	<br />
	<c:if test="${sessionScope.userName!=null}">
		<h2 align="center">
			<c:out value="Hello " />
			<c:out value="${sessionScope.userName}" />
			<c:out value=". You entered as ${sessionScope.role}." />
		</h2>
	</c:if>

	<table>
		<tr>
			<td>TITLE</td>
			<td>PRICE</td>
			<td>DESCRIPTION</td>
			<c:if test="${sessionScope.role == 'admin'}">
				<td>STORAGE ID</td>
				<td>COUNT IN STORAGE</td>
			</c:if>
		</tr>
		<c:forEach var="good" items="${goods}">
			<tr>
				<td><c:out value="${good.title}" /></td>
				<td><c:out value="${good.price}" /></td>
				<td><c:out value="${good.description}" /></td>
				<c:if test="${sessionScope.role == 'admin'}">
					<td><c:out value="${good.storageID}" /></td>
					<td><c:out value="${good.countInStorage}" /></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${sessionScope.role == 'admin'}">
		<h2 align="center">
			<a href="MyController?command=GO_TO_USERS_PAGE"><button>Users
					Control</button></a>
		</h2>
	</c:if>

	<a href="MyController?command=restart">Restart</a>
</body>
</html>