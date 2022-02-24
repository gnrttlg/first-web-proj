<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<meta charset="utf-8">
<title><fmt:message bundle="${loc}" key="main.title" /></title>
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
		<a href="MyController?command=switchLocale&local=ru"><fmt:message bundle="${loc}" key="local.locbutton.name.ru" /></a>
		<a href="MyController?command=switchLocale&local=en"><fmt:message bundle="${loc}" key="local.locbutton.name.en" /></a>
	</div>
	<h1 align="center">
		<fmt:message bundle="${loc}" key="main.title" />
	</h1>
	<br />

	<table>
		<tr>
			<td><fmt:message bundle="${loc}" key="table.title" /></td>
			<td><fmt:message bundle="${loc}" key="table.price" /></td>
			<td><fmt:message bundle="${loc}" key="table.description" /></td>
			<c:if test="${sessionScope.role == 'admin'}">
				<td><fmt:message bundle="${loc}" key="table.storage_id" /></td>
				<td><fmt:message bundle="${loc}" key="table.count_in_storage" /></td>
			</c:if>
			<td><fmt:message bundle="${loc}" key="table.action" /></td>
		</tr>
		<c:forEach var="good" items="${goods}">
			<tr>
				<td><c:out value="${good.title}" /></td>
				<td><c:out value="${good.price}" /></td>
				<td><c:out value="${good.description}" /></td>
				<c:if test="${sessionScope.role == 'admin'}">
					<td><c:out value="${good.storageID}" /></td>
					<td><c:out value="${good.countInStorage}" /></td>
					<td><a
						href="MyController?command=delete_good&id=<c:out value="${good.id}"/>"><fmt:message
								bundle="${loc}" key="action.delete" /></a></td>
				</c:if>
				<c:if test="${sessionScope.role == 'user'}">
					<c:if test="${!good.inCart}">
						<td><a
							href="MyController?command=add_to_cart&id=<c:out value="${good.id}"/>"><fmt:message
									bundle="${loc}" key="action.add_to_cart" /></a></td>
					</c:if>
					<c:if test="${good.inCart}">
						<td><fmt:message bundle="${loc}" key="action.in_cart" /></td>
					</c:if>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${sessionScope.role == 'admin'}">
		<h2 align="center">
			<a href="MyController?command=GO_TO_USERS_PAGE"><button>
					<fmt:message bundle="${loc}" key="main.users_control" />
				</button></a>
		</h2>
		<h2 align="center">
			<a href="MyController?command=GO_TO_STORAGES_PAGE"><button>
					<fmt:message bundle="${loc}" key="main.storages_control" />
				</button></a>
		</h2>
	</c:if>
	<c:if test="${sessionScope.role == 'user'}">
		<h2 align="center">
			<a href="MyController?command=GO_TO_CART_PAGE"><button>
					<fmt:message bundle="${loc}" key="main.cart" />
				</button></a>
		</h2>
	</c:if>

	<a href="MyController?command=restart">Restart</a>
</body>
</html>