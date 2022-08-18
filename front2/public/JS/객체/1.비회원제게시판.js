/**
 * 
 */
 

//4.게시물 객체 여러개 저장할 공간 = 배열 사용
let boardlist = [ ]

게시물출력()

//3.함수선어 [ 글 등록 버튼을 클릭할때 마다 ] 글 등록 버튼을 눌렀을때[마다 ->함수] 1/2 실행한다
function 글등록(){
//1. html input태그에 입력된 데이터 호출 
	let bwriter = document.getElementById('bwriter').value
	let bpassword = document.getElementById('bpassword').value
	let btitle = document.getElementById('btitle').value
	let bconteant = document.getElementById('bconteant').value
	//2.객체에 담기
	let board = {
		작성자	: bwriter,
		비밀번호	: bpassword,
		제목		: btitle,
		내용		: bconteant
	}
	//5.객체들 배열에 저장
	boardlist.push( board )//배열 저장하는게 푸쉬함수
	alert('[안내] 글 등록이 되었습니다')
	//3.테스트
	//console.log('글 등록이 되었습니다' + boardlist )
	//6.input에 공백넣기
	document.getElementById('bwriter').value = ''
	document.getElementById('bpassword').value = ''
	document.getElementById('btitle').value = ''
	document.getElementById('bconteant').value = ''
	게시물출력()
}

//1.
function 게시물출력(){
	let html = '<tr> <th>번호</th> <th>제목</th> <th>작성자</th> </tr>'
	//반복문
	
	for(let i = 0 ; i<boardlist.length ; i++){
		//i=0부터 배열의 길이까지 1씩 증가 
		html+= '<tr><td>'+i+'</td><td><a href="#" onclick="게시물보기('+i+')">'+boardlist[i].제목+'</a></td><td>'+boardlist[i].작성자+'</td></tr>'
	}		
			//" " : answkcjfl ' ': 문자처리 vs `${ }`
			//js에서 html 작성시 문자처리 : '<태그명 onclick="함수()">'
	document.getElementById('boardlist').innerHTML = html
}

function 게시물보기( i ){
	document.getElementById('viewtitle').innerHTML = boardlist[i].제목
	document.getElementById('viewwriter').innerHTML = boardlist[i].작성자
	document.getElementById('viewcontent').innerHTML = boardlist[i].내용
}







