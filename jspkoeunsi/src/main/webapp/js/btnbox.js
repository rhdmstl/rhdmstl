/**
 * 
 */
 
 function pview(){
	$.ajax({
		url: "/jspkoeunsi/postlist",
		success : function( re ){
			let board = JSON.parse(re)
			document.querySelector('.mno').innerHTML = board.mno;
			document.querySelector('.mtitle').innerHTML = board.mtitle;
			document.querySelector('.mcontent').innerHTML = board.mcontent;
			document.querySelector('.mwtiter').innerHTML = board.mwtiter;
			document.querySelector('.mpw').innerHTML = board.mpw;
			document.querySelector('.mdate').innerHTML = board.mdate;
			document.querySelector('.mview').innerHTML = board.mview;
			///jspweb/board/view
			/* 파일추가
				<a href="URL?변수명=데이터>
			 */
		//		if(board.bfile){	///null , undefined , 0 , false
		//			alert('null아닙니다')
		//			let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
		//			document.querySelector('.bfile').innerHTML = filelink;
			//	}
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