

let 게임상황 = [] //현재 알을 둔 상황을 저장 배열
let 승리 = '' // 이긴 알의 변수

function 게임판그리기(){
	승리 = ''
	게임상황=[null,null,null,null,null,null,null,null,null] //배열에 9개 넣음
	let 게임판 =''
	for ( let i = 0 ; i < 9 ; i++){
		게임판 += `<button id=${i} onclick=위치선택(${i})>${i}</button>`
		if(i % 3 == 2){게임판 += '<br>' }
		
	}
	document.getElementById('gameboard').innerHTML = 게임판
}



 function 위치선택(i){
	if(중복검사(i)){
		alert('안내)이미 둔 자리입니다.')
		return
	}
	
	document.getElementById(i).innerHTML = 'O'
	게임상황[i] = 'O'
	
	if(게임결과()){
		alert('게임종료 승리 : ' + 승리)
		return
	 }
	
	while(true){
	let rand = Math.floor(Math.random()*9)
	if (!중복검사(rand)){
	document.getElementById(rand).innerHTML = 'X'
	게임상황[rand]= 'X'
	break
		}
	} 
	
}

 function 중복검사( i ){
	if(게임상황[i] != null){
		return true        //알이 있다
	}else{
		return false         //알이 없다.
	}	
}


//게임결과함수 가로 세로 대각선 무승부
 function 게임결과(){ // 가로 012 345 678
	for(let i = 0 ; i<=6 ; i+=3){
		if(게임상황[i] !=null && 게임상황[i]== 게임상황[i+1] && 게임상황[i+1] == 게임상황[i+2]){
			승리 = 게임상황[i] //승리변수에 i번째 알 저장
			return true // 가로로 승리
		}
	}
	for(let i = 0 ; i<=2 ; i++){ //세로 036 147 258
		if(게임상황[i] !=null && 게임상황[i]== 게임상황[i+3] && 게임상황[i+3] == 게임상황[i+6]){
			승리 = 게임상황[i]
			return true
		}
	}	
	for(let i = 0 ; i<=2 ; i++){ //대각선 048 246
		if(게임상황[i] !=null && 게임상황[i]== 게임상황[i+4] && 게임상황[i+4] == 게임상황[i+8]
		   ||게임상황[i] !=null && 게임상황[i]== 게임상황[i+2] && 게임상황[i+2] == 게임상황[i+4]){
			승리 = 게임상황[i]
			return true
		}
	}	
	
	
}
 
 
 
 
 
 
 
 