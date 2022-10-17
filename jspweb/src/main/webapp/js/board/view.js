/**
 * 
 */
 bview()
 
 function bview(){
	$.ajax({
		url: "/jspweb/board/view",
		success : function( re ){
			let board = JSON.parse(re)
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			///jspweb/board/view
			/*
				<a href="URL?변수명=데이터>
			 */
				if(board.bfile){	///null , undefined , 0 , false
					alert('null아닙니다')
					let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
					document.querySelector('.bfile').innerHTML = filelink;
				}
			let btnbox = document.querySelector('.btnbox')
			
			
			if(board.btnaction == true){
				//삭제버튼
				let deletebtn = '<button type="button" id="delete" onclick="bdelete('+board.bno+')">삭제</button>'
				btnbox.innerHTML += deletebtn
				//수정버튼
				let updatebtn = '<button><a href="../board/update.jsp">수정</a></button>'
			}
		}
	})
}  
 function bdelete(bno){//삭제할 버튼 클릭시 삭제할 번호 인수
	$.ajax({
		url: "/jspweb/board/bdelete",
		data : {"bno" : bno},
		success : function( re ){
			if(re === 'true'){
				alert('글삭제 성공')
				location.href="/jspweb/board/list.jsp"
			}
			else{
				alert('글삭제 실패 : [관리자에게 문의하세요]')
			}
		}
	})
}