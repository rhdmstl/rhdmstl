/**
 * 
 		* 학생점수 프로그램
 			1.학생객체 선언
 			2.HTML에서 입력받은 데이터를 js에 저장
 				-함수등록 함수 사용
 				-document.getElementById('id명').value;
 			3.여러개의 객체저장 -> 배열
 			4.HTML 초기화
 
 
 */
 let studentlist = [ ]
 학생출력()
 
 function 점수등록(){
	 const student = {
	name : document.getElementById('name').value,
	kor	 : Number(document.getElementById('kor').value),
	eng	 : Number(document.getElementById('eng').value),
	mat	 : Number(document.getElementById('mat').value)
}
 	if(이름중복체크(student.name)){
		return
}
 	studentlist.push( student )
 	
 	alert('학생점수 등록이 완료되었습니다')
 	console.log(studentlist)
 	
 	document.getElementById('name').value = ''
	document.getElementById('kor').value = ''
	document.getElementById('eng').value = ''
	document.getElementById('mat').value = ''
	
	학생출력()
}

function 이름중복체크(name){
	for( let i = 0 ; i<studentlist.length ; i++ ){
		if( studentlist[i].name === name ){
			alert('이미 존재하는 학생명입니다')
			return true //배열 내 동일한 이름이 있다
		}
	}
	return false //배열 내 동일한 이름이 없다
}

function 학생출력(){
	let html = '<tr>' + 
					'<th>등수</th>'+
					'<th>학생명</th>'+
					'<th>국어</th>'+
					'<th>영어</th>'+
					'<th>수학</th>'+
					'<th>총점</th>'+
					'<th>평균</th>'+
					'<th>비고</th>'
				'</tr>'
				
	//**배열내 데이터를 하나씩 꺼내기 -> 객체정보 ->html화 */
	for( let i = 0 ; i<studentlist.length ; i++){
		let sum = studentlist[i].kor + studentlist[i].eng + studentlist[i].mat
		let avg = sum / 3
		html += '<tr>' + 
					'<th>등수</th>'+
					'<th>'+studentlist[i].name+'</th>'+
					'<th>'+studentlist[i].kor+'</th>'+
					'<th>'+studentlist[i].eng+'</th>'+
					'<th>'+studentlist[i].mat+'</th>'+
					'<th>'+sum+'</th>'+
					'<th>'+avg+'</th>'+
					'<th><button>"학생삭제('+i+')"</button></th>'
				'</tr>'
	}
	document.getElementById('listtable').innerHTML = html
}
function 학생삭제( i ){ //학생삭제하는 함수 [매개변수 : 삭제할 식별번호 ]
	alert(studentlist[i].name+'의 점수를 삭제합니다')
	studentlist.splice( i , 1 )
	학생출력()
}
