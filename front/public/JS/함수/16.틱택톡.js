/**


*/
//삼목만들기

let 게임상황 = [] //현재 알을 둔 상황 저장배열

//게임판 버튼 만드는 함수
 function 게임판그리기(){
	게임상황 = [null,null,null,null,null,null,null,null,null]//안에 있다없다 표시
	let 게임판=''//빈변수 선언
	for( let i = 0 ; 1<9 ; i++ ){//1부터 9까지 1씩 증가
		게임판 += `<button id=${i} onclick="버튼선택(${i})">${i}</button>`
		if( i % 3 == 2 ){ 게임판 +=`<br>` }
	}
	document.getElementById('gameboard').innerHTML = 게임판
}

function 버튼선택( i ){
	document.getElementById( i ).innerHTML ='O'
	게임상황[i] = 'O'
	if(중복검사(i)){ return }//알이 잇으면 함수 종료
 	{document.getElementById( rand ).innerHTML = 'X' 
}	
}


function 중복검사( val ){
	if(게임상황[ i ] != null){//배열은 모두 null로 초기화 = O,X가 존재 !<-아니다라는 뜻
		return true //알이잇다
	}else{
		return false //알이 없다
	}
}












