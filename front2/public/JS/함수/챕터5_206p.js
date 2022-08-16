/**
 * 
 */
 //206p
 function sample(...items){
	console.log(items)
}

sample( 1 , 2 , 3 )

sample( 1 , 2 , 3 , 4)

sample( 1 , 2 , 3 , 4 , 'java' , true , '안녕하세요')

//208p
function sample2( a , b , ...c ){
	console.log( a , b , c )
}
sample2( 1 , 2 )
sample2( 1 , 2 , 3 )
sample2( 1 , 2 , 3 ,4 )
sample2( 1 )

//211p
function sample3(...items){
	console.log( items )
}

const array = [ 1 , 2 , 3 , 4 ]
console.log( "# 전개 연산자를 사용하지 않는 경우" )
sample3( array )
console.log( "# 전개 연산자를 사용한 경우" )
sample3( ...array )