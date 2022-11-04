<%@page import="model.Dto.prouctDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Dao.productDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<table class="table">
			<tr>
				<th style="width:5%"> 이미지 </th> 
				<th style="width:10%"> 제품번호 </th>
				<th style="width:10%"> 카테고리 </th>
				<th style="width:10%"> 제품명 </th>
				<th style="width:10%"> 가격 </th>
				<th style="width:10%"> 할인율 </th>
				<th style="width:10%"> 판매가<br>[*할인율적용] </th>
				<th style="width:10%"> 판매상태 </th>
				<th style="width:15%"> 등록날짜 </th>
				<th style="width:10%"> 비고 </th>
			</tr>
		</table>
	</div>
	
	<!-- 부트스트랩 : 모달 -->
	<!-- Button trigger modal -->
	<button style="display: none;" type="button" class="updatemodalhtn btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
	</button>
	
	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content"> 			<!-- 모달내용 -->
	    
	      <div class="modal-header">				<!--  모달 타이틀  -->
	        <h1 class="modal-title fs-5" id="staticBackdropLabel">제품 수정 창</h1>
	      </div>
	      
	      <div class="modal-body">					<!-- 모달 본문 -->
	      	<!-- regist.jsp form 사용 -->
	      	
	      	<form class="updateform">
	      		제품번호 : <input type="text" readonly="readonly" name="pno"  		class="pno"  > <br> 
				제품명 : 	<input type="text" 						name="pname"  	class="pname" > <br>
				설명 : 	<textarea rows="" cols="" 				name="pcomment"	class="pcomment" ></textarea> <br>
				가격 : 	<input type="text" 						name="pprice"	class="pprice" > <br>
				할인율 : 	<input type="text" 						name="pdiscount"class="pdiscount" > <br>
				카테고리 : <span class="pcategorybox"></span>  <br>
				제품상태 : 
					<input type="radio" value="0" name="pactive" class="pactive"> 준비중 
					<input type="radio" value="1" name="pactive" class="pactive"> 판매중
					<input type="radio" value="2" name="pactive" class="pactive"> 재고없음<br>
				<input type="file" id="pimg" name="pimg"> <br>
			 </form>
	      </div>
	      <div class="modal-footer">				<!-- 모달 푸터 -->
	        <button type="button" class="modelclosebtn btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary" onclick="updateproduct()">수정</button>
	      </div>
	      
	      
	    </div>
	  </div>
	</div>

<!-- 내 스크립트 -->
<script type="text/javascript" src="../js/admin/list.js"></script>
</body>
</html>

<%-- <% //서블릿역할[코드입력 구간]
			ArrayList<prouctDTO> list = new productDAO().getproductlist();
		%>
		<table>
			<tr>/
				<th>제품명</th>	<th>제품이미지</th>	
			</tr>
			<%
				for(int i = 0 ; i < list.size() ; i++)
			%>
			<tr>
				<td> <%=list.get(i).getPname %> </td>
				
			</tr>
		</table> --%>