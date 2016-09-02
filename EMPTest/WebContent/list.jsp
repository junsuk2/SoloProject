<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<title>사원관리</title>
<style>
th {
	border: solid;
}

td {
	border: solid;
}
</style>
</head>
<body>




	<h1>[ 사원 목록 ]</h1>
	<hr>
	<form method="get">
		<table id="table">

			<tr>
				<td colspan=5><select name="menu" id="menu">
						<option>입사일(년도만)</option>
						<option>이름</option>
				</select> <input type="text" name="search"> <input type="submit" id="submit1"  formaction="<%=request.getContextPath()%>/EmpSearchServlet" value="검색"></td>
			</tr>

			<tr id="chapter">
				<th>정렬기준</th>
				<td colspan=4>월급 높은순 : <input type="radio" value="up" name="range">
					월급 낮은순 : <input type="radio" value="down" name="range"> <input type="submit" value="정렬" formaction="<%=request.getContextPath()%>/SortServelt">
				</td>
			</tr>
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>직업</th>
				<th>입사일</th>
				<th>월급</th>
			</tr>

			<c:forEach var="employee" items="${employees }">
				<tr>
					<td>
					<a href="<%=request.getContextPath() %>/EmpRetrieveServlet?employeeId=${employee.employeeId }">${employee.employeeId }</a>
					</td>
					<td>${employee.email }</td>
					<td>${employee.jobTitle }</td>
					<td><fmt:formatDate value="${employee.hireDate }"
							pattern="YYYY/MM/dd"></fmt:formatDate></td>
					<td>${employee.salary }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="insert.jsp">사원등록</a>
	</form>

</body>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
<%-- 	$.ajax({
		method:"get",
		url:"<%=request.getContextPath()%>/EmpSearchServlet",
		data:${employees }
		success:function(txt){
			var fromServerToObj = Json.parse(txt);
			console.log(fromServerToObj);
		},
		"Content-Type" :"application/x-www-form-urlencoded;charset=utf-8"
	}) --%>
</script>
</html>