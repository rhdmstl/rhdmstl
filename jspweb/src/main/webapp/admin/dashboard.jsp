<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 css -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 	<link href="/jspweb/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<!-- 관리자 페이지 -->
	<!-- 만약에 세션이 없거나 관리자가 아니면 -->
	<%	
		// 세션은 오브젝트로 들어가기때문에 형변환 필수
		String mid = (String)session.getAttribute("mid");
		if(mid == null || !mid.equals("admin")){
			response.sendRedirect("../member/login.jsp");
		}
	%>
	<!-- marquee:텍스트 슬라이드 / (속성) scrollamount : 숫자가 클수록 속도가 빨라짐-->
	<marquee scrollamount="10">공지사항 위치</marquee>
	
	<!-- 사이드바[펼치기/접기] -->
	<div class="sidebar">
		<h1>관리자메뉴</h1>
		<ul class="side_menu"> 
			<li class="side_item"> <a onclick="pagechange('regist.jsp')">제품등록</a> </li>
			<li class="side_item"> <a onclick="pagechange('list.jsp')">제품목록</a> </li>
			<li class="side_item"> <a onclick="pagechange('stock.jsp')">재고관리</a> </li>
			<li class="side_item"> <a href="#">주문관리</a> </li>
			<li class="side_item"> <a href="#">매출관리</a> </li>
			<li class="side_item"> <a href="#">회원관리</a> </li>
			<li class="side_item"> <a href="#">배송관리</a> </li>
			
			<li class="side_item"> <a href="/jspweb/member/logout.jsp">로그아웃</a> </li>
		</ul>
	</div>
	
	<!-- 본문페이지가 보이는 div입니다 -->
	<div id="mainbox">
		<!-- 사이드바에서 메뉴 클릭 시 jsp가 표시되는 구역 -->
	</div>
	
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js -->
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script><!-- 뷰포트 -->
	<script type="text/javascript" src="../js/admin/dashboard.js"></script>
</body>
</html>

