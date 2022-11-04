<%@page import="model.Dao.boardDao"%>
<%@page import="model.Dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 JS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
 
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webbox">
		<a href="write.jsp"> 글쓰기 </a>
		
		<!-- JS로 테이블 표시    [ HTML(JSP) --- JS ---- 서블릿 --- DAO ] -->
		<div>게시물 수 : <div class="totalsize"></div></div>
		
		<div>
			<select class="listsize" onchange="blistsize()">
				<option class="5">5</option>
				<option class="10">10</option>
				<option class="15">15</option>
				<option class="20">20</option>
			</select>
		</div>
		
		<table class="btable table">
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th>
				<th> 작성일 </th> <th> 조회수 </th>
			</tr>
		</table>
		
		<div class="pagebox">	<!-- 페이징처리 -->
								
		</div>
		
		<div><!-- 검색처리 -->
			<select class="key">
				<option value="b.btitle">제목</option>
				<option value="b.bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			
			<input placeholder="검색어" class="keyword">
			<button type="button" onclick="bsearch()">검색</button>
			
		</div>
		
	</div>
	
	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

	<script type="text/javascript" src="../js/board/list.js"></script>
</body>
</html>

<!-- <option value="">제목</option>
DB에 저장된 필드명을 value에 넣어주기 -->
<!-- JSP로 테이블 표시   [ 서블릿,js 제외한 ] -->
		<%-- <table>
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th>
			</tr>
			<%  // 스크립트 태그 : html에 java 작성할수 있는 공간
			
			ArrayList<BoardDto> list = boardDao.getInstance().getlist();
			
			for( int i = 0 ; i<list.size() ; i++ ){
			%>
				<tr>
					<td> <%= list.get(i).getBno() %></td>
					<td> <%= list.get(i).getBtitle() %></td>
					<td> <%= list.get(i).getMno() %></td>
				</tr>
			<% 
			}			// <%= 표현식(호출) 
			%>
		</table> --%>