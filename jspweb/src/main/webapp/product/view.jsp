<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/productview.css" rel="stylesheet">
</head>
<body>
	
	<%@include file="../header.jsp" %>
	
	<%//자바를 이용할 수 있는 서블릿 
		//경로에있는 pno 리퀘ㅅ투 ㅇㅅ퐁
		//만약에 요청변수가 없을 경우
		int pno =  Integer.parseInt(request.getParameter("pno")); 
		//로그인된 회원정보 호출
		Object object = session.getAttribute("mid");
		String mid = null;
		if(object != null){
			mid = (String)object;	//로그인완 강제형변환
		}
	%>
	
	<input type="hidden" value="<%= pno%>" class="pno"> <!-- 제품번호 -->
	<input type="hidden" value="<%= mid%>" class="mid"> <!-- 회원아이디 -->
	
	<div class="container">
		<div class="row">
			<!-- 대표이미지 -->
			<div class="col-md-6">
				<img alt="" src="/jspweb/image/indeximg.jpg">
			</div>
			<!-- 상품 정보 -->
			<div class="col-md-6">  <!-- b : col-md-6  -->
				<div class="infobox">
					
					<!-- 제품명 -->
					<h4 class="pname"> </h4>
					
					<!-- 제품설명 -->
					<div class="pcomment"> </div>
					
					<!-- 가격 -->
					<div class="pricebox">	<!-- 할인율이 있을경우 -->
						<span class="pdiscount"></span>
						<span class="pprice"></span>
						<span class="psale"></span>
					</div>
					
					<!-- 사이즈 종류 -->
					<div class="sizebox"> </div>
					
					<!-- 제품 옵션 -->
					<table class="table info_t">	<!--  b: table -->
						<tr> <td>배송구분</td> <td>2,500원 ( 70,000원 이상 구매시 무료) </td> </tr>
						<tr> <td>카드혜택</td> <td> 무이자할부 </td> </tr>
						<tr> <td>적립혜택</td> <td> 3000(1%) </td> </tr>
						
						<!-- 색상 선택 행 -->
						<tr> <td>색상</td> 	
							<td>
								<select class="form-select cselect"> 

								</select>
							 </td> 
						</tr>
						
						<!-- 사이즈 선택 행 -->
						<tr> <td>사이즈</td> 	
							<td>
								<select class="form-control sselect">
									<option>-[필수] 색상 우선 선택 </option>
								</select>
							 </td> 
						</tr>
					</table>
					<!-- 선택된 제품 목록 -->
					<table class="table select_t">
						
					</table>
					<!-- 선택된 제품들의 총 가격 -->
					<div class="row">
						<div class="col-md-6">총 상품 금액</div>
						<div class="col-md-6 totalprice"> 0원(0개)</div>
					</div>
					<!-- 버튼 -->
					<div class="btnbox">
						<button id="btn1">바로구매</button>
						<button id="btn2" class="btncart">장바구니</button>
						<button id="btn3" class="btnlike">찜하기 ♡</button>	<!-- (db)로그인된 회원의 찜이 안됨 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="../js/product/productview.js"></script>
	
</body>
</html>