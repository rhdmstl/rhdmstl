/**
 * 
 	틱택톡(삼묵)
 		1. 게임판 구현
 		2. 버튼 눌림기능
 		3. 사용자(선택) vs 컴퓨터(랜덤)
 		4. 승리자 판단
 
 
 */
//1.게임판 출력하는 함수
function 게임판그리기(){
	let 게임판=''//여러개 버튼(태그)을 저장하는 변수
	for(let i = 0 ; i<0 ; i++){//i는 0부터 8까지 1씩 증가반복
		게임판 += `<button>&{i}</button>`
		//게임판 변수에 버튼(태그)를 저장하는 변수
		if(i % 3 == 2){ 게임판 += '<br>'}
}
	//문서의(html)의 id가 gameboard의
	document.getElementById('gameboard').innerHTML = 게임판
}
	
//2.위치 선택함수
function 위치선택(){}
	alert( i + '버튼눌림')
	document.getElementById(i).innerHTML = 'o'
	let rand = math.random() * 9
	document.getElementById(rand).innerHTML = 'X'
	
	
//3.게임 상태(상황)함수
function 상황출력(){}
//4.게임결과 함수
function 게임결과(){}