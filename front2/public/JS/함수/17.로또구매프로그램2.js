/**
 * 
 */
 
 //변수는 지역변수 특징 
 //변수 선언
 let select_numbers = [ ]//선택한 번호 리스트표시
 let lotto_numbers = [ ]//컴퓨터 난수
 //1.버튼 만들기함수
 function btn_print( ){
	let btnlist = ''
	for(let i = 1 ; i<=45 ; i++){
		btnlist += `<button id=${i} onclick=btn_click(${i})>${i}</button>`
		if(i % 5 == 0){ btnlist += '<br>'}
	}
	document.getElementById('btnbox').innerHTML = btnlist;
}

//2.버튼 눌렀을때 함수
function btn_click(i){
	let index = select_numbers.indexOf(i)
	if(index > -1){
		alert('이미 선택한 번호 입니다 [취소합니다]')
		select_numbers.splice(index , 1)
	}else{
		if(select_numbers.length == 6){
			alert('더이상 선택할수없습니다')
			return
		}
		select_numbers.push(i)//배열에 데이터 추가
	}
	document.getElementById('selectbox').innerHTML = select_numbers
}

//3.추첨번호 생성함수
function lotto_number(){
	if(select_numbers.length != 6){
		alert('6개를 모두 고른 후 추첨하세요')
		returns
	}
	while(true){//무한루프 [ 추첨번호가 6개 ]
		let rand = Math.floor((Math.random()*45)+1)
		let index = lotto_numbers.indexOf(rand)
		if( index >= 0){
			
		}else{
			if( lotto_numbers.length == 6 ){
				break
			}
			lotto_numbers.push(rand)
		}
	}
	document.getElementById('lottobox').innerHTML = lotto_numbers
	lotto_result()
}

//4.추첨번호 비교 결과함수
function lotto_result(){
	let count = 0 //배열 내 총 동일한 숫자의 개수
	let result_numbers = select_numbers.filter( (x)=> lotto_numbers.includes(x) )
	count = result_numbers.length
	let msg = '' //출력할 메세지 저장변수
	if(count == 0){ msg += '꽝' }
	else if( count == 1 ){ msg += '1개 맞았습니다' + result_numbers }
	else if( count == 2 ){ msg += '2개 맞았습니다[5등]' + result_numbers }
	else if( count == 3 ){ msg += '3개 맞았습니다[4등]' + result_numbers }
	else if( count == 4 ){ msg += '4개 맞았습니다[3등]' + result_numbers }
	else if( count == 5 ){ msg += '5개 맞았습니다[2등]' + result_numbers }
	else if( count == 6 ){ msg += '6개 맞았습니다[1등]' + result_numbers }
	document.getElementById('resultbox').innerHTML = msg
}

/*
	두 배열간 교집합[동일한 데이터] 개수 구하기 방법 
	1. 
	for( let i of select_numbers ){
		for( let j of lotto_numbers ){
			if( i == j) { 
				count++ 
			} 
		}
	} 
	
	2.
	for( let i of select_numbers ){
		if( lotto_numbers.indexOf( i ) != -1 ){ count++; }
	}
	
	3.
	let result_numbers = select_numbers.filter( (value) => lotto_numbers.includes(value) )
	count = result_numbers.length
*/