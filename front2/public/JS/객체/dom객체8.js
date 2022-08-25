/**
 * 
 */
 
 
 //1.html요소 가져오기
 const input = document.querySelector('#inchbox')
 const button = document.querySelector('#inchBtn')
 const p = document.querySelector('#inchp')
 
 //2.버튼 눌렀을때
 button.addEventListener('click' , () => {
	const inch = Number(input.value)
	//isNaN(데이터) : 숫자 != true / 숫자 == false
	if(isNaN(inch)){
		p.textContent = '숫자를 입력해주세요'
		return
	}
	//입력값이 숫자 ==
	const cm = inch *2.54
	p.textContent = `${cm} cm`
})

//341
const emailbox = document.querySelector('#emailbox')
const emailp = document.querySelector('#emailp')

//이메일검증 함수
const isemail = (value) => {
	return(value.indexOf('@') > 1) && (value.split('@')[1].indexOf(".") > 1)
											//split은 끊어서 배열표기 [0] , [1],,,
			//입력데이터의 @가 있는지 	   이면서		입력데이터의 @ 뒤문자 
			//								dfsf@naver.com
			//									 naver.com -> . 있는지
}

emailbox.addEventListener('keyup' , (event) => {
	const value = event.currentTarget.value
	if(isemail(value)){
		p.style.color = 'green'
		p.textContent = `이메일 형식입니다 : ${value}`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다 : ${value}`
	}
})
//343
const selectbox = document.querySelector('#selectbox')
const selectp = document.querySelector('#selectp')

//2.selectbox의 데이터가 변경될때마다 실행되는 이벤트 [change]
selectbox.addEventListener('change' , (event) => {
	
	//select의 모든 option을 호출 s가 붙어야함
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	
	selectp.textContent = `선택 : ${options[index].textContent}`
})


//344
const selectbox2 = document.querySelector('#selectbox2')
const selectp2 = document.querySelector('#selectp2')

selectbox2.addEventListener('change' , (event) => {
	const options = event.currentTarget.options
	const list = [ ]
	
	for(const option of options){
		if(option.selected){
			list.push(option.textContent)
		}
	}
	selectp2.textContent = `선택 : ${list.join(',')}`//배열내 요소들은 한줄의 문자로 묶음
})

//345-6p

let 현재값
let 변환상수 = 10

const cminput = document.querySelector('#cminput');
const cmspan = document.querySelector('#cmspan');
const cmselect = document.querySelector('#cmselect');

//3select상자의 데이터를 변경했을때 이벤트
cmselect.addEventListener('change' , (event) => {
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	변환상수 = Number(options[index].value)
	calculate()
})

//2.
const calculate = () => {
	cmspan.textContent = (현재값*변환상수).toFixed(2)
}

//1.입력할때마다 현재값을 변수로 변환해주는 이벤트
cminput.addEventListener('keyup' , (event) => {
	현재값 = Number(event.currentTarget.value)
	calculate()
})

//347p

let timer = 0 	//타이머 (초) 저장변수
let timerID = 0 //타이머함수를 저장하는 변수[setInterval]

const timerinput = document.querySelector('#timerinput')
const timerh1 = document.querySelector('#timerh1')
//1. 만약에 체크박스의 상태가 변경되었을때
timerinput.addEventListener('change' , (event) => {
	//1.체크가 됐는지 확인[setInterval(함수명,초)]
	if(event.currentTarget.checked){//체크되있는 상태
		timerID = setInterval(() => {
			timer += 1 
			timerh1.textContent = `${timer}초`
		} , 1000)
	}else{//체크안되있는 상태
		clearInterval(timerID)
	}
})

//348-9p

const radios = document.querySelectorAll('[name=pet]')
const output = document.querySelector('#output')

radios.forEach((radio) => {
	radio.addEventListener('change' , (event) => {
		const current = event.currentTarget
		if(current.checked){
			output.textContent = `좋아하는 애완동물은 ${current.value} 이시군요!`
		}//if end
	})//event end
})//forEach end
