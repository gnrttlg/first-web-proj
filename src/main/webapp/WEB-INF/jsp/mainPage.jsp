<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MAIN PAGE</title>
</head>
<body>
<h1 align = "center">Main page</h1>
<br/>
<c:if test="${sessionScope.userName!=null}">
<h2 align = "center">
	<c:out value="${sessionScope.greeting.getGreeting()}"/>
	<c:out value="${sessionScope.userName}"/>
	<c:out value=". You entered as ${sessionScope.role}."/>
</h2>
</c:if>

<%
	com.tc.web01.controller.entity.Greeting greeting = (com.tc.web01.controller.entity.Greeting )session.getAttribute("greeting");
	
	String userName = (String)session.getAttribute("userName");
	
	if(userName != null){
 	out.println("<h2 align = \"center\">"+greeting.getGreeting()+userName+". You entered as "+(String)session.getAttribute("role")+".</h2>");
	}

%>
<a href="MyController?command=restart">Restart</a>
</body>
</html>