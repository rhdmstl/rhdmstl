/**
 * 
 */
 alert('인덱스')
 
 let html = '';
 
 getpactive1();
 function getpactive1(){
	$.ajax({
		url : "/jspweb/admin/regist",
		data : { "type" : 1 , "option" : 'pactive1' },
		success : function(re){
			console.log(re)
			let json = JSON.parse(re)
			json.forEach( p =>{
				html +=
				'<div class="item">	'+ //? -> get방식으로 변수를 보내는 방법
				'	<a href="/jspweb/product/view.jsp?pno='+p.pno+'">  '+
				'		<img src="/jspweb/admin/pimg/'+p.pimg+'">'+
				'	</a>'+
				'	<div class="item_info">'+
				'		<div class="item_title"> 	'+
				'			트렌디한 크롭 기장의 덤블안감 카라넥 스웨이드 무스탕'+
				'		</div>'+
				'		<div class="item_size"> [FREE] </div>'+
				'		<div class="item_price"> 200,000 원 </div> '+
				'		<div> '+
				'			<span class="item_sale"> 20,000원 </span>'+
				'			<span class="item_discount"> 90% </span>'+
				'		</div>	'+
				'		<div class="item_review">찜수 54 리뷰수 412</div> '+
				'		'+
				'	</div>'+
				'	<div>	'+
				'		<span class="badge rounded-pill text-bg-warning">주문폭주</span>'+
				'		<span class="badge rounded-pill text-bg-danger">1+1</span>'+
				'	</div>'+
				'</div>';
			})
			document.querySelector('.itemlist').innerHTML += html
		}
	})
 }