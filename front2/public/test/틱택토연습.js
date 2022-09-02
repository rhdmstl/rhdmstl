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