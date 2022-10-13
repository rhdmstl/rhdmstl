/**
 * 
 */
 bview()
 
 function bview(){
	$.ajax({
		url: "/jspweb/board/view",
		success : function( re ){
			let board = JSON.parse(re)
			docment.querySelector('.bno').innerHTML = board.bno;
			docment.querySelector('.btitle').innerHTML = board.btitle;
			docment.querySelector('.bcontent').innerHTML = board.bcontent;
			docment.querySelector('.mno').innerHTML = board.mno;
		}
	})
}