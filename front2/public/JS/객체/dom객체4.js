/**
 * 
 */
 //js 태그 생성
 const header = document.createElement('h1')
 
 //텍스트 조작
 header.textContent = 'js에서 만든 태그'
 header.style.color = 'white' 
 header.style.backgroundColor = 'black'
 
 //해당태그에 하위태그로 객체 추가
 document.body.appendChild(header)
 
 
 //321p
 const divA = document.querySelector('#first')
 const divB = document.querySelector('#second')
 const h1 = document.createElement('h1')
 h1.textContent = '이동하는 h1 태그'
 
 const toFirst = () => {
	divA.appendChild(h1) //첫번쨰 div에 js태그 추가
	setTimeout(toSecond , 2000) //1초뒤에 다른 함수 실행[toSecond]
	}
 
 const toSecond = () => {
	divB.appendChild(h1)
	setTimeout(toSecond , 2000) //타이머함수 밀리초로 입력(1000/1)
}
toFirst()//함수실행

//322 객체 제거

const h2 = document.querySelector('h1')

setTimeout(() => {
	h2.parentNode.removeChild(h2)
} , 3000)

function 함수() {
	h2.parentNode.removeChild(h2)
}
setTimeout(함수 , 3000)