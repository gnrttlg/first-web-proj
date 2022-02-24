<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local.loc" var="loc" />
<html>
<head>
<meta charset="utf-8">
<title>Storages</title>
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
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Address</td>
			<td>Action</td>
		</tr>
		<c:forEach var="storage" items="${storages}">
			<tr>
				<td><c:out value="${storage.id}" /></td>
				<td><c:out value="${storage.name}" /></td>
				<td><c:out value="${storage.address}"/></td>
				<td></td>
			</tr>
		</c:forEach>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Address</td>
			<td>Action</td>
		</tr>
	</table>
	<h2 align="center">
		<a href="MyController?command=GO_TO_MAIN_PAGE">Back</a>
	</h2>
</body>
</html>