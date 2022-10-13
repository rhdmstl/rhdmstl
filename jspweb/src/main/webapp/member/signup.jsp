<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jspweb/css/signup.css">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webbox">
		<form class="signupform" action="/jspweb/member/signup" method="post">	<br>
			<h3 class="pagetitle">회원가입</h3>
			<h3 class="parttitle">기본정보</h3>
			<table class="signuptable">
				<tr>
					<td class="col1">아이디 * </td>
					<td class="col2"> <input type="text" name="mid" id="mid" onkeyup="mevent1()"> </td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 * </td>
					<td class="col2"> <input type="password" name="mpw" id="mpw" onkeyup="mevent2()"> </td>
					<td rowspan="2" class="col3"></td>
				</tr>
				<tr>
					<td class="col1">비밀번호 확인 * </td>
					<td class="col2"> <input type="password" name="mpwconfirm" id="mpwconfirm" onkeyup="mevent3()"> </td>
					
				</tr>
				<tr>
					<td class="col1">이름 * </td>
					<td class="col2"> <input type="text" name="mname" id="mname" onkeyup="mevent4()"> </td>
					<td class="col3"> </td>
				</tr>
				<tr>
					<td class="col1">전화번호 * </td>
					<td class="col2"> <input type="text" name="mphone" id="mphone" onkeyup="mevent5()"> </td>
					<td class="col3"> </td>
				</tr>
				<tr>
					<td class="col1">이메일 * </td>
					<td class="col2"> <input type="text" name="memail" id="memail" onkeyup="mevent6()"> </td>
					<td class="col3"></td>
				</tr>
				<tr>
					<td rowspan="2" class="col1" > 주소 * </td>
					<td colspan="2" class="col2"> 
						<span>
							<input type="text" id="sample4_postcode" placeholder="우편번호" name="maddress1">
							<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						</span>	
						<span>
							<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="maddress2">
							<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="maddress3">
						</span>
					</td>
				</tr>
				<tr>
					<td class="col2"> <input type="text" id="sample4_detailAddress" placeholder="상세주소" name="maddress4"> </td>
					<td class="col3"> </td>
				</tr>
			</table>
			
			<h3 class="parttitle">이용약관</h3>
			<span class="confirmbox ">
				<textarea readonly="readonly"></textarea>
				<input id="confirm1" type="checkbox"> <span>[필수] 이용약관 동의</span>
				
				<textarea readonly="readonly"></textarea>
				
				<input id="confirm2" type="checkbox"> <span>[필수] 개인정보 수집 동의</span>
			</span>
			
			<div class="signupbtnbox">
				<button type="reset">취소</button>
				<button type="button" onclick="formsubmit()">회원가입</button>
			</div>
		</form>
	</div>
	
	
	
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