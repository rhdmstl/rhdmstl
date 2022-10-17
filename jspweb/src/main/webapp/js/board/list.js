/**
 * 
 */
 list()
 
 function list(){
	$.ajax({
		url: "/jspweb/board/list",
		success : function( re ){
			console.log( re )
			let boardlist = JSON.parse(re)
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
			document.querySelector('.btable').innerHTML += html
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
 
 
 