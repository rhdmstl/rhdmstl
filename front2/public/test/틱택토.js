/**
 * 
 */
const count = []
 
function 게임판그리기( i ){
	let 게임판 = ''
	for(let i = 0 ; i<9 ; i++){		
		게임판 += `<button id="${i}" onclick="버튼선택(${i})">${i}</button>`
		if(i%3==2){
			게임판 += '<br>'
		}
	}	
	document.getElementById('gameboard').innerHTML = 게임판 
}

function 버튼선택(i){
	
	count.push(i)
	document.getElementById(i).innerHTML = 'O'
	console.log(count)
	
	if(count.length==9){ 
		alert('빈 자리가 없습니다.')
		return
	}

	if(count.length%2==1){
		let rand = Math.floor(Math.random()*9)
		document.getElementById(rand).innerHTML = 'X'
		count.push(rand)
	}
	console.log(count)
}


