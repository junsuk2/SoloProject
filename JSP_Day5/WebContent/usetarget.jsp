<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, com.example.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		// 사용 할 객체 선언
		Map<String, String> myMap = new HashMap<>();
		Person p = new Person("이준석", 25);
		request.setAttribute("person", p);
	%>
	
	<c:set var="myMap" value="<%=myMap %>" scope="request"></c:set>
	
	<!-- expression tag를 이용한 target을 선정 -->
	<c:set target="<%=myMap %>" property="car">밴츠 S클래스</c:set>
	<c:set target="<%=p %>" property="name" value="홍영기"></c:set>
	
	myCar : <%=myMap.get("car") %><br>
	Person : <%=p.getName() %><br>
	
	<!--  expression language를 이용한 target 선정 -->
	<c:set target="${myMap }" property="phone">NOTE 7</c:set>
	<c:set target="${person }" property="age" value="25"></c:set>
	myPhone : <%=myMap.get("phone") %><br>
	Age : <%=p.getAge() %>
	
</body>
<script>
</script>
</html>