/**
 * 
 */
 
 //331
 //html태그를 문서 객체로 가져옴

 const 긴글상자 = document.querySelector('textarea')
 
 const 헤더텍스트 = document.querySelector('h1')
 
 긴글상자.addEventListener('keyup' , () => {
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자수 : ${길이}`
})//1회용


//2010년 버전
function 글자수(){
	const 길이 = 긴글상자.value.length
	헤더텍스트.textContent = `글자수 : ${길이}`
}//다회용 가능

//333p

const h2 = document.querySelector('h2')
const print = (event) => {
	let output = ''
	output += `alt : ${event.altKey}<br>`
	output += `ctrl : ${event.ctrlKey}<br>`
	output += `shift : ${event.shiftKey}<br>`
	output += `code : ${typeof(event.code) != 'undefined' ?
		event.code : event.keycode}<br>`
		
	h2.innerHTML = output
}

document.addEventListener('keyup' , print)











