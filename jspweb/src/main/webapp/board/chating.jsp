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
	<!-- 로그인 회원 아이디 숨기기 -->
	<input type="hidden" class="mid" value="<%=loginid%>">
	<div class="webbox">
		<h3>채팅</h3>
		<div class="contentbox"></div><!-- -받은 메세지 출력구역 -->
			
		<!-- 입력 -->
		<textarea rows="" cols="" class="msgbox" onclick="enterkey()"></textarea>
		<!-- 보내기 버튼 -->
		<button type="button" onclick="send()">보내기</button>
	</div>


	<script type="text/javascript" src="../js/board/chating.js"></script>
</body>
</html>