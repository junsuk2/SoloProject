<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>file upload</h1>
	<form method="post" enctype="multipart/form-data" action="./upload">
		<input type="file" name="file1">
		<input type="text" name="desc1" placeholder="설명"><br>
		<input type="file" name="file2">
		<input type="text" name="desc2" placeholder="설명"><br>
		<input type="submit">
	</form>
	
	<h1>이미지 미리보기</h1>
	<img src="" id="preview" width="100px" height="100px">
</body>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
	$("input[type=file]").on("change",function(){
		//파일을 읽기 위한 FileReader 생성
		var reader = new FileReader();
		
		//input 요소에서 파일 가져오기
		var file = this.files[0];
		console.log(file.type);
		//파일의 타입이 이미지로 시작한다면
		if(file.type.startsWith("image")){
			//reader에게 다 읽었을 경우 preview를 설정하도록 리스너 등록
			$(reader).on("load",function(){
				//this.result --> reader을 통해 읽어준 값
				$("#preview").attr("src", this.result);
			})
			//이제 reader에게 읽으라고 명령
			reader.readAsDataURL(file);
		}
	})
</script>
</html>