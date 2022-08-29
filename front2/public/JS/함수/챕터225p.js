/**
 * 
 */       
 
 //226p화살표 함수
 	//funtion , return 생략
 	//(인수)=> 결과
 let numbers = [ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ]
 	//메소드 체이닝 결과연결 사용하지않을때
 numbers.filter((value) => value%2 == 0)
 
 let array1 = numbers.filter((value) => value % 2 ==0)
 let array2 = numbers.filter((value) => value * value)
 array
 	/*
 	.map((value) => value*value)
 	.forEach((value) => console.log(value))
 	*/
 	
 	//화살표함수 아닐때
 numbers.filter(function(value){
	return value % 2 == 0 
}).map(function(value){
		return value * value
	}).forEach(function(value){
		console.log(value)
	})

	