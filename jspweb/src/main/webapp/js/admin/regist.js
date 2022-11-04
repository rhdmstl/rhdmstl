/**
 * 
 */
 
 function regist(){
	alert('등록')
	
	let form = document.querySelector('form')
	let formdata = new FormData(form)
	console.log(form)
	console.log(formdata)
	
	$.ajax({
		url : "/jspweb/admin/regist",
		data : formdata,
		/* form 전송이 첨부파일일 경우*/
		type : 'POST',
		contentType : false,
		processData : false,
		success : function( re ){
			if(re == 'true'){
				alert('제품등록')
			}else{alert('실패')}
		}
	})
}
 //2.첨부파일을 등록(변경)했을때 미리보기
 let pimg = document.querySelector('#pimg')
 
 pimg.addEventListener('change' , function(e){ //e : event객체 (이벤트 정보[target,data 등])
	//1.js 파일클래스[]
	let file = new FileReader()//객체생성
		console.log('파일'+file)
		console.log('파일'+e)			//이벤트 객체
		console.log('파일'+e.target)	//이벤트 발생기킨 태그 <input type="file">
		console.log('파일'+e.target.files[0])	// 해당 태그의 등록된 파일호출
	//2. 해당 첨부된 파일 경로알기 [.readAsDataURL(파일)]
	file.readAsDataURL(e.target.files[0])
	//3.img태그 첨부된 이미지 대입
	file.onload = function(e){				//e : 로드된 file이벤트
	document.querySelector('#pimgpre').src = e.target.result //서버가 [사용자의 c드라이브 경로 요청x]
	}
})
 //3.카테고리 추가버튼을 눌렀을떄 이벤트
 function pcategoryview(){
	document.querySelector('.pcategoryaddbox').innerHTML
	='<input type="text" id="pcname">'+
		'<button type="button" onclick="pcategoryadd()">등록</button>'
}
 //4.카테고리 등록 버튼을 눌렀을때 이벤트
function pcategoryadd(){
	$.ajax({
      url : "/jspweb/admin/pcategory",
      type : "POST",
      data : { "pcname" : document.querySelector('#pcname').value } ,   
      success : function(re){
         if(re == 'true'){
         alert('카테고리등록')
         document.querySelector('.pcategoryaddbox').innerHTML = ''
         pcategorybox()
         }else{alert('카테고리등록실패')}
      }
      
   })
}
//5.카테고리호출 메소드
 pcategorybox()
 function pcategorybox(){
	$.ajax({
		url : "http://localhost:8080/jspweb/admin/pcategory",
		type : "GET",
		success : function(re){
			let json = JSON.parse(re)
			let html = ''
			
			for(let i = 0 ; i < json.length ; i++){
				let category = json[i];
				//name 값 꼭 같아야함
				html += '<input type="radio" name="pcno" value="'+category.pcno+'">'+category.pcname 
			}
			document.querySelector('.boxboxlist').innerHTML = html;
		}
	})
}