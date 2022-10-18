<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 썸머노트 API css -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
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
		<form>
			제목 : 	<input type="text" name="btitle"> <br>
			<!-- 섬머노트 -->
  			<textarea id="summernote" name="bcontent"></textarea>
			첨부파일 :	<input type="file" name="bfile"> <br>
			<!-- form태그 안에서는 버튼 타입으로 수정하기 -->
			<button type="button" onclick="bwrite()">쓰기</button> 
		</form>
		
	</div>
	
	<!-- 썸머노트 API js -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script src="lang/summernote-ko-KR.js"></script>
	<!-- 사용자정의 js -->
	<script type="text/javascript" src="../js/board/write.js"></script>
	
</body>
</html>