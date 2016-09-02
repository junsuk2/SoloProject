<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- 사용한 JSTL 선언 --%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Core</h1>
	<h2>저장 후</h2>
	<c:set var="myVar" value="이준석" scope="request"></c:set>
	<%--request.setAttribute("myVar", "홍길동")  --%>
	
	<%=request.getAttribute("myVar") %><br>
	${myVar }
	
	<h2>삭제 후</h2>
	<%
		//request.removeAttribute("myVar");
	%>
	<c:remove var="myVar" scope="request"/>
	<%=request.getAttribute("myVar") %><br>
	${empty myVar }
	
</body>
<script>
	
</script>
</html>