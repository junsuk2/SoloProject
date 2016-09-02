<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="ko"/>
	
	<fmt:bundle basename="messages.message">
	<h1><fmt:message key="title"></fmt:message></h1>
	<ul>
		<li><fmt:message key="name"></fmt:message>
		<li><fmt:message key="age"></fmt:message>
		<li><fmt:message key="welcome"></fmt:message>
		<li><fmt:message key="withparam">
			<fmt:param value="홍길동"></fmt:param>
		</fmt:message>
	</ul>
	</fmt:bundle>
</body>
<script>
	
</script>
</html>