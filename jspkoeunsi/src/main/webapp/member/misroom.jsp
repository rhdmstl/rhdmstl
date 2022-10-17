<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/jspkoeunsi/misroom" method="get">
		아이디	<input type="text" id="mid" name="mid">
		비밀번호	<input type="password" id="mpw" name="mpw">
		전화번호	<input type="text" id="mphone" name="mphone">
		<input type="submit" value="가입하기">
	</form>
	
	
	
	<script type="text/javascript" src="../js/misroom.js"></script>
	
</body>
</html>