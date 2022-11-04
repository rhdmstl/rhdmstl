// 1. 로그인제 [ 로그인된 경우에만 실행 하겠다.[ 세션호출: jsp vs ajax ]  ]
let mid = document.querySelector('.mid').value

// 2. 웹소켓 선언 
let clientsocket = null; 

// 3. 접속 제어 
if( mid != 'null'){
	// 웹소켓에 서버소켓으로 연결[매핑]
	clientsocket 
	= new WebSocket('ws://localhost:8080/jspweb/chating/'+mid);
	// 아래에서 구현 메소드를 객체에 대입
	clientsocket.onopen = function(e){ onopen(e) }
	clientsocket.onclose = function(e){ onclose(e) }
	clientsocket.onmessage = function(e){ onmessage(e) }
	clientsocket.onerror = function(e){ onerror(e) }
}else{ alert('로그인하고 오세요~'); location.href='../member/login.jsp'; }

 function onopen(e){alert(e)} //시작
 function onclose(e){alert(e)}	//끝
 
 /////////////보내기
 function send(){ 
	let msg = { //전송할 데이터 객체
		type : "msg",	//일반메세지
		content : document.querySelector('.msgbox').value , //작성내용
		mid : mid , //보낸사람
		date : new Date().toLocaleTimeString(), //날짜
		img : '채팅프로필.jpg' //프로필
	}
	clientsocket.send( JSON.stringify(msg) )
	document.querySelector('.msgbox').value = ''
 }
 //이모티콘 전송
 function emosend(i){
	let msg = {
		type : "emo",	//이모티콘
		content : i ,	//이미지 번호
		mid : mid,		//보낸사람
		date : new Date().toLocaleTimeString(), //날짜
		img : '채팅프로필.jpg' //프로필
	}
	clientsocket.send( JSON.stringify(msg) )
}
 function enterkey(){ if(window.event.keyCode == 13){ send() } } //엔터키 적용

 function onmessage(e){ //////////////받기
	let msg = JSON.parse( e.data ) //전송받은 데이터 객체
	console.log(e.data)
/////////////////////////////////////// 1. 일반 메시지 전송 코드 /////////////////////////////////////////
	if(msg.type == "msg"){//전송타입 메세지
		if(msg.mid == mid){ //본인글이면
			let html = document.querySelector('.contentbox').innerHTML
			html += '<div class="secontesnt my-3">'+
						'<span class="date">'+msg.date+'</span> '+
						'<span class="content">'+msg.content+'</span>'+
					'</div>';
			document.querySelector('.contentbox').innerHTML = html
			
		}else{ //본인 글이 아니면
			let html = document.querySelector('.contentbox').innerHTML
			
			html +=  '<div class="row g-0 my-3">'+
						'<div class="col-sm-1 mx-2"> '+
							'<img width="100%;" class="rounded-circle" alt="" src="/jspweb/image/'+msg.img+'">'+
						'</div>'+
						'<div class="col-sm-9"> '+
							'<div class="recontent">'+
								'<div class="name">'+msg.mid+'</div>'+
									'<span class="content">'+msg.content+'</span>'+
									'<span class="date">'+msg.date+'</span>'+
							'</div>'+
						'</div>'+
					'</div>';
			document.querySelector('.contentbox').innerHTML = html
		}
		/////////////////////////////////////////////////////////
	}else if(msg.type == "emo"){ //이모티콘 전송코드
		if(msg.mid == mid){ //내가 보낸 이모티콘일때
/////////////////////////////////////// 2. 이모티콘 전송 코드 /////////////////////////////////////////
			let html = document.querySelector('.contentbox').innerHTML
			html += '<div class="secontesnt my-3">'+
					'<span class="date">'+msg.date+'</span> '+
					'<img src="/jspweb/image/imoji/emo'+msg.content+'.gif" width="90px">'+
				'</div>';
			document.querySelector('.contentbox').innerHTML = html
		}else{
			let html = document.querySelector('.contentbox').innerHTML;
			 html +=  '<div class="row g-0 my-3">'+
			'	<div class="col-sm-1 mx-2">'+
			'		<img width="100%;" class="rounded-circle" alt="" src="/jspweb/img/'+msg.img+'">'+
			'	</div>'+
			'	<div class="col-sm-9"> '+
			'		<div class="recontent"> '+
			'			<div class="name">'+msg.mid+'</div>'+
			'			<img src="/jspweb/img/imoji/emo'+msg.content+'.gif" width="90px">'+
			'			<span class="date">'+msg.date+'</span>'+
			'		</div>'+
			'	</div>'+
			'</div>';
			document.querySelector('.contentbox').innerHTML = html
		}
	
	}else if(msg.type == 'alarm'){
		///////////////////////////////////////3. 알람 메시지 코드 /////////////////////////////////////////////
		let html = document.querySelector('.contentbox').innerHTML;
		html +=	'<div class="alarm">'+
					'<span> '+msg.content+' </span>'+
				'</div>';
		document.querySelector('.contentbox').innerHTML = html
	}
	///////////////////////////////스크롤 하단으로 내리기///////////////////////////
	let top = document.querySelector('.contentbox').scrollTop;
	let topdd = document.querySelector('.contentbox').scrollHeight;
	console.log(top)
	console.log(topdd)
	document.querySelector('.contentbox').scrollTop = document.querySelector('.contentbox').scrollHeight
 }
 //에러
 function onerror(e){ alert(e) }
 
 emoview()//이모티콘 호출
 
 function emoview(){
	let html = '';
	for(let i = 1 ; i <= 43 ; i++){
		html += '<img alt="" src="/jspweb/image/imoji/emo'+i+'.gif" onclick="emosend('+i+')"> '
	}
	document.querySelector('.dropdown-menu').innerHTML = html
}

// JSON ---> 문자열 변환 	JSON.stringify( )
// 문자열 ---> JSON 변환  	JSON.parse( )