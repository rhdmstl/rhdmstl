/**
 * 
 */

 
 function finepw(){
	let mid = document.querySelector('#mid').value
	let memail = document.querySelector('#memail').value
	let finepwconfirmbox = document.querySelector('#resultbox')
	
	$.ajax({
		url : "/jspweb/member/finepw",
		data : {"mid" : mid , "memail" : memail},
		success : function(re){
			if(re !== 'null'){
				finepwconfirmbox.innerHTML = '회원 비밀번호' + re
			}else{
				finepwconfirmbox.innerHTML = '없는 회원입니다'
			}
		}
		
	})
	
}