<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "com.example.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		Object objRegion = request.getAttribute("region");
		if(objRegion != null){
			Region region = (Region)objRegion;
			int regionId = region.getRegionId();
			String regionName=region.getRegionName();
		}
	%>
	<jsp:include page="/layout/header.jsp"></jsp:include>
	<h2>Region 검색</h2>
	<form method="get" action="<%=request.getContextPath() %>/get">
		<p>조회 할 Region Id를 입력하세요.</p>
		<input type="number" name="regionId">
		<input type="submit">
	</form>
	<h2>조회 결과</h2>
	<form method="post">
		<input type="number" name="regionId" value="${regionId }">
		<input type="text" name="regionName" value="${regionName }">
		<input type="submit" value="수정" formaction="<%=request.getContextPath()%>/update">
		<input type="submit" value="삭제" formaction="<%=request.getContextPath()%>/regionManager?cmd=del">	
	</form>
	
	<div id="result"></div>
</body>
<script>
</script>
</html>