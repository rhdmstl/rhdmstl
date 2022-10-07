<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webbox">
		<h3>아이디찾기</h3>
		이름 : <input type="text" id="mname">
		이메일 : <input type="text" id="memail">
		<div id="fineidconfirmbox"></div> <!-- 결과메세지 -->
		<button type="button" onclick="fineid()">아이디찾기</button>
	</div>
	
	<script src="../js/member/fineid.js" type="text/javascript"></script>
</body>
</html>