<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<h3>로그인페이지[js ajax(비동기식) 전송]</h3>
		아이디 : 		<input type="text" id="mid">	<br>
		비밀번호 : 	<input type="text" id="mpassword">
		<input type="submit" onclick="login()" value="로그인">
		
		<ul>
			<li> <a href="signup.jsp">회원가입</a> </li>
			<li> <a href="fineid.jsp">아이디찾기</a> </li>
			<li> <a href="#">비밀번호찾기</a> </li>
		</ul>
		
	<div id="loginconfirmbox"></div> <!-- 결과 메세지  -->

	<script src="../js/member/login.js" type="text/javascript"></script>
</body>
</html>