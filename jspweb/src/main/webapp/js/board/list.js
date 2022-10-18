/**
 * 
 */
 let pageinfo = {//js객체
	listsize : 3,	// 한페이지당 게시물 표시 개수
	page : 1	// 현재 페이지 번호 
}
 
 list(1) // js 열람시 메소드 1번 실행  [ 첫 화면에서 1페이지 ]
 
 function list(page){
	pageinfo.page = page
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
							//'<td><a href="http://localhost:8080/jspweb/board/view.jsp?bno='+b.bno+'">'+b.btitle+'</a></td>'+
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
				else{
					pagehtml += '<button onclick="list('+(page-1)+')">이전</button>'
					}
				
				//페이지 번호 버튼
				for(let page = boards.startbtn ; page <=boards.endbtn ; page++){
					pagehtml += '<button type="button" onclick="list('+page+')">'+page+'</button>'
				}
				//다음버튼
				if(page >= boards.totalpage){
					pagehtml += '<button onclick="list('+page+')">다음</button>'
					}
				else{
					 pagehtml += '<button onclick="list('+page+1+')")">다음</button>'; 
					 }
				
			document.querySelector('.pagebox').innerHTML = pagehtml;
		}
	})
}
 function viewload( bno ){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/viewload" , 
		data : { "bno" : bno },
		success : function( re ){
			location.href = "http://localhost:8080/jspweb/board/view.jsp"
		}
	})
}
 
 
 