<%@ page language="java" contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/layout/header.jsp"></jsp:include>
	<form action="<%=request.getContextPath()%>/regionManager?cmd=add" method="post">
		<fieldset>
			<legend>회원가입</legend>
			<input type="text" name="regionId">
			<input type="text" name="regionName">
			<input type="submit" value="가입">
		</fieldset>
	 </form>
</body>
<script>
</script>
</html>