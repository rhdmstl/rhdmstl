/**
 * 
 	왼쪽 방향키 37
 	위쪽 방향키 38
 	오른쪽 방향키 39
 	아래쪽 방향키 40
 	
 */
 //별의 초기 설정
 const star = document.querySelector('h1')
 star.style.position = 'absolute'
 
 let [ x , y ] = [ 0 , 0 ]
 const block = 20
 const print = () => {
	star.style.left = `${x*block}px`
	star.style.top = `${y*block}px`
}
print()

const [left , up , right , down] = [37 , 38 , 39 , 40]

document.body.addEventListener('keydown' , (event) => {
	switch( event.keyCode ){ //값을 제어하는 문법 bteak랑 세트임
		case left:
		x -= 1
			break
		case up:
		y -= 1
			break
		case right:
		x += 1
			break
		case down:
		y += 1
			break
	}
	print()
})