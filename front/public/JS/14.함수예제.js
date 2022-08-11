//p.203 윤년인지 확인하는 수
function isLeapYear( year ){
	return(year%4==0)&&(year%100!=0)||(year%400==0)
}
console.log( `2020년은 윤년일까? === ${isLeapYear(2020)}` )



function 윤년버튼함수(){
	//윤년버튼함수 라는 함수명으로 매개변수가 없는 함수
	alert('버튼이 눌렸다')
	let 연도 = Number(prompt('연도를 입력 :'))
	
	let 결과 = isLeapYear(연도)
	console.log('입력한 '+연도+'는 윤년일까?'+결과)
}

document.getElementById('resultbox').innerHTML = '결과:'+결과