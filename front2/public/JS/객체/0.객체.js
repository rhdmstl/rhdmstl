/**
 * 
 */
 
 //p246
 //객체생성
 const product = { 
	제품명 : '7D  건조 망고' , 
	유형 : '당절임' , 
	성분 : '망고 , 설탕 , 메아중아황산나트륨 , 치자황색소',
	원산지 : '필리핀'
}


//2.객체확인
console.log( '객체 호출 : ' + product ) 
console.log( '객체 내 속성 호출 : ' + product['제품명'] ) 
console.log( '객체 내 속성 호출 : ' + product['유형'] ) 
console.log( '객체 내 속성 호출 : ' + product.성분 ) 

//248p
const object = {
	number : 273 ,
	string : '구름' ,
	boolean : 'true' ,
	array : [52,273,103,32] ,
	method : function() {}
}

//2.객체 내 속성과 메소드=함수 호출
console.log('객체내 메소드 호출' + object.method())