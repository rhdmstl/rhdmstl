/**
 * 
 */
/*회원정보호출----------------------------- */
 getmember();
 function getmember(){
	 $.ajax({
		url:"/jspweb/member/info",
		success : function(result){
		alert(result)
		let member = JSON.parse( result )
			document.querySelector("#mno").value = member.mno
			document.querySelector("#mid").value = member.mid
			document.querySelector("#mname").value = member.mname
			document.querySelector("#mphone").value = member.mphone
			document.querySelector("#memail").value = member.memail
			//document.querySelector("#maddress").value = member.maddress
			document.querySelector("#mdate").value = member.mdate
			document.querySelector("#mpoint").value = member.mpoint
			getmemberlist();
		}
	})
}

/* ---------------- 모든 회원 호출 -------------- */
function getmemberlist(){
	$.ajax({
		url : "/jspweb/member/infolist",
		success : function( result ){
			let memberlist = JSON.parse( result )
			let table = document.querySelector("#memberlisttable")
			let tag = '<tr>'+
					'<td>회원번호</td>'+
					'<td>아이디</td>'+
					'<td>이름</td>'+
					'<td>연락처</td>'+
					'<td>이메일</td>'+
					'<td>주소</td>'+
					'<td>날짜</td>'+
					'<td>포인트</td>'+
				'</tr>';
			for(let i = 0 ; i < memberlist.length ; i++){
				let m = memberlist[i]
				//4.해당 인덱스의 값 가져오기
				tag += '<tr>'+
		             '<td> ' +m.mno + '</td>'+
		             '<td> ' +m.mid + ' </td>'+
		             '<td> ' +m.mname + ' </td>'+
		             '<td>' +m.mphone + ' </td>'+
		             '<td> ' +m.memail + ' </td>'+
		             '<td> ' +m.maddress + '</td>'+
		             '<td>' +m.mdate + ' </td>'+
		             '<td>' +m.mpoint + ' </td>'+
		          '</tr>';
			}
			//6.
			table.innerHTML = tag
		}
	})
}
/* ---------------- 회원 탈퇴-------------- */
function viewdelete(){
	//1.tag가져오기
	let deleteboox = document.querySelector("#deleteboox")
	//2.tag에 넣을 html구성하기
	let tag = 
			'<span>| 정말 탈퇴하십니까? |</span>'+
			'<input type="password" id="mpassword">'+
			'<button onclick="mdelete()">확인</button>';
	//3.tag에 html넣기
	deleteboox.innerHTML = tag
}

function mdelete(){
	//1.tag 입력된 비밀번호 가져온다
	let mpassword = document.querySelector('#mpassword').value
	//2.ajax를 이용한 회원탈퇴 처리
	$.ajax({
		url : "/jspweb/member/delete",
		data : {"mpassword" : mpassword},
		success : function(result){
		alert(result)
		if(result === 'true'){
			alert('탈퇴 성공')
			location.href = '/jspweb/member/logout.jsp'
			}
			else{
				alert('동일하지않은 비밀번호 입니다')
			}
		}
	})
}

 let buttons = document.querySelectorAll('button')  // 현재 페이지의 모든 버튼 호출

 function updateaction(){
	let mname  = document.querySelector('#mname')
	if( buttons[1].innerHTML === '확인' ){
		$.ajax({
			url : "http://localhost:8080/jspweb/member/update" ,
			data : { "mname" : mname.value } , 
			success : function( re ){ 
				if( re === 'true'){
					alert('수정성공')
				}else{
					alert('수정실패')
				}
			}
		})
		buttons[1].innerHTML = '수정'
		mname.readOnly = true;	// 수정모드 설정 
		//location.href = 'url' ; // 페이지 이동
		location.reload() ; 	// 현재 페이지 새로고침
	}else{
		alert('수정후 확인 버튼 클릭시 수정이 완료됩니다.')
		mname.readOnly = false;	// 수정모드 제거 
		buttons[1].innerHTML = '확인'
	}
}
