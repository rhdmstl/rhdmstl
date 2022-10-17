<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	
		<h3>게시판</h3>
		제목 :		<input type="text" id="mtitle">
		내용 :		<input type="text" id="mcontent">
		작성자 :		<input type="text" id="mwtiter">
		비밀번호 :		<input type="text" id="mpw">
		<button type="button" onclick="post()">글 등록</button>
		
		<div class="webbox">
			<h3>글 목록</h3>
			<table id="postlist">
				<tr>
					<th> 번호 </th> <th> 제목 </th> <th> 내용 </th>
					<th> 작성자 </th> <th> 날짜 </th> <th> 조회수 </th>
				</tr>
			</table>
		</div>
		
		<div class="btnbox">
			<a href="list.jsp">목록보기</a>
		</div>
	
	<!-- jquery 라이브러리 (api)-->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../js/post.js"></script>
</body>
</html>