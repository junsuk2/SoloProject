<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.example.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">

<h1 class="title">Region Manage System</h1>
<div id="loginArea">
	<!-- 만약에 session에서 region을 확인할 수 없다면. -->
	<c:choose>
		<c:when test="${ empty region }">
			<form method="post"
				action="<%=request.getContextPath()%>/getRegion">
				<input type="text" name="regionId">
				<input type="text" name="regionName">
				<input type="submit" value="로그인">
			</form>
			<a href="<%=request.getContextPath()%>/user/joinform.jsp">
				가입하기
			</a>
		</c:when>
		<c:otherwise>
			<a href="#">${region.regionName }</a>
			<a href="<%=request.getContextPath() %>/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>

<ul class="horMenu">
	<li><a href="<%=request.getContextPath()%>/region">전체 Region 조회</a>
	<li><a href="<%=request.getContextPath()%>/region/singleRegion.jsp">Region 수정</a>
	<li>Region 삭제
</ul>
<hr>