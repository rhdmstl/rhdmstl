/**
 * 
 */
 alert('로그인')
 
  function login(){
	let mid = document.querySelector('#mid').value
	let mpw = document.querySelector('#mpw').value
	let loginbox = document.querySelector('#loginbox')
	
	console.log('되니')
	$.ajax({
		url : "/jspkoeunsi/misrLogin",
		data : {"mid" : mid , "mpw" :mpw},
		success : function(re){
			console.log('되니22')
			console.log(re)
			if(re === '1'){
				alert('성공')
				location.href = "/jspkoeunsi/header.jsp";
			}else if(re === '2'){
				alert('비밀번호가 다릅니다')
				loginbox.innerHTML = "비밀번호가 다릅니다";
			}else if(re === '0'){
				alert('존재하지않는 아이디입니다')
				loginbox.innerHTML = "존재하지않는 아이디입니다";
			}
		}
	})
}