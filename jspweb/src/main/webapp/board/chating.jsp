<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 사용자정의 css -->
	<link href="../css/chating.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<!-- 접속로그인 회원 아이디 숨기기 -->
	<input type="hidden" class="mid" value="<%=loginid%>">
	
	<div class="container"> <!-- 부트스트랩 css는 미리 만들어진 class를 사용 -->
		
		<div class="col-sm-6 offset-3 chattingbox"> <!-- 채팅창구역 -->
			<div class="row">
				<div class="col-sm-4"> <!-- 접속회원 명단 -->
					
				</div>
				<div class="col-sm-8"> <!-- -채팅창 -->
					<div class="contentbox my-3" > 
					
					</div> 
				</div><!-- -채팅창 -->
				<!-- 입력창 -->
				<textarea rows="" cols="" class=" form-control msgbox" onclick="enterkey()"></textarea>
				<!-- 이모티콘,보내기 버튼 -->
				<div class="row">
					<div class="col-sm-2">
						<button class="dropdown-toggle" type="button" id="emobutton" data-bs-toggle="dropdown">
							이모티콘
						</button>
						<ul style="width: 400px; height: 200px;" aria-labelledby="emobutton" class="dropdown-menu">  
							<!-- 이모티콘 표시메뉴 -->
						</ul>
					</div>
					<div class="col-sm-3 offset-7">
						<button class="form-control" type="button" onclick="send()">보내기</button>
					</div>
				</div>
				
			</div>
		</div> <!-- 채팅창구역 -->
		
	</div> <!-- container end -->

	<script type="text/javascript" src="../js/board/chating.js"></script>
</body>
</html>


 

	<!-- <div class="secontesnt my-3">보낼때
							<span class="date">오전 : 10:07</span> 
							<span class="content">안녕하세요</span>
						</div>
						
						<div class="alarm">
							<span>유재석 님이 입장했습니다</span>
						</div>
						
						<div class="row g-0 my-3">받을때
							<div class="col-sm-1 mx-2"> 프로필
								<img class="rounded-circle" alt="" src="/jspweb/image/채팅프로필.jpg" width="100%">
							</div>
							<div class="col-sm-9"> 내용
								<div class="recontent">
									<div class="name">강호동</div>
									<span class="content"> 그래 안녕 </span>
									<span class="date">오전 10:08</span>
								</div>
							</div>
						</div> -->