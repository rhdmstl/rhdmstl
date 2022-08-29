 
 document.addEventListener('DOMContentLoaded' , () => {
	
	//변수 = h1 태그 이름으로 요소(태그) 선택 [태그를 js객체로 가져오기]
	const header = document.querySelector('h1')
	//querySelector : 요소 1개 가져오기
	//querySelectorAll : 요소 여러개 가져오기
	
	console.log(header)
	console.log(typeof(header))
	
	//텍스트와 스타일 변경
	header.textContent ='안녕~~'
	header.style.color = 'white'//css 조작
	header.style.backgroundColor = 'black'
	header.style.padding = '10px'
})

document.addEventListener('DOMContentLoaded' , () => {
	const headers = document.querySelectorAll('h1')
	console.log(headers)
	console.log(typeof(headers))
	for(let i = 0 ; i<headers.length ; i++){
		headers[i].textContent = '안녕'+i //이게 기본
	}
	for(let index in headers){//index를 하나씩 넣어줌
		headers[index].textContent = '안녕'+index
	}
	for(let object of headers){//object의 데이터(값)을 하나씩 대입
		object.textContent = '안녕'
	}
	headers.forEach((object)=>{object.textContent='안녕'})
})
