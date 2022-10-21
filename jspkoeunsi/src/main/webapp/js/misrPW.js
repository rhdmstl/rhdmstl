/**
 * 
 */
 alert('비번찾기입니다')
 function finepw(){
	
	let mid = document.querySelector('#mid').value
	let mphone = document.querySelector('#mphone').value
	let findPW = document.querySelector('#findPW')
	
	$.ajax({
		url : "/jspkoeunsi/misrPW",
		data : {"mid" : mid , "mphone" : mphone},
		success : function(re){
			console.log(re)
			if(re !== ''){
				alert('임시비번 입니다'+re)
				findPW.innerHTML = '회원 비밀번호' + re
			}else{
				alert('없는 회원입니다')
				findPW.innerHTML = '없는 회원입니다'
			}
		}
	})
}