/**
 * 
 */
 
  let 게임상황 = []
  
  function 게임판그리기(){
	
	let 게임판 = ''
	
	for(let i = 0 ; i<9 ; i++){
		게임판 += `<button>${i}</button>`
		if( i % 3 == 2){게임판 += `<br>`}
	}
	document.querySelector('#gameboard').innerHTML = 게임판
}

let 게임상황1 = []
 
 function 게임판그리기(){
	
	let 게임판1 = ''
	
	for(let i = 0 ; i<9 ; i++){
		게임판1 += `<button>${i}</button>`
		if(i % 3 == 2 ){
			게임판1 += `<br>`
		}
		document.querySelector('#gameboard1').innerHTML = 게임판1
	} 
}

 let 게임상황2 = []
 
  function 게임판그리기(){
	
	let 게임판2 = ''
	
	for(let i = 0 ; i<9 ; i++){
		게임판2 += `<button>${i}</button>`
		if(i % 3 == 2){
			게임판2 += `<br>`
		}
		document.querySelector('#gameboard2').innerHTML = 게임판2
	}
}

 let 게임상황3 = []
  
  function 게임판그리기(){
	
	let 게임판3 = ''
	
	for(let i = 0 ; i<9 ; i++){
		게임판3 += `<button>${i}</button>`
		if( i % 3 ==2 ){
			게임판3 += `<br>`
		}
			document.querySelector('#gameboard3').innerHTML = 게임판3
	}
}

 let 게임상황4 = []
 
  function 게임판그리기(){
	
	let 게임판4 = ''
	
	for(let i = 0 ; i<9 ; i++){
		게임판4 += `<button>${i}</button>`
		if( i % 3 == 2){
			게임판4 +=`<br>`
		}
		document.querySelector('#gameboard4').innerHTML = 게임판4
	}
}