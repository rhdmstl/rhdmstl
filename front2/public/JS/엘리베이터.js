/*
엘리베이터 버튼 생성 
버튼 클릭시 실행
버튼클릭시
현재 엘리베이터 층수와 내가있는 층 난수발생
[엘리베이터가 있는 위치 저장할곳][내가 있는층 엘리베이터 위치 저장할곳]
엘리베이터가 내가 있는 층보다 높을시 한층씩 하강됨을 테이블에 표시
엘리베이터가 내가 있는 층보다 낮을시 한층씩 상승됨을 테이블에 표시
조건 일치시 결과창에 엘리베이터가 도착했습니다 표시
html연결
-------------------------------------------------
엘리베이터 10층 
내가있는층 1층 
if와for 사용하여 상승 하강 반복문 돌리기 
-------------------------------------------------
*/
//let E_numbers =[]//엘리베이터 층수를 저장할 배열 
//let M_number =[]//내가 있는층수를 저장할 배열 
//up버튼을 누를때마다 
// Math.floor((Math.random()*20+1))

/*
const rand1 = 10//엘베층
const rand2 = 1//내가있는층*/

//난수저장
/* 버튼을 눌렀을때 함수실행 */




let E1 = Math.floor((Math.random() * 10))//엘베층
let M2 = Math.floor((Math.random() * 10))//내가있는층


document.getElementById('view_floor').innerHTML = E1
document.getElementById('call_floor').innerHTML = M2



if (E1 == M2) {
	alert('같은 층입니다')
}else if(M2>E1){
	alert('상승합니다')
}else{alert('하강합니다.')}

function call1() {//function 시작
	setInterval(() => {//인터벌 시작
		if (E1 > M2) {//if 시작
			E1 -=1
				document.getElementById('view_floor').innerHTML = E1
			if (E1 == M2) {alert('엘리베이터가 도착했습니다.')
				clearTimeout(() => {
					alert('엘리베이터가 도착했습니다.')
				}, 1 * 1000)
			}
		}//if 끝
	}//인터벌 끝
	,1*1000)
}//function 끝

function call2() {//function 시작
	setInterval(() => {//인터벌 시작
		if (E1 < M2) {//if 시작
			E1 +=1
				document.getElementById('view_floor').innerHTML = E1
			if (E1 == M2) {alert('엘리베이터가 도착했습니다.')
				clearTimeout(() => {
					alert('엘리베이터가 도착했습니다.')
				}, 1 * 1000)
			}
		}//if 끝
	}//인터벌 끝
	,1*1000)
}//function 끝


/* 테이블에 호출해야함 */

/*let E_number = []
if (rand1 != rand2) {//if1 시작
	if (rand1 > rand2) {//2if 시작
		for (let i = 1; i >= rand1; i++) {
			alert('엘리베이터가 도착했습니다')
		} for (let j = rand1; j >= rand2; j--) {
			alert('엘리베이터가 도착했습니다.')
		}//for끝
	}//for2끝
document.getElementById('view_floor').innerHTML = E_number
}//if1 끝  */