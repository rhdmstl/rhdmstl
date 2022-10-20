<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/jspkoeunsi/misroom" method="post" class="signupform">
	
		<h3 class="pagetitle">회원가입</h3>
		이름		<input type="text" id="mname" name="mname" onkeyup="mevent1()">
		<div class="col"></div>
		아이디	<input type="text" id="mid" name="mid" onkeyup="mevent2()">
		<div class="col"></div>
		비밀번호	<input type="password" id="mpw" name="mpw" onkeyup="mevent3()">
		<div class="col"></div>
		전화번호	<input type="text" id="mphone" name="mphone" onkeyup="mevent4()">
		<div class="col"></div>
		
		<h3 class="parttitle">이용약관</h3>
			<span class="confirmbox ">
				<textarea readonly="readonly"></textarea>
				<input id="confirm1" type="checkbox"> <span>[필수] 이용약관 동의</span>
				
				<textarea readonly="readonly"></textarea>
				
				<input id="confirm2" type="checkbox"> <span>[필수] 개인정보 수집 동의</span>
			</span>
		
		<div class="signupbtnbox">
			<button type="reset">취소</button>
			<button type="button" onclick="formsubmit()">회원가입</button>
		</div>
		
	</form>
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/misroom.js"></script>
	
</body>
</html>