/**
 * 
 */
 
 let 지원자리스트 = [ ]
 
 function 지원자등록(){
	console.log('지원자 등록')
	let 입력리스트 = document.querySelectorAll('input')
	let 목록상자 = document.querySelector('select')
	let 긴글상자 = document.querySelector('textarea')
	console.log(입력리스트)
	console.log(목록상자)
	console.log(긴글상자)
	
	let 지원자 = {
		성명 : 입력리스트[0].value,
		영문명 : 입력리스트[1].value,
		메일주소 : 입력리스트[2].value,
		포토폴리오 : 입력리스트[3].value,
		희망근무지 : 입력리스트[4].value,
		현재상태 : 목록상자.value,
		자기소개 : 긴글상자.value,
	}
	console.log(지원자)
	지원자리스트.push(지원자)
	console.log(지원자리스트)
}