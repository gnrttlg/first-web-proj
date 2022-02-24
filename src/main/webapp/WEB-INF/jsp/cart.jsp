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
<title>Cart</title>
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

	<h2 align="left">
		<a href="MyController?command=GO_TO_MAIN_PAGE">Back</a>
	</h2>
	<c:if test="${cart.size()==0}">
		<h2 align="center">Empty</h2>
	</c:if>


	<c:if test="${cart.size()>0}">
		<table>
			<tr>
			<tr>
				<td>TITLE</td>
				<td>PRICE</td>
				<td>DESCRIPTION</td>
				<td>ACTION</td>
			</tr>
			<c:forEach var="good" items="${cart}">
				<tr>
					<td><c:out value="${good.title}" /></td>
					<td><c:out value="${good.price}" /></td>
					<td><c:out value="${good.description}" /></td>
					<td><a
						href="MyController?command=remove_from_cart&id=<c:out value="${good.id}"/>">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${sessionScope.errorMessage!=null}">
			<h2 align="center">
				<c:out value="${sessionScope.errorMessage}" />
				${sessionScope.remove("errorMessage")}
			</h2>
		</c:if>
		<h2 align="right">
			<a href="MyController?command=buy">Buy</a>
		</h2>
	</c:if>

</body>
</html>