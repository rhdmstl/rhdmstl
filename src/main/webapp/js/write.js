function ttwrite(){
	alert('전송')
	let ttitle = document.querySelector('.ttitle').value
	let tcontent = document.querySelector('.tcontent').value
	let twriter = document.querySelector('.twriter').value
	let tpw = document.querySelector('.tpw').value
	$.ajax({
		url : "/jsptest/write",
		data : {"ttitle" : ttitle , "tcontent" : tcontent , "twriter" : twriter , "tpw" : tpw},
		success : function(re){
				if(re === '1'){
					location.href = location.href
					alert('등록완료')
				}	
				else{
					alert('등록실패')
				}
		}
	})
}