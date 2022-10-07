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
	<!-- 아이콘 -->
	
	<link rel="stylesheet" href="/jspweb/css/header.css">
</head>
<body>
	
	<div class="webbox"> <!-- 전체박스권 -->
	
		<div class="head_top"><!-- 상단헤더 -->
		
			<div><!-- 로고 -->
				<span class="hd_title"> 
					<a href="#">Ezen shop</a> 
				</span>
			</div>
			
			<ul class="hd_sub">
				<li> <a href="/jspweb/member/login">로그인</a> </li>
				<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
				<li> <a href="#">마이쇼핑</a> </li>
				<li> <a href="#">고객센터</a> </li>
			</ul>
		</div>
		
	</div><!-- 전체박스권 -->
	
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
				<i class="fas fa-shopping-cart"></i> <!-- 장바구니 -->
			</span>
		</li>
	</ul>
		<!-- jquery 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>
<!--

	<div> : 레이아웃 박스권 구역(한줄)
	
	<span> : inline(한칸)

-->
