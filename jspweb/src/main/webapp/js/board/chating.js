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
function onopen(e){ 	alert( e ) }
function onclose(e){  	alert( e )}
function send(){ 
	let msg = {
		content : document.querySelector('.msgbox').value , 
		mid : mid , 
		date : new Date().toLocaleTimeString() 
	}
	clientsocket.send( JSON.stringify(msg) )
	document.querySelector('.msgbox').value = ''
}
function enterkey(){ if(window.event.keyCode == 13){ send() } }
function onmessage(e){
	let msg = JSON.parse( e.data )
	console.log( msg )
	let html = '<div>'+
					'<span>'+msg.mid+'   :   </span>'+
					'<span>'+msg.content+'</span>'+
					'<span> [ '+msg.date+' ] </span>'+
				'</div>';
	document.querySelector('.contentbox').innerHTML += html; 
 }
function onerror(e){ 	alert(e) }



// JSON ---> 문자열 변환 	JSON.stringify( )
// 문자열 ---> JSON 변환  	JSON.parse( )