/**처리되는 순서 잘 생각하기
 * async : false = 결과가 발생할때까지 대기
 	currentTarget.checked = 이벤트를 반환시키는 콜백함수임 체크하는것에 따라 메소드 만들기[checked:체크속성임]
 		-board chating 에서 많이 사용됨
 		
 	스크립트 실행주체는 사용자(이용자)서버X
 	실행위치는 HTML안에서 열림 - HTTP는 문서교환 통신이기 때문에 HTML에 js를 포함해서 전송함
 	HTML새로 열리거나 새로고침되면 스크립트도 같이 로딩됨(같이 새로고침)메모리를 초기화함
 	HTML[변경될때 메모리 유지] - 차이점 : 생명주기
 	-- js가 새로고침(닫혀도) 메모리 유지됨
 	-- Object로 저장됨[문자열로 저장] (제품저장하거나 글쓰기 할때 mid꺼내올때마다 형변환했음)
 	-- 저장
 			sessionStorage.getitem('key')-키값만 가져와도됨 , value)
 			localStorage.getitem('key')-키값만 가져와도됨 , valu)
 	-- 생명주기(삭제)
 			-모든 메모리 삭제
 			sessionStorage.clear()
 			localStorage.clear()
 			
 			-특정메모리 삭제 가능
 			sessionStorage.removeitem('key')-키값만 가져와도됨 , value)
 			localStorage.removeitem('key')-키값만 가져와도됨 , valu)
 			
 		-1.세션 : (sessionStorage)java/js다 있음
 			- 모든 브라우저 닫을때 삭제 [서버에 저장]
 			*열려있는 브라우저끼리 데이터 공유[X]
 			= 
 		-2.쿠키 : (localStorage)java/js다 있음
 			- 브라우저를 닫았다 열어도 유지됨[클라이언트(사용자)컴퓨터에 저장] 
 			*열려있는 브라우저끼리 데이터 공유[O]
 */
 alert('cart')
 
 let cartlist = null;  //장바구니 리스트
 let totalprice = 0; //총 주문금액
 
  getcart()  //장바구니 보기
 
 let checkbtnlist = document.querySelectorAll('.checkbtn')//1.모든 체크박스 가져오기

 checkbtnlist[0].addEventListener('click' , (e) => {
	alert('클릭')
	//  첫번째 체크박스에 체크가 되어 있는경우 모든 체크박스에 체크 
		// e.currentTarget : 이벤트를 발생시킨 대상의 이벤트 정보
			// checked : 속성 [ 체크 여부 ] radio , checkbox
	if(e.currentTarget.checked == true){
		checkbtnlist.forEach(c=> {c.checked = true})
	}
	else{ //2.아니면 모두 체크취소
		checkbtnlist.forEach(c=> {c.checked = false})
	}
})
 //장바구니에서 체크된 제품만 저장
 let checkplist = []
 
 //2.장바구니에서 선택(체크된)제품만 결제페이지로 이동
 function payload(){
	checkbtnlist.forEach((c,i)=>{ //(값,인데스)
		if( i != 0 && c.checked == true){//체크가 되었을때
			checkplist.push(cartlist[i-1]) //첫번째 체크박스 제품이 아니기때문에 -1을 함
		}
		if(checkplist.length == 0){// 만일 1개도 체크된 제품이 없으면
			alert('한개이상 선택해주세요')
			return;
		}
		localStorage.removeItem('checkplist'); //저장소 초기화
		localStorage.setItem('checkplist',JSON.stringify(checkplist) ); //저장소 생성[JSON.stringify:문자열로 저장]
		location.href = '/jspweb/product/pay.jsp'
	})
}
 
//장바구니 호출
 function getcart(){
	$.ajax({
		url : "/jspweb/product/cart",
		type : "GET",
		async : false,	// 결과가 있을때까지 대기 상태 
		success : function(re){
			cartlist = JSON.parse(re)
			console.log(cartlist)
			//사용할 html
			html = '<tr>  <th width="5%"> <input type="checkbox" class="checkbtn"> </th> <th width="20%">이미지</th> <th width="50%">상품정보</th> <th width="20%">수량</th> <th width="5%">가격</th> <th width="5%">비고</th> </tr>'
			
			//반복문으로 하나씩 꺼내오기
			cartlist.forEach(c =>{
				html += '<tr>'+
						'<td> <input type="checkbox" class="checkbtn"> </td>'+
						'<th> <img width="80%" alt="" src="/jspweb/admin/pimg/'+c.pimg+'"> </th>'+
						'<th> '+c.pname+' <br> - '+c.pcolor+' / '+c.psize+' </th>'+
						'<th> '+c.amount+' </th>'+
						'<th> '+c.amount*(c.pprice-(c.pprice*c.pdiscount))+' </th>'+
						'<th> <button type="button">삭제</button> </th>'+
						'</tr>';
				totalprice += c.amount*(c.pprice-(c.pprice*c.pdiscount));
			})
			//불러온 정보 담기
			document.querySelector('.cart_t').innerHTML = html;
		}
	})
}


