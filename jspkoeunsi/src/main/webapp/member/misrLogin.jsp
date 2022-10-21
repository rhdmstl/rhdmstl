<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인</h3>
		아이디	<input type="text" id="mid"><br>
		비밀번호	<input type="password" id="mpw">
		<input type="submit" onclick="login()" value="로그인">
		
	<div id="loginbox"></div> <!-- 결과 메세지  -->
		
		
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/misrLogin.js"></script>
</body>
</html>