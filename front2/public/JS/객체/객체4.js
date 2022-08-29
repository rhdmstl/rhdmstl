/**
	객체지향 프로그래밍
	클래스[ 객체 설계도 ]	
	객체[Object]
	객체 멤버
		1. 변수[데이터1개] , 상수[데이터1개] , (Oject) = 배열[object] , 함수[function]
	예) 
		자동차 = 객체 			붕어빵 틀 = 설계도
			핸들 = 객체			붕어빵 = 객체 
			의자 = 객체
			엔진 = 객체
 */
 
 //291p
 //1.객체 선언
 /*  객체명 = {  
		속성1[ key : value ] , 
		속성2[ key : value] , 
		속성3[ key : arry[] ] ,
		메소드 : function(){}   } 
	*/
// 2. 객체내 속성/메소드 호출 [ . 연산자 ]
// 객체명.key
// 객체명.메소드( )		: 메소드 이기 때문에 매개변수[인수] () 필요
 const object = {
	name : '혼자공부하는 파이썬' ,
	price : 18000 ,
	publisher : '한빛미디어'
}

//2.속성확인하는 방법
if( object.name !== undefined ){//만약 객체 내 name속성이 있는지 확인
	console.log('name 속성이 있습니다')
}else{
	console.log('name 속성이 없습니다')
}
///////////////
if( object.author !== undefined ){
	console.log('author 속성이 있습니다')
}else{
	console.log('author 속성이 없습니다')
}

//293 삼항연산자 [조건 ; 참 ; 거짓]

object.name = object.name !== undefined ? object.name : '제목미정'
object.author = object.author !== undefined ? object.author : '저자미정'

console.log( object )
/*
//294
let array = [ 1 , 2 , 3 ]
let [ a , b ] = [ 1 , 2 ]//배열 다중할당
console.log( a )
console.log( b )
//
[a , b] = [b , a]
console.log(a)
console.log(b)
//
*/
let arrayA = [ 1,2,3,4,5]
const [ a,b,c ] = arrayA
console.log( a,b,c )

//295
const{ name,price } = object
	//object 객체 내 속성꺼내기
console.log( name )
console.log( price )

const{ n = name, p = price } = object
	//object 객체 내 속성꺼내기
console.log( name )
console.log( price )
////////////////////////////



