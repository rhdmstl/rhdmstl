/**
 * 
 */
 
 let counter = 0 //클릭수를 저장하는 변수
 let isConnect = false
 
 //요소가져오기
 const h1 = document.querySelector('h1')
 const p = document.querySelector('p')
 const connectBtn = document.querySelector('#connect')
 const disconnectBtn = document.querySelector('#disconnect')

//출력하는 함수
 const listener = () => {
	h1.textContent = `클릭횟수 : ${++counter}`
} 
 //연결버튼
connectBtn.addEventListener('click' , ()=>{ 
	h1.addEventListener('click' , listener)
	p.textContent = '이벤트연결 상태 : 연결'
	isConnect = true
 })

 //연결해제버튼
 disconnectBtn.addEventListener('click' , () => {
	if(isConnect == true){
		h1.removeEventListener('click' , listener)
		p.textContent = '이벤트 연결 상태 : 해제'
		isConnect = false
	}
})

