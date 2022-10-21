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
		<h3>아이디 찾기</h3>
		이름 : 	<input type="text" id="mname">
		전화번호 :	<input type="text" id="mphone">
		<div id="findID"></div>
		<button type="button" onclick="IDfind()">찾기</button>
	</div>
	
	
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/misrID.js"></script>
</body>
</html>