<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>글번호 1</h1>
	<p>글내용</p>
	<p>A와 B가 C하는 사건이 발생했다고 합니다</p>
	<br>
	<hr>
	댓글목록<br>
	<ul id="replys">
	
	</ul>
		<textarea rows="3" cols="100" id="message"></textarea>
		<input type="submit" id="submit">
		
</body>
<script>
	//빈 편지지를 만들어줌
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.querySelector("#replys").innerHTML+="<li>"+xhr.responseText;
		}
	}
	setInterval(function() {
		//그 편지지가 어떤 역활을 할지..
		
		//편지를 어디로 보낼까?
		var url = "<%=request.getContextPath()%>/reply";
		xhr.open("GET", url, true);
		//편지 보내기
		xhr.send();

	}, 1000*10)
	
	document.querySelector("#submit").addEventListener("click",function(){
		var message = document.querySelector("#message").value;
		var url ="<%=request.getContextPath()%>/reply";
		
		xhr.open("post" ,url,true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("message="+message);
	})
</script>
</html>