/**
 * 
 */
 function 함수1( ){ 
	alert ('함수1실행') }
	
 function 함수2( value ){
	alert('함수2실행 매개변수 +value')
}

function 함수3( vlue1 , vlue2 ){
	alert('함수3실행 매개변수 +value'+ vlue1 + vlue2)
	return vlue1 + vlue2
}
function 함수4( ){
	alert('함수4실행')
	return 10
}

함수1()
함수2( 50 )
let result = 함수3( 3 , 5 )
let result2 = 함수4()



function min( array ){
	 let output = array[0]
	 for(const item of array ){
		if(output > item){
			output = item
		}
	}
	return output
}

const testArray = [52,273,32,103,275,24,57]
console.log(`${testArray}중에서`)
console.log(`최솟값 = ${min(testArray)}`)










































