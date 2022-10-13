/**
 * 
 */
 function bwrite(){
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
	})
}
/*
	let 객체 = {속성명 : 데이터 ...}
 */