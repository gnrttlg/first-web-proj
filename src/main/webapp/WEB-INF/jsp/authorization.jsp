<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Authorization</title>
<link rel="stylesheet" href="CSS/authCSS.css">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.message" var="message" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.username" var="username" />
<fmt:message bundle="${loc}" key="local.login" var="login" />
<fmt:message bundle="${loc}" key="local.log_in" var="log_in" />
<fmt:message bundle="${loc}" key="local.password" var="password" />
<fmt:message bundle="${loc}" key="local.rememberMe" var="rememberMe" />
<fmt:message bundle="${loc}" key="local.valid" var="valid" />
<fmt:message bundle="${loc}" key="local.back" var="back" />
<fmt:message bundle="${loc}" key="local.enter_login" var="enter_login" />
<fmt:message bundle="${loc}" key="local.enter_password" var="enter_pass" />
</head>
<body>
	<div align="left">
		<a href="MyController?command=switchLocale&local=ru">${ru_button}</a>
		<a href="MyController?command=switchLocale&local=en">${en_button}</a>
	</div>
	<!-- Button to open the modal login form -->
	<button onclick="document.getElementById('id01').style.display='block'">${log_in}</button>
	<a href="MyController?command=GO_TO_HELLO_PAGE"><button>${back}</button></a>

	<c:if test="${sessionScope.errorMessage!=null}">
		<h2 align="center">
			<c:out value="${sessionScope.errorMessage}" />
			${sessionScope.remove("errorMessage")}
		</h2>
	</c:if>
	<c:out value="${sessionScope.errorMessage==null}" />

	<!-- The Modal -->
	<div id="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>

		<!-- Modal Content -->
		<form class="modal-content animate" action="MyController"
			method="post">
			<input type="hidden" name="command" value="authorisation">
			<div class="imgcontainer">
				<img src="img/img_avatar2.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label for="name"><b>${login}</b></label> <input type="text"
					placeholder="${enter_login}" name="name" required> <label
					for="psw"><b>${password}</b></label> <input type="password"
					placeholder="${enter_pass}" name="psw" required>

				<button type="submit">${login}</button>
				<label> <input type="checkbox" checked="checked"
					name="remember"> ${rememberMe}
				</label>
			</div>
		</form>
	</div>

	<script>
		var modal = document.getElementById('id01');
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>