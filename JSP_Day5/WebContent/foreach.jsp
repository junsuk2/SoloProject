<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" begin="0" end="10" step="2">
	<c:set var="sum" value="${sum +i}"></c:set>
	</c:forEach>
	
	${sum }
	
	<%
		String [] strs = {"Hello", "JSTL", "World"};
	%>
	
	<c:forEach var="item" items="<%=strs %>">
	${item }
	</c:forEach>
</body>
<script>
</script>
</html>