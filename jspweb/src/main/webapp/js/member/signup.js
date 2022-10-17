/*
	정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어
		 /^ : 정규표현식 시작 
		 $/ : 정규표현식 끝
		 [a-z] : 소문자 패턴
		 [A-Z] : 대문자 패턴
		 [0-9] : 숫자 패턴
		 { 최소길이 , 최대길이  } : 문자열 길이 패턴 
		 
		 검사 : 정규표현식.test( 데이터 )  : 맞으면 true , false
		 
		 1. /^[a-z0-9]{5,20}$/  : 소문자/숫자 조합 5~20글자 패턴
		 2. 
*/

//0. 아이콘
let sicon = '<i class="fas fa-check-circle"></i>';
let bicon = '<i class="fas fa-ban"></i>';

//1.col3 div 모두 가져오기
 let col3 = document.querySelectorAll('.col3')
/*아이디 *---------------------------------------*/
 function mevent1(){
	let mid = document.querySelector("#mid").value  //아이디를 입력할때마다 이벤트발생[keyup]
	let midj = /^[a-z0-9]{5,20}$/					//입력받은 아이디 호출
	if(midj.test(mid)){								//정규표현식 작성
		$.ajax({									//정규표현식 검사
			url : "/jspweb/member/idcheck",				//아이디 중복체크[비동기식 ajax]
			data : { "mid" : mid},					
			success : function( re ){
				if(re === 'true'){col3[0].innerHTML = bicon+ '사용중인 아이디입니다'}
				else{col3[0].innerHTML = sicon}
			}
		})
	}else{col3[0].innerHTML = '소문자/숫자 조합 5~20글자'}
}
/*비밀번호 *---------------------------------------*/
 function mevent2(){
	let mpw = document.querySelector("#mpw").value //비밀번호 아이디 호출
	let mpwj = /^[a-zA-Z0-9]{8,20}$/	
	if(mpwj.test(mpw)){col3[1].innerHTML = sicon; mevent3()}
	else{col3[1].innerHTML = bicon+'소문자/숫자 조합 5~20글자'}
}
/*비밀번호 확인 *---------------------------------------*/
 function mevent3(){
	let mpw = document.querySelector("#mpw").value //비밀번호 아이디 호출
	let mpwconfirm = document.querySelector("#mpwconfirm").value
	let mpw2j = /^[a-zA-Z0-9]{8,20}$/
	if(!mpw2j.test(mpwconfirm)){col3[1].innerHTML = bicon+ '소문자/숫자 조합 5~20글자'}
	else if(mpwconfirm != mpw){col3[1].innerHTML = bicon+'비밀번호가 서로 다릅니다'}
	else{col3[1].innerHTML = sicon; mevent2();}
}
/*이름 *---------------------------------------*/
 function mevent4(){
	let mname = document.querySelector("#mname").value
	let mnamej = /^[a-zA-Z가-힣]{2,20}$/
	if(mnamej.test(mname)){col3[2].innerHTML = sicon;}
	else{col3[2].innerHTML = bicon+ '이름을 확인해주세요'}
}
/*전화번호 *---------------------------------------*/
 function mevent5(){
	let mphone = document.querySelector("#mphone").value
	let mphonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/
	if(mphonej.test(mphone)){col3[3].innerHTML = sicon;}
	else{col3[3].innerHTML = bicon+ '전화번호 형식을 확인해주세요'}
}
/*이메일 *---------------------------------------*/
 function mevent6(){
	let memail = document.querySelector("#memail").value
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	if(memailj.test(memail)){
		$.ajax({
			url : "/jspweb/member/emailcheck",
			data : { "memail" : memail } , 
			success : function(re){
				if(re === 'true'){col3[4].innerHTML = bicon+ '사용중인 이메일입니다'}
				else{col3[4].innerHTML = sicon;}
			}
		})
	}
	else{col3[4].innerHTML = bicon+ '이메일 형식을 확인해주세요'}
}
/*주소 *---------------------------------------*/
 let sample4_postcode  = document.querySelector("#sample4_postcode ")
 let sample4_roadAddress = document.querySelector("#sample4_roadAddress")
 let sample4_jibunAddress = document.querySelector("#sample4_jibunAddress")
 let sample4_detailAddress = document.querySelector("#sample4_detailAddress")
	
 function addresscheck(e){
	 console.log( e )
	let a = e.currentTarget.value;
	if(a.indexOf(',') !== -1){col3[5].innerHTML = bicon + '주소에 , 특수문자 포함 불가능'}
	else{col3[5].innerHTML = sicon;}
 }
	
	sample4_postcode.addEventListener('change',addresscheck) 
	//change된 객체의 정보를 addresscheck함수를 넣으면 이벤트 발생시킨 객체 정보를 전달함
	sample4_roadAddress.addEventListener('change',addresscheck)
	sample4_jibunAddress.addEventListener('change',addresscheck)
	sample4_detailAddress.addEventListener('change',addresscheck)
	
/*전송버튼 눌렀을때 *---------------------------------------*/
 function formsubmit(){
	// 1.아이디 ~ 주소 모두 유효성검사 검토 
	for( let i = 0 ; i <= 5 ; i++ ){	//  col3[0] : 아이디  , col3[1] : 비밀번호  ~~~    col3[5] : 주소
		if( col3[i].innerHTML !== sicon ){ alert('입력이 안된 정보가 있습니다.'); return false; }
	}
	// 2.이용약관 체크박스 검토  [ // tag객체명.checked    : 체크가 되어있으면 true 아니면 false ]
	if( document.querySelector('#confirm1').checked == false ){ alert('이용약관에 동의해주세요'); 		return false; }
	if( document.querySelector('#confirm2').checked == false ){ alert(' 개인정보 수집 동의해주세요'); 	return false; }
	
	document.querySelector('.signupform').submit();	// 해당 form 전송 // 폼객체.submit()
	// document.querySelector('.signupform') : signupform 이라는 class 를 가지고 있는 tag 호출
}
/**
 * 	카카오우편API
 */
 alert("js실행")
  function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
    