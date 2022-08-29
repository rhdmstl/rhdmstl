/**
 * 
 */
 
 const a = [ ]//배열선언
 console.log( a )
 a.sample( a.sample ) //속성추가
 
 
 //함수도 객체이다
 function b(){ }
 b.sample = 10
 console.log( b.sample )
 
 //기본자료형
 const c = 273
 c.sample = 10
 console.log( c.sample )
 
 //기본자료형
 const d = '안녕하세요'
 c.sample = 10
 console.log( d.sample )
 
 //277
 //수학함수 :Math객체
 const num = Math.random()
 
 console.log('0-1 사이의 랜덤한 숫자 : ' + num)
 console.log('0-10 사이의 랜덤한 숫자 : ' + num*10)
 console.log('0-50 사이의 랜덤한 숫자 : ' + num*50)
 console.log('-5 ~ 5 사이의 랜덤한 숫자 : ' + num*10 -5)
 console.log('-25 ~ 25 사이의 랜덤한 숫자 : ' + num*50 -25)