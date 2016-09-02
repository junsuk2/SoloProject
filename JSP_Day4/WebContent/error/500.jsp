<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>앗!!!</h1>
	서버 코드 문제 발생
	<p>상세 오류 내용</p>
	<ul>
		<li>URI: <%=pageContext.getErrorData().getRequestURI() %>
		<li>Name : <%=pageContext.getErrorData().getServletName() %>
		<li>CODE : <%=pageContext.getErrorData().getStatusCode() %>
		<li>THROWABLE : <%=pageContext.getErrorData().getThrowable() %>
	</ul>
</body>
<script>
</script>
</html>