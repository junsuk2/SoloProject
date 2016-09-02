<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		int age=10;
		request.setAttribute("name", "andy");
	%>
	
	<c:if test="true">
		<h1>언제나...</h1>
	</c:if>
	<c:if test="${!empty name }">
		<h1>name은 ${name }</h1>
	</c:if>
	<c:if test="<%=age >5 %>">
		<h1>5살 보다 많다.</h1>
	</c:if>
</body>
<script>
</script>
</html>