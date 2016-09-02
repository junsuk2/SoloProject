<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
		<c:set var="now" value="<%=new Date() %>">
		</c:set>
		지금은 ${now }입니다.<br>
		<fmt:formatDate value="${now }" type="date"/><br>
		<fmt:formatDate value="${now }" type="date" dateStyle="long"/><br>
		<fmt:formatDate value="${now }" type="date" pattern="YY-MM-dd"/><br>
		<fmt:formatDate value="${now }" type="date" pattern="YY-MM-dd" var="saved"/><br>
		저장된 값 : ${saved }
		<fmt:parseDate value="${saved }" type="date" pattern="YY-MM-dd" ></fmt:parseDate>
		
</body>
<script>
</script>
</html>