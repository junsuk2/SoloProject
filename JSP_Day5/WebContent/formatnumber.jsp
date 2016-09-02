<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:set var="price" value="1234567890"/>
	그냥 출력 : ${price }<br>
	<fmt:formatNumber value="${price }" type="number"/><br>
	<fmt:formatNumber value="${price }" type="currency" currencyCode="KRW"/><br>
	<fmt:formatNumber value="${price }" type="percent" var="percentType"/>
	변수에 저장된 값 : ${percentType }<br>
	
	<fmt:parseNumber value="${percentType }" type="percent"/>
	
</body>
<script>
</script>
</html>