/**
 * 
 */
 //전역변수
 let pageinfo = {//js객체
	listsize : 5,	// 한페이지당 게시물 표시 개수
	page : 1,	// 현재 페이지 번호 
	key : '' ,	//검색키
	keyword : '' ,	//검색키워드
}

//화면에 표시할 표시 갯수
function blistsize(){
	alert('dd')
	pageinfo.listsize = document.querySelector('.listsize').value
	list(1)
}

 //검색처리
 function bsearch(){
	let key = document.querySelector(".key").value
 	let keyword = document.querySelector(".keyword").value
      
    pageinfo.key = key
    pageinfo.keyword = keyword

	//pageinfo.key = document.querySelector('.key').valuekey
	//pageinfo.keyword = document.querySelector('.keyword').value
	console.log(pageinfo) //어떤 모습이여야하는지 다음 모습으로 넘어가도되나요
	list(1)
}

 list(1) // js 열람시 메소드 1번 실행  [ 첫 화면에서 1페이지 ]
 
 function list(page){
	pageinfo.page = page
	console.log(pageinfo)
	$.ajax({
		url: "/jspweb/board/list",
		data : pageinfo,
		success : function( re ){
			let boards = JSON.parse(re)
			console.log(boards)
			//object내 게시물리스트 먼저 호출
			let boardlist = boards.data
			console.log( boardlist )
			let html = ""
			// boardlist -> 객체를 하나씩 꺼내기
			for(let i = 0 ; i<boardlist.length ; i++){
				let b = boardlist[i]
				console.log(b)
				html +=
					'<tr>'+
						'<td>'+b.bno+'</td>'+
							'<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
							'<td>'+b.mid+'</td>'+
							'<td>'+b.bdate+'</td>'+
							'<td>'+b.bview+'</td>'+
					'<tr>';
			}
			console.log(html)
			document.querySelector('.btable').innerHTML = html
			
			//1.페이징버튼 HTML구성
			let pagehtml = ''
				//이전버튼
				if(page <= 1){
					pagehtml += '<button onclick="list('+(page)+')">이전</button>'
					}
				else{//현재페이지보다 뒤로
					pagehtml += '<button onclick="list('+(page-1)+')">이전</button>'
					}
				
				//페이지 번호 버튼
				for(let page = boards.startbtn ; page <=boards.endbtn ; page++){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>'
				}
				console.log(page)
				//다음버튼
				if(page >= boards.totalpage){
					pagehtml += '<button onclick="list('+page+')">다음</button>'
					}
				else{
					 pagehtml += '<button onclick="list('+page+1+')")">다음</button>'; 
					 }
			//전체
			document.querySelector('.pagebox').innerHTML = pagehtml;
			//검색된 게시물 수 표기
			document.querySelector('.totalsize').innerHTML = boards.totalsize;
		}
	})
}

 //상세페이지로 이동
 function viewload( bno ){
	$.ajax({
		url : "/jspweb/board/viewload" , 
		type : "post",
		data : { "bno" : bno },
		success : function( re ){
			console.log(re)
			location.href = "/jspweb/board/view.jsp"
		}
	})
}