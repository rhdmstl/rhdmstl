/*
	- 함수
	1. 함수명()
	2. function(인수){ }
	3. 인수 => { }
	
	- 콜백함수 : 함수실행 반환 결과를 [콜백]함수에게 인수로 전달 
		- 함수1 에서 실행된 반환값을 콜백함수의 인수로 전달
	1. 함수1( 콜백함수2(인수) )	
	2. 함수1( 인수 => function(인수){ } )
	3. 함수1( 인수 => { } )
	
	- 활용
	.addEventListener( '이벤트명' , 함수호출[1~3] )
	.forEach( 인수 => { 코드 } )
	
	== 	: 같다[값만 비교]
	=== : 같다 [자료형,값 비교] = 강력비교
*/
 let stock = null;
 let productlist = null;	//모든 리스트를 가지고 있는 리스트

 
let cselect = document.querySelector('.cselect') // 카테고리 선택 상자 
let pselect = document.querySelector('.pselect') // 제품 선택 상자
let rows = document.querySelectorAll('.rows') // 재고 등록행

// 카테고리 선택를 클릭했을떄 제품출력 메소드 호출
cselect.addEventListener( 'click' ,e => {
	let pcno = e.currentTarget.value	//선택된 카테괴 번호
	getproduct(pcno);
} )

// 제품 목록에서 선택을 했을때 [change]목록이 두개 이상이여야 가능
// html로 재구성
 pselect.addEventListener( 'click' ,e => {
	let pno = e.currentTarget.value	//선택된 카테괴 번호
	productlist.forEach(p=>{
		if(p.pno == pno ){ //해당 제품의 번호와 선택된 제품의 번호가 같으면
			rows[0].innerHTML = p.pcno
			rows[1].innerHTML = p.pno
			rows[2].innerHTML = p.pname
			getstock();
		}
	})
} )

/*1. 페이지 열리면 모든 카테고리 select 넣어주기 */
getcategory()
function getcategory(){
	$.ajax({
		url : "/jspweb/admin/pcategory" , 
		type : 'get',
		success : function( re ){
			let json = JSON.parse( re )
			// 배열객체.forEach( 반복변수명[아무거나] , 인덱스 , 배열객체명 => { 실행코드 } )
			let html = ''
			json.forEach( c => {
				html += `<option value=${c.pcno}> ${c.pcname}</option>`
			})
			cselect.innerHTML = html
		}			
	})
}
/*2. 선택된 카테고리별 제품리스트를 select 넣어주기(모든 제품) */
function getproduct( pcno ){
	$.ajax({
		url : "/jspweb/admin/regist" , 
		data : {"type" : 1 , "option" : "all"},
		type : 'get',
		success : function( re ){
			productlist = JSON.parse( re )
			
			let html = '';
			
			productlist.forEach( p => {
				if(p.pcno == pcno){
					html += `<option value=${p.pno}> ${p.pname}</option>`
				}
			})
			pselect.innerHTML = html
		}
	})
}

 function setstock(){
	alert('버튼')
	//1.등록할 재고 데이터[객체] 구상 vs form[첨붚일있을때]
	let info = {
		psize : document.querySelector('.psize').value,
		pcolor : document.querySelector('.pcolor').value,
		pstock : document.querySelector('.pstock').value,
		pno : rows[1].innerHTML,
	}
	console.log(info)
	$.ajax({
		url : "/jspweb/admin/stock",
		type : "POST",
		data : info,
		success : re => {
			console.log(re)
			if(re == 'true'){
				alert('재고등록 성공')
				getstock();
			}else{alert('재고등록 실패')}
		}
	})
}

 //4. 제품별 재고 출력
 getstock()
 function getstock(){
	$.ajax({
		url : "/jspweb/admin/stock",
		type : "GET",
		data : {"pno" : rows[1].innerHTML},
		success : re => {
			let json = JSON.parse(re)
			console.log(json)
			let html = '<tr> <th>사이즈</th> <th>색상</th> <th>재고</th> <th> 비고 </th> </tr>';
			json.forEach(s => {
				html += '<tr>'+
						 `<td>${s.psize} </td>`+
						 `<td>${s.pcolor} </td>`+
						 `<td>${s.pstock} </td>`+
						 `<td> - </td>`+
						 `<tr>`;
			})
			document.querySelector('.stocktable').innerHTML = html
		}
	})
}