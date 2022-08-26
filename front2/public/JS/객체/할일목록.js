
document.addEventListener('DOMContentLoaded' , () => {
	//문서객체를 가져옵니다
	const input = document.querySelector('#todo')
	//아이디 todo 호출
	const todoList = document.querySelector('#todo-list')
	//아이디 todo-list 호출
	const addbutton = document.querySelector('#add-button')
	//아이디 add-button 호출
	
	let keyCount = 0
	//변수 선언
	
	const addtodo = () => {
		//함수선언
		if(input.value.trim() === ''){
			//입력양식에 내용이 없으면 추가하지않습니다
			alert('할 일을 입력해주세요')
			//상태 안내창 띄우기
			return
			//빈칸이면 다시 입력하라고 안내하기
		}
		const item = document.createElement('div')
		//div 만들기
		const checkbox = document.createElement('input')
		//input 만들기
		const text = document.createElement('span')
		//span 만들기
		const button = document.createElement('button')
		//button 만들기
		const key = keyCount
		//상수 선언
		keyCount += 1
		//keyCount에 1씩 더해서 대입
		
		//[setAttribute]객체를 조작하고 추가
		item.setAttribute('data-key' , key)
		//data-key에 숫자를 대입함
		item.appendChild(checkbox)
		//아이템 checkbox추가
		item.appendChild(text)
		//아이템 text추가
		item.appendChild(button)
		//아이템 button추가
		todoList.appendChild(item)
		//아이템 itme추가
		
		checkbox.type = 'checkbox'
		//checkbox의 타입이 체크박스다
		checkbox.addEventListener('change' , (event) => {
		//체크박스가 변하면 이벤트를 추가하고 그 값을 event에 저장
			item.style.textDecoration
			//css에서 아이템 스타일을 꾸며줄것이다
			=event.target.checked ? 'line-through' : ''
			//체크박스가 선택되면 가운데 줄이 그어지고 빈칸이면 이벤트실행 X
		})
		text.textContent = input.value
		//text객체 조작
		
		button.textContent = '제거하기'
		//제거하기 버튼
		button.addEventListener('click' , () => {
		//버튼을 클릭하는 이벤트가 발생
			removeTodo(key)
			//todo 리스트에서 삭제
		})
		input.value = ''
	}
	const removeTodo = (key) =>{
	//식별키로 문서 객체삭제
		const item = document.querySelector(`[data-key="${key}"]`)
		//위에서 지정한 data-key를 숫자 요소로 호출
		todoList.removeChild(item)
		//todoList에서 아이템하위객체 삭제
	}
	addbutton.addEventListener('click' , addtodo)
	//버튼을 클릭해서 리스트가 추가되면
	input.addEventListener('keyup' , (event) => {
		//input박스에 keyup이벤트가 발생하면
		const ENTER = 13
		//엔터가 13
		if(event.keyCode === ENTER){
			//엔터이벤트가 발생하면
			addtodo()
			//추가된다
		}
	})
})