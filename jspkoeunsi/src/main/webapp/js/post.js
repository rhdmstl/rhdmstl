/**
 * 
 */
 list();
 //글목록보기
 function list(){
	
	console.log(list)
	$.ajax({
		url : "http://localhost:8080/jspkoeunsi/postlist",
		success : function(result){
			console.log(result)
			let list = JSON.parse(result)
			let html = ""
			for(let i = 0 ; i<list.length ; i++){
				let p = list[i]
				console.log(p)
				html +=
					'<tr>'+
						'<td>'+p.mno+'</td>'+
							'<td>'+p.mtitle+'</td>'+
							'<td>'+p.mcontent+'</td>'+
							'<td>'+p.mwtiter+'</td>'+
							'<td>'+p.mdate+'</td>'+
							'<td>'+p.mview+'</td>'+
					'<tr>';
			}
			console.log(html)
			document.querySelector('#postlist').innerHTML += html
		}
	})
}
	//글쓰기
 function post(){
	let mtitle = document.querySelector('#mtitle').value
	let mcontent = document.querySelector('#mcontent').value
	let mwtiter = document.querySelector('#mwtiter').value
	let mpw = document.querySelector('#mpw').value
	$.ajax({
		url : "/jspkoeunsi/post", //서블렛
		data : { "mtitle" : mtitle , "mcontent" : mcontent , "mwtiter" : mwtiter , "mpw" : mpw} ,
		success : function(re){
			if(re === 'true'){alert('등록완료')}
			else{alert('등록실패')}
		}
	})
}
