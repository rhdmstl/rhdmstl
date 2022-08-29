/*
	1. 9개 버튼 생성 [ 게임판 변수에 모든 버튼를 저장한다. ]
		1. 3개마다 줄바꿈처리  2 5 8 일때 
	2. 버튼 클릭하면 모양 변경 
		1. 선택한 버튼의 모양 변경 [ O ]
		2. [컴퓨터]난수 발생 모양 변경 [ X ]
	3. 근접한 버튼의 모양이 3개 모두 동일하면 승리  
*/

let 게임상황 = [] //현재 알을 둔 상황 저장배열
let 승리 ='' //이긴알을 저장하는 함수

//1.게임판 버튼 만드는 함수
function 게임판그리기(){
	승리 = ''
	게임상황 = [null,null,null,null,null,null,null,null,null]
	let 게임판 = ''
	
	for( let i = 0 ; i <9 ; i++){
		게임판 += `<button id=${i} onclick="버튼선택(${i})">${i}</button>`
		if( i % 3 == 2){게임판 += `<br>`}
	}
	document.getElementById('gameboard').innerHTML = 게임판
}

//2.버튼 눌렀을떄 이벤트 함수
 function 버튼선택(i){
	if(중복검사(i)){
		alert('안내)이미 둔 자리입니다')
		return
	}
	document.getElementById(i).innerHTML = 'O'
	게임상황[i] = 'O'
	
	if(게임결과( )){
		alert('게임종료 승리 : ' +승리)
		return
	}
	//난수발생
	while(true){
		let rand = Math.floor(Math.random()*9)
		if(!중복검사(rand)){
			document.getElementById(rand).innerHTML = 'X'
			게임상황[rand] = 'X'
			break
		}
	}
	if(게임결과( )){
		alert('게임종료 승리 : ' + 승리)
		return
	}
}

 //3.현재 위치에 알이 있는지 검사 함수[중복검사]
 function 중복검사(i){
	if(게임상황[i] != null){
		return true //알이 있다
	}else{
		return false //알이 없다 null이면
	}
}

//4.현재 상황에 겜임결과 판단하는 함수
 function 게임결과(){
	for(let i = 0 ; i<=2 ; i+=3){
		//i는 0부터 6까지 3씩 증가반복[3회 : 0 3 6]
		if(게임상황[i] != null && 게임상황[i] == 게임상황[i+1] == 게임상황[i+2]){
			//i가 0일때 0==1 ==2 i가 3일때 3==4==5 i가 6일때 6==7==8
			승리 = 게임상황[i]
			return true
		}
	}
}
