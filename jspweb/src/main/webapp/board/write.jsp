<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<!-- 회원일 경우에만 페이지로드 -->
	<% if(loginid == null) response.sendRedirect("/jspweb/member/login.jsp"); %>
	
	<div class="webbox">
	 
		<h3>글쓰기</h3> 
		 <!--
		<!-- form = 페이지전환 , ajax 페이지전환 없음 -->
		<!-- 
		<form method="get" action="/jspweb/board/write">
			제목 : <input type="text" name="btitle">
			내용 : <input type="text" name="bcontent">
			<button type="submit">쓰기</button>
		</form>
		-->
	
		제목 : 	<input type="text" name="btitle"> <br>
		내용 : 	<input type="text" name="bcontent"> <br>
		첨부파일 :	<input type="file"> <br>
		<button onclick="bwrite()">쓰기</button> 
	
	</div>
	
	<script type="text/javascript" src="../js/board/write.js"></script>
	
</body>
</html>