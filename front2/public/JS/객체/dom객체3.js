/**
 * 
 */
 
 document.addEventListener('DOMContentLoaded' , () => {
 
	 const a = document.querySelector('#a') //해당 id의 1개의 요소
	 const b = document.querySelector('#b')
	 
	 a.textContent = '<h1> 텍스트 그대로 넣기</h1>'
	 b.innerHTML = '<h1> html 형식으로 넣기</h1>'
 
 	const rects = document.querySelectorAll('.rect')
 	
 	for(let i = 0 ; i<rects.length ; i++){
 	const width = ( i +1 ) *100
 	const src = `http://placekitten.com/${width}/250`
 	rects[i].setAttribute('src' , src)
  }
  	//3.318p 스타일 조작
  	const divs = document.querySelectorAll('div')
 	//배열명,forEach([콜백함수](요소명 , index , 배열명 )=>{ }) 	
  	divs.forEach((div,index)=>{

	console.log(div , index)
	const val = index *10
	div.style.height = `10px`
	div.style.backgroundColor = `rgba(${val},${val},${val})`
 })
 })