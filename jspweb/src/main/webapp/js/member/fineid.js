/**
 * 
 */

 function fineid(){
	//해당 아이디의 인풋의 값과 div 호출
	let mname = document.querySelector('#mname').value
	let memail = document.querySelector('#memail').value
	let fineidconfirmbox = document.querySelector('#fineidconfirmbox')
	
	$.ajax({
		//통신 확인부터 하기
		url : "/jspweb/member/fineid",		//통신경로
		data : {"mname" : mname , "memail" : memail},		//보낼데이터
		success : function(re){
			if(re !== 'null'){
				fineidconfirmbox.innerHTML = '회원아이디 : ' + re
			}else{
				fineidconfirmbox.innerHTML = '동일한 회원 아이디가 없습니다'
			}
		}
	})
}
 /*비번 찾기------------------------------------------------------ */

 function finepw(){
	let mid = document.querySelector('#mid').value
	let memail = document.querySelector('#memail').value
	let resultbox = document.querySelector('#resultbox')
	
	$.ajax({
		
		url : "/jspweb/member/finepw",
		data : {"mid" : mid , "memail" : memail},
		success : function(re){
			if(re === ''){
				resultbox.innerHTML = '동일한 회원 정보가 없습니다'
			}else{
				resultbox.innerHTML = '임시비밀번호' + re
			}
		}
	})
}