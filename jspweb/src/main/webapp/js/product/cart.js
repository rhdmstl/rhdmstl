/**
 * 
 */alert('cart')

 let cartlist = null;  //장바구니 리스트
 let totalprice = 0; //총 주문금액
 
 getcart()
 //장바구니 보기
 function getcart(){
	$.ajax({
		url : "/jspweb/product/cart",
		type : "GET",
		success : function(re){
			cartlist = JSON.parse(re)
			console.log(cartlist)
			//사용할 html
			html = '<tr>  <th width="5%"> <input type="checkbox"> </th> <th width="20%">이미지</th> <th width="50%">상품정보</th> <th width="20%">수량</th> <th width="5%">가격</th> <th width="5%">비고</th> </tr>'
			
			//반복문으로 하나씩 꺼내오기
			cartlist.forEach(c =>{
				html += '<tr>'+
						'<td> <input type="checkbox"> </td>'+
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
//회원정보 가져오기
let member = null;
getmember()
function getmember(){
	$.ajax({
		url : "/jspweb/member/info",
		success : re => {
			member = JSON.parse(re)
		}
	})
}
 //결제 API 아임포트//////////////////////////////////////////////////////////////////////////
   var IMP = window.IMP;   // 생략 가능
   IMP.init("imp14103839"); // 예: imp00000000 
   
   function requestPay() {
      IMP.request_pay({ 
          pg: "kcp", //카드사넣기
          pay_method: "card",
          merchant_uid: "",   //주문번호[1.자동번호 2.직접만들기(날짜+시간+id값+난수)]
          name: cartlist[0].pname+"외"+cartlist.length,
          amount: totalprice,                         // 숫자타입
          buyer_email: member.memail,
          buyer_name: member.mname,
          buyer_tel: member.mphone,
          buyer_addr: member.maddress,
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {

          } else { // 결제 성공 시 로직,(실패시 성공)
             alert('결제성공')
          }
      });
    }
   
   