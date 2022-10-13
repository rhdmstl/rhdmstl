<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이젠 쇼핑몰</title>
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	<link rel="stylesheet" href="/jspweb/css/header.css">
</head>
<body>
	
	<div class="webbox"> <!-- 전체박스권 -->
		<div class="head_top"><!-- 상단헤더 -->
		
			<div><!-- 로고 -->
				<span class="hd_title"> 
					<a href="/jspweb/index.jsp">Ezen shop</a> 
				</span>
			</div>
			
			<!-- 세션호출[JSP방식 = 템플릿마다 다름(JSP vs 리액트) 
			// 형변환 : 세션자료형 = object// jsp 기본 객체로 세션 제공 -->
			<% String loginid = (String)session.getAttribute("mid"); %>
			
			<ul class="hd_sub">	<!-- 상단메뉴 -->
			<!-- 비로그인 메뉴 -->
			<% if(loginid == null){ %>
				<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
				<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
			<%}else{//로그인 햇다 %>
			 	<li> <%= loginid %>님 안녕하세요 </li>
			 	<li> <a href="/jspweb/member/logout.jsp">로그아웃</a> </li>
			<% } %>
				<li> <a href="/jspweb/member/info.jsp">마이쇼핑</a> </li>
				<li> <a href="/jspweb/board/list.jsp">고객센터</a> </li>
			</ul>	<!-- 상단메뉴 끝 -->
		
		
	</div><!-- 하단 헤더 -->
	
	<ul class="hd_menu">
		<li><a href="#"> 세일 </a></li>
		<li><a href="#"> 1+1 이벤트 </a></li>
		<li><a href="#"> 아우터 </a></li>
		<li><a href="#"> 상의 </a></li>
		<li><a href="#"> 하의 </a></li>
		<li><a href="#"> 슈즈 </a></li>
		<li><a href="#"> 악세사리 </a></li>
		<li><a href="#"> 베스트 </a></li>
		<li><a href="#"> 트레이닝 </a></li>
		<li><a href="#"> 할인 </a></li>
		<li><a href="#"> 남성용 </a></li>
		
		<li class="searchbox">
			<span>
				<input>
				<i class="fas fa-search"></i><!-- 검색 -->
			</span>
			<i class="fas fa-shopping-cart"></i> <!-- 장바구니 -->
		</li>
	</ul>
</div>
		<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>
<!--

	<div> : 레이아웃 박스권 구역(한줄)
	
	<span> : inline(한칸)

-->
