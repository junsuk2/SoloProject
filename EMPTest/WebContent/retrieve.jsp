<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 관리</title>
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
	<form method="get" action="<%=request.getContextPath()%>/EmpUpdateServlet">
	
		<table>
			
				<tr>
					<th>사원번호</th>
					<td><input type="text" name="employeeId" value="${employees.employeeId}" readonly></td>
				</tr>
				<tr>
					<th>사원이름</th>
					<td>${employees.email}</td>
				</tr>
				<tr>
					<th>직업</th>
					<td><select name="job" id="job">
							<option >${employees.jobTitle }</option>
							<option value="PU_CLERK">CLERK</option>
							<option value="ST_MAN">MANAGER</option>
							<option value="IT_PROG">PROGRAMMER</option>
					</select>
				</tr>
				<tr>
					<th>관리자</th>
					<th>7566</th>
				</tr>
				<tr>
					<th>입사일</th>
					<td>${employees.hireDate}</td>
				</tr>
				<tr>
					<th>월급</th>
					<td><input type="text" name="salary" value="${employees.salary }"></td>
				</tr>
				<tr>
					<td colspan=2><center>
							<input type="submit" value="사원 수정">
						</center></td>
				</tr>
			
		</table>
	<a href="<%=request.getContextPath() %>/EmpListServlet">목록보기</a>
	<a href="<%=request.getContextPath() %>/EmpDeleteServlet?employeeId=${employees.employeeId}">삭제</a>
	</form>

</body>

<script>
	
</script>
</html>