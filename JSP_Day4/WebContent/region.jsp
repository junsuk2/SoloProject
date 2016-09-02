<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/layout/header.jsp"/>
	<table>
		<tr>
			<th>regionId</th>
			<th>regionName</th>
		</tr>
<%-- 	<%
			Object regionObj = request.getAttribute("region");
			if (regionObj != null && regionObj instanceof List) {
				List<Region> regions = (List<Region>) regionObj;
				for (Region region : regions) {
					out.println("<tr><td>"+region.getRegionId()+"</td><td>"+region.getRegionName()+"</td></tr>");
				}
			}
		%> --%>
		<c:forEach var="region" items="${regions }">
			<tr><td>${region.regionId }</td><td>${region.regionName }</td></tr>
		</c:forEach>
		
		</table>
	<jsp:include page="/layout/footer.jsp"/>
</body>
</html>