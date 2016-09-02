<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		//scriptlet --> local 변수	
		int result = 0;
		for(int i=0; i<100; i++){
			result+= i;
		}
		
		//sum이라는 이름으로 request 영역에 저장
		request.setAttribute("sum", result);
		request.setAttribute("name", "andy");
	%>
	
	expression tag :  <%=result %><br>
	expression language : ${sum }<br>
	expression language : ${name.length()}
</body>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
	$(function(){
		alert("express tag 1" + <%=result %>);
		alert("express tag 2" + "<%=result %>");
		
		alert("express language 1" + ${sum });
		alert("express language 2" + "${sum }");
		alert
	})
	
</script>
</html>