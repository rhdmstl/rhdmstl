<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp" %>
	<h3>회원가입 페이지</h3>
	
	<form action="/jspweb/member/signup" method="post">	<br>
		아이디 :		<input type="text" name="mid">	<br>
		비밀번호 :		<input type="password" name="mpw">	<br>
		비밀번호 확인 :	<input type="password" name="mpwdconfirm">	<br>
		이름 :		<input type="text" name="mname">	<br>
		전화번호 :		<input type="text" name="mphone">	<br>
		이메일 :		<input type="text" name="memail">	<br>
		주소 :		<input type="text" name="maddress">	<br>
		
		<!-- 카카오우편 API -->
		주소 :	<input type="text" name="addrs">
		<input type="text" id="sample4_postcode" placeholder="우편번호"name="maddress1">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="maddress2">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="maddress3">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="maddress4">
	
		<input type="submit" value="회원가입">
	
	</form>
	
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="../js/member/signup.js"></script>

</body>
</html>
	<!-- 
		
		<form action="전송받을 url" method="전송방식"> 
		
		HTTP
		-post : url에 변수 없음(보안높음)
			-회원가입/로그인
			-매번 새로 접속해서 로딩 느림
			-보안에 강해서 회원가입/로그인 시 사용
			
		-get : url에 변수가 표시됨(보안낮음)
			-캐시(전송기록 누적)
			-다음 접속 로딩 단축
			-정보유출등 보안에 상관없는 페이지사용(상세페이지)
	-->