/**
 * 
 */
 /*썸머노트*/
  $(document).ready(function() {
  	$('#summernote').summernote({
		pliaceholder : '내용입력',
  		maxHeight : null,
  		minHeight : 300,
  		lang : 'ko-KR'
	});
});
 function bwrite(){
	
	//form버전
	let form = document.querySelector('form')
	console.log(form)
	
	//스크립트에서 지원해주는 기능
		//객체화된 form호출
	let formdata = new FormData(form)
	console.log(formdata)
	$.ajax({
		url : "/jspweb/board/write", //서블릿주고
		data : formdata,				//ajax 기본값으로 form전공 불가능
		//첨부파일 전송시 아래 코드로 전송불가 post만 가능
		contentType : false,
		processData : false,
		type : 'POST',
		success : function( re ){
			if(re === 'true'){ 
				alert('글등록');
				location.href="list.jsp"
			}
			else{alert('글등록 실패')}
		 }
	})
	/*
	console.log('dd')
	let inputs = document.querySelectorAll('input')
	let data = {
		btitle : inputs[1].value,
		bcontent : inputs[2].value
	}
	console.log(data)
	$.ajax({
		url : "/jspweb/board/write",
		data : data,
		success : function(re){
			if(re === 'true'){ 
				alert('글등록');
			}
			else{alert('글등록 실패')}
		}
	})*/
}
/*
	let 객체 = {속성명 : 데이터 ...}
 */