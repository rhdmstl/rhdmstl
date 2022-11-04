/**
 * 
 */
 alert('회원가입을 해주세요')
 
 let col = document.querySelectorAll('.col')
 /*이름 *---------------------------------------*/
 function mevent1(){
	let mname = document.querySelector("#mname").value
	let mnamej = /^[a-zA-Z가-힣]{2,20}$/
	if(mnamej.test(mname)){col[0].innerHTML = '성공'}
	else{col[0].innerHTML = '이름을 확인해주세요'}
 }
 /*아이디 *---------------------------------------*/
 function mevent2(){
	let mid = document.querySelector("#mid").value  //아이디를 입력할때마다 이벤트발생[keyup]
	let midj = /^[a-z0-9]{5,20}$/					//입력받은 아이디 호출
	alert('dd')
	if(midj.test(mid)){								//정규표현식 작성
		$.ajax({									//정규표현식 검사
			url : "/jspkoeunsi/misrIDcheck",				//아이디 중복체크[비동기식 ajax]
			data : { "mid" : mid},	
			success : function( re ){
				alert(re)
				if(re === 'true'){col[1].innerHTML = '사용중인 아이디입니다'}
				else{col[1].innerHTML = '성공'}
			}
		})
	}else{col[1].innerHTML = '소문자/숫자 조합 5~20글자'}
}
/*비밀번호 *---------------------------------------*/
 function mevent3(){
	let mpw = document.querySelector("#mpw").value //비밀번호 아이디 호출
	let mpwj = /^[a-zA-Z0-9]{8,20}$/	
	if(mpwj.test(mpw)){col[2].innerHTML = '성공'; }
	else{col[2].innerHTML = '소문자/숫자 조합 5~20글자'}
}
/*전화번호 *---------------------------------------*/
 function mevent4(){
	let mphone = document.querySelector("#mphone").value
	let mphonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/
	if(mphonej.test(mphone)){col[3].innerHTML = '성공';}
	else{col[3].innerHTML = '전화번호 형식을 확인해주세요'}
}
/*전송버튼 눌렀을때 *---------------------------------------*/
 function formsubmit(){
	// 1.아이디 ~ 주소 모두 유효성검사 검토 
	for( let i = 0 ; i <= 3 ; i++ ){	//  col3[0] : 아이디  , col3[1] : 비밀번호  ~~~    col3[5] : 주소
		if( col[i].innerHTML !== '성공' ){ alert('입력이 안된 정보가 있습니다.'); return false; }
	}
	// 2.이용약관 체크박스 검토  [ // tag객체명.checked    : 체크가 되어있으면 true 아니면 false ]
	if( document.querySelector('#confirm1').checked == false ){ alert('이용약관에 동의해주세요'); 		return false; }
	if( document.querySelector('#confirm2').checked == false ){ alert('개인정보 수집 동의해주세요'); 	return false; }
	
	document.querySelector('.signupform').submit();	// 해당 form 전송 // 폼객체.submit()
	// document.querySelector('.signupform') : signupform 이라는 class 를 가지고 있는 tag 호출
}