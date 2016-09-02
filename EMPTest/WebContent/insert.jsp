<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	th{
		border:solid;
	}
	
	td{
		border:solid;
	}
</style>
</head>
<body>
	<form method="post" action="<%=request.getContextPath() %>/EmpWriteFormServlet">
	<h1>[ 사원 등록 ]</h1>
	<hr>
	<table>
		<tr>
			<th>사원번호</th>
			<td><input type="text" name="employeeId" value="1000" readonly></td>			
		</tr>
		<tr>
			<th>사원이름</th>
			<td><input type="text" name="employeeName" maxlength="3"></td>			
		</tr>
		<tr>
			<th>직업</th>
			<td>
			<select name="job" id="job">
			<option value="PU_CLERK">CLERK</option>
			<option value="ST_MAN">MANAGER</option>
			<option value="IT_PROG">PROGRAMMER</option>
			</select>
			</td>			
		</tr>
		<tr>
			<th>관리자</th>
			<td><input type="text" name="manager_id" value="7962" readonly></td>			
		</tr>
		<tr>
			<th>입사일</th>
			<td><input type="text" name="hireDate" value="sysdate" readonly></td>			
		</tr>
		<tr>
			<th>월급</th>
			<td><input type="text" name="salary" value="1500" readonly></td>			
		</tr>
		<tr>
			<td colspan="2" width="500px" ><center><input type="submit" value="사원등록"><input type="reset" value="다시 입력"> </center></td>
		</tr>
		
	</table>
	<a href="<%=request.getContextPath() %>/EmpListServlet">목록보기</a>
	</form>
</body>
<script>
</script>
</html>