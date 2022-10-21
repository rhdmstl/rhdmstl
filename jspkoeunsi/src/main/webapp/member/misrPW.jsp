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
	
	<div>
		<h3>비밀번호찾기</h3>
		아이디 : <input type="text" id="mid">
		전화번호 :	<input type="text" id="mphone">
		<div id="findPW"></div> <!-- 결과메세지 -->
		<button type="button" onclick="finepw()">비밀번호찾기</button>
	</div>
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/misrPW.js"></script>
</body>
</html>