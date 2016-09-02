<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form id="personform">
		<input type="text" id="name" name="name">
		<input type="text" id="age" name="age">
		<input type="submit">
	</form>
</body>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
	$("#personform").on("submit",function(e){
		e.preventDefault();
		var name =$("#name").val();
		var age = $("#age").val();
		var person = {data:JSON.stringify({"name":name, "age":age})};
		console.log(person);
		$.ajax({
			method:"post",
			url:"<%=request.getContextPath()%>/gson",
			data:person,
			success:function(txt){
				var fromServerToObj = JSON.parse(txt);
				console.log(fromServerToObj);
				$("#age").val(fromServerToObj.age);
			},
			"Content-Type" :"application/x-www-form-urlencoded;charset=utf-8"
		})
		
	});
</script>
</html>