/**
 * 매개변수 한수전달 가능
 	함수도 가능
 	
 	함수호출(변수 배열 함수 function(){})모두 가능-> 자료형이면 다 됨
 	
 	
 */
 //1.
 function callTheeTimes( callback ){
	for( let i = 0 ; i<3 ; i++ ){
		callback(i)
	}
}

function print( i ){
	console.log(`${i}번째 함수 호출`)
}
//인수에 함수를 정의 후 사용
callTheeTimes(print)

//2.익명 콜백함수[222p]
 function callTheeTimes2( callback ){
	for( let i = 0 ; i<3 ; i++ ){
		callback(i)
	}
}

//콜백함수 :익명함수 인수안에서 정의함
//정의되지 않은채로 인수안에서 바로 입력
callTheeTimes2(function(i){console.log(`${i}번째 함수 호출`)})

//3.[223p]
let numbsers = [ 273 , 52 , 103 , 32 , 57 ]

numbsers.forEach( function(value , index , array ){
	console.log( `${index}번째 요소 : ${value}`)
})

function for_print(numbers){
	for( let i = 0 ; i<numbers.length ; i++){
		console.log (`${i}번쨰 요소 ${numbers[i]}`)
	}
}
for_print ( numbsers )

//4.배열의 map함수[223p]
numbsers.map( function(value , index , array){
	return value * value
})
console.log('map 실행 결과 : ' + numbsers )
numbsers.forEach(console.log)

//224p배열의 filter()
const evenNumbers = numbsers.filter(function(value){
	return value % 2 == 0//짝수공식
})
console.log('원래 배열 : ' + numbsers)
console.log('짝수 배열 : ' + evenNumbers)

