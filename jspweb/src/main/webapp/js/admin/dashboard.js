/**
 * 
 */
 alert('연동')
 
 let sidebar = document.querySelector('.sidebar')
 let mainbox = document.querySelector('#mainbox')
 //사이드바 열기//////////////////////////////////////////////////////////
 sidebar.addEventListener('click' , function(){
	//해당 사이드바 css벼ㄴ경
	sidebar.style.left = 0;
})
 //3.본문 div를 클릭했을때 이벤트///////////////////////////////////////////////////
 mainbox.addEventListener('click' , function(){
	//해당 사이드바 css변경
	sidebar.style.left = '-170px';
})
///////////////////////////////본문전환 이벤트////////////////////////////////
function pagechange(page){
	//특정 태그에 해당 파일을 로드
	$('#mainbox').load(page)
}