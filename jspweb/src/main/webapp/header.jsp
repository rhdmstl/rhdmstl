<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이젠 쇼핑몰</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<!-- 반응형 뷰포트 -->
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
				<li> <a class="nav-link" href="/jspweb/member/login.jsp">로그인</a> </li>
				<li> <a class="nav-link" href="/jspweb/member/signup.jsp">회원가입</a> </li>
			<%}else if(loginid.equals("admin")){//관리자로그인 햇다 %>
			 	<li> <a class="nav-link" href="/jspweb/admin/dashboard.jsp">관리자페이지</a> </li>
		
			<%}else{//로그인 햇다 %>
			 	<li> <%= loginid %>님 안녕하세요 </li>
			 	<li> <a class="nav-link" href="/jspweb/member/logout.jsp">로그아웃</a> </li>
			<% } %>
				<li> <a class="nav-link" href="/jspweb/member/info.jsp">마이쇼핑</a> </li>
				<li> <a class="nav-link" href="/jspweb/board/list.jsp">고객센터</a> </li>
			</ul>	<!-- 상단메뉴 끝 -->
			
		
	</div><!-- 하단 헤더 -->
	
	<ul class="hd_menu">
		<li><a class="nav-link" href="#"> BIG SIZE! </a></li>
		<li><a class="nav-link" href="#"> 1+1 이벤트 </a></li>
		<li><a class="nav-link" href="#"> 아우터 </a></li>
		<li><a class="nav-link" href="#"> 상의 </a></li>
		<li><a class="nav-link" href="#"> 바지 </a></li>
		<li><a class="nav-link" href="#"> 슈즈 </a></li>
		<li><a class="nav-link" href="#"> 악세사리 </a></li>
		<li><a class="nav-link" href="#"> BEST </a></li>
		<li><a class="nav-link" href="#"> 트레이닝 </a></li>
		<li><a class="nav-link" href="/jspweb/board/api.jsp"> API공공데이터 </a></li>
		<li><a class="nav-link" href="/jspweb/board/chating.jsp"> 채팅방 </a></li>
		<li class="searchbox">
			<span>
				<input>
				<i class="fas fa-search"></i><!-- 검색 -->
			</span>
			 <a href="/jspweb/product/cart.jsp"> <i class="fas fa-shopping-cart"> </i></a>  <!-- 장바구니 -->
		</li>
	</ul>
</div>
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script><!-- 뷰포트 -->
	
</body>
</html>

	<!-- 
	
		헤더파일[ 모든 페이지에서 호출됨]
		상대경로 : 기준점이 깨져서 호출안됨
		절대경로 : 변하지않기때문에 호출 가능
		
		/	: 최상위 경로 localhost:8080/ [맨앞에 넣어줘야함]
			: 현재경로의 페이지를 불러와서 깨짐[경우의 수 증가]


	<div> : 레이아웃 박스권 구역(한줄)
	
	<span> : inline(한칸)

-->
