<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello page</title>
<link rel="stylesheet" href="CSS/authCSS.css">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.username" var="username" />
<fmt:message bundle="${loc}" key="local.log_in" var="login" />
<fmt:message bundle="${loc}" key="local.password" var="password" />
<fmt:message bundle="${loc}" key="local.rememberMe" var="rememberMe" />
<fmt:message bundle="${loc}" key="local.valid" var="valid" />
<fmt:message bundle="${loc}" key="local.back" var="back" />
<fmt:message bundle="${loc}" key="local.enter_username" var="enter_usnm" />
<fmt:message bundle="${loc}" key="local.enter_password" var="enter_pass" />
<fmt:message bundle="${loc}" key="local.registration" var="registration" />
<fmt:message bundle="${loc}" key="local.hello_page" var="hello_page" />
</head>
<body bgcolor='CCFFCC'>
	<div align="left">
		<a href="MyController?command=switchLocale&local=ru">${ru_button}</a>
		<a href="MyController?command=switchLocale&local=en">${en_button}</a>
	</div>
	<h1 align=center style="color: #669966;">${hello_page}</h1>
	<a href="MyController?command=GO_TO_AUTHORIZATION_PAGE"><button>${login}</button></a>
	<br />
	<a href="MyController?command=GO_TO_REGISTRATION_PAGE"><button>${registration}</button></a>
	<br />
</body>
</html>