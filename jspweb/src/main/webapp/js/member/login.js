/**
 * 
 */
 
 function login(){
	 let mid = document.querySelector('#mid').value
	 let mpassword = document.querySelector('#mpassword').value
	 let loginconfirmbox = document.querySelector('#loginconfirmbox')
	 
	 
	 //jquery 라이브러리 포함
	 //ajax
	 //$.ajax({속성명 = 값 , ...})
	 	//url : "서블릿 url", -쉼표필수
		//success : function(매개변수){}
	 $.ajax({
		url : "/jspweb/member/login", //서블렛
		data : {"mid" : mid , "mpassword" : mpassword},
		success : function(re){
			alert(re)
			if( re === '1'){
				alert("성공")
				location.href ="/jspweb/index.jsp";
			}else if(re ==='2'){
				alert("패스워드가 다릅니다")
				loginconfirmbox.innerHTML = "회원정보가 다릅니다";
			}else if(re === '3'){
				alert("관리자에게 문의하세요")
				loginconfirmbox.innerHTML = "회원정보가 다릅니다";
			}else if(re === '0'){
				alert("없는 아이디입니다")
				loginconfirmbox.innerHTML = "회원정보가 다릅니다";
			}
		}
	});
 }