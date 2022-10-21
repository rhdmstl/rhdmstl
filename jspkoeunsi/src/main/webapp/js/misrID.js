/**
 * 
 */
 alert('아이디찾기')
 
 function IDfind(){
	console.log('되니?')
	let mname = document.querySelector('#mname').value
	let mphone = document.querySelector('#mphone').value
	let findID = document.querySelector('#findID')
	console.log('되니?2')
	$.ajax({
		url : "/jspkoeunsi/misrID",
		data : {"mname" : mname , "mphone" : mphone},
		success : function(re){
			console.log(re)
			if(re !== 'null'){
				findID.innerHTML = '회원아이디 : '+re
			}else{
				findID.innerHTML = '동일한 정보가 없습니다'
			}
		}
	})
}
 alert('비번찾기')
 function finepw(){
	console.log('비번찾기')
	let mid = document.querySelector('#mid').value
	let mphone = document.querySelector('#mphone').value
	let finepwconfirmbox = document.querySelector('#findPW')
	console.log('되니')
	$.ajax({
		url : "/jspweb/member/finepw",
		data : {"mid" : mid , "mphone" : mphone},
		success : function(re){
			console.log(re)
			if(re !== 'null'){
				finepwconfirmbox.innerHTML = '회원 비밀번호' + re
			}else{
				finepwconfirmbox.innerHTML = '없는 회원입니다'
			}
		}
	})
}