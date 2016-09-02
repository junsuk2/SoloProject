<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Service Fail</title>
</head>
<body>
	<%--에러 내용을 사용자에게 전달하기 --%>
	<%
		ErrorData ed = pageContext.getErrorData();
	%>
	<%=ed.getThrowable().getMessage() %>
</body>
<script>
</script>
</html>