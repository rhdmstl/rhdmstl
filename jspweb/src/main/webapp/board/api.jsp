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
	
	<div class="container">
	
	<!-- -9월 서울아파트 실거래가 테이블 -->
	 <table class="table apitable1">
      <tr>
         <th> 시군구 </th>
         <th> 번지본번부번 </th>
         <th> 단지명 </th>
         <th> 전용면적 </th>
         <th> 계약년월 </th>
         <th> 계약일 </th>
         <th> 계약금액 </th>
         <th> 층 </th>
         <th> 건축년도 </th>
         <th> 도로명 </th>
         <th> 해제사유발생일 </th>
         <th> 거래유형 </th>
         <th> 중개사소재지 </th>
      </tr>
   </table>

	<!-- 1.지도를 표시할 div 입니다 -->
	<div id="map" style="width:100%;height:350px;"></div>
	<!-- 약국 마커 -->
		<div class="detailbox">
			
		</div>
		<div class="row">
			<div class="col-sm-3">
				<input type="text" class="form-control addrinput">	<!-- 검색입력박스 -->
			</div>
			<div class="col-sm-1">
				<button type="button" class="btn" onclick="addrsearch()">검색</button>	<!-- 검색버튼 -->
			</div>
		</div>
		
		<table class="table apitable2">
			<tr>
				<th>약국명</th>	<th>전화번호</th>	<th>주소</th>
			</tr>
		</table>
	</div>
	
	
	<!-- 주소를 지도 api & 좌표변경 api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=605c34d237a259e7e176e0d99314f2f3&libraries=services"></script>
	<script type="text/javascript" src="../js/board/api.js"></script>
	
</body>
</html>

	<!-- 
		!important : 제일 먼저 적용됨
		
		
		공공데이터
		*csv 엑셀데이터임
		
		End Point : 이 서버로 들어가면 데이터를 받을 수 있음
		
		200번이라는 코드가 뜨면 성공임
		
		카카오 api
		REST API 키 : 자바
		JavaScript 키 : 스크립트
		geocoder : 주소를 좌표로 변환해줌
	 -->