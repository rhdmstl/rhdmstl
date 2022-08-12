/**
 * 
 */alert('실행')
 
 //p204
 function sumAll( a,b){
	let output = 0
	for(let i = a ; i<=b ; i++){
		output += i
	}
	return output
}
console.log(`1부터 100까지의 합 : ${sumAll(1 , 100 )}`)
console.log(`1부터 500까지의 합 : ${sumAll(1 , 500 )}`)

//계산하기 버튼눌림 함수
function 계산버튼함수(){
	alert('버튼눌림성공')
	let snumber = document.activeElementId('sinput').value
	let enumber = document.activeElementId('einput').value
	let result = sumAll( snumber , enumber )
	document.activeElementId('resultbox')
}
alert('snum')