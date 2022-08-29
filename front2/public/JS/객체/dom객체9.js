
 const imgs = document.querySelectorAll('img')
 
 for(let i = 0 ; i<imgs.length ; i++){
	imgs[i].addEventListener('contextmenu' , (event) => {//[contextmenu]오른쪽클릭했을때
		event.preventDefault()
	})//[i]인덱스표시
}
for(let i in imgs){
	if(i.length-1 == i){break}//마지막 인덱스 제외
	i.addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
}

for(let i of imgs){
	i.addEventListener('contextmenu' , (event) => {
		event.preventDefault()
	})
}

imgs.forEach((img) => {
	img.addEventListener('contextmenu' , (event) => {//[contextmenu]오른쪽클릭했을때
		event.preventDefault()
	})//[i]인덱스표시
})

let 상태 = false /*체크박스 여부확인 변수 */
const 체크박스 = document.querySelector('input')

체크박스.addEventListener('change' , (이벤트속성) =>{
	상태  = 이벤트속성.currentTarget.checkboxed
})
/*------------링크제어------------*/
const 링크 = document.querySelector('a')

링크.addEventListener('click' , (이벤트속성) =>{
	if(!상태 ){
		이벤트속성.preventDefault()
	}
})