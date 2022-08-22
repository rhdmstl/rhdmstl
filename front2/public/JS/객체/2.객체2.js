/**
 * 
 */
 const pet = {
	name	: '구름' ,
	eat		: function(food){
		alert(this.name + '은/는' + food + '을/를 먹습니다')
	}
}

//객체 내 메소드 호출
pet.eat('고기')

//250 속성추가
//1객체 만들기
const student = { } //비어잇는 객체
//2기존에 없는 키 접근
student.이름 = '고은시'
student.취미 = '악기'
student.장래희망 = '개발자'
//3객체확인
console.log(student)

//250 속성삭제
//1 객체내 속성제거
delete student.장래희망
//2객체 확인
console.log(student)

//251
const pet2 = {
	name	: '구름' ,
	eat(food){
		alert(this.name + '은/는' + food + '을/를 먹습니다')
	}
}
pet2.eat('밥')

//254
const 객체 = {
	name	: '혼자공부하는 파이썬'
	price	: 18000,
	publisher	: '한빛미디어'
}





















