<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:url value = "http://www.naver.com" var="naver"></c:url>
	${naver }
	<c:url value="/import.jsp" var="imp"></c:url>
	${imp }
</body>
<script>
</script>
</html>