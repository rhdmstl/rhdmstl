/**
 * 차트리스트.js 이용한 차트구현
 */
 
  let 지원자리스트 = [ ]//지원자 객체들을 담을 배열 선언
//파이차트(원형)=백분율 데이터객체 선언
 let pieData = {
	labels : ['웹디자이너' , '웹개발자' , '서버엔지니어' , '영업직'],// 항목의 이름
	series : [ 14 , 9 , 8 , 6 ]//항목 값
};
 let pieOptions = {
	width : '100%',
	height : '440px'
};
 //차트적용하기 Chartist.Pie 클래스
new Chartist.Pie('.pie_chart',pieData,pieOptions)
 
 
//막대그래프
 let barData = {
	labels : ['2018년' , '2019년' , '2020년'],
	series : [[10,16,29]]
};

 let barOptions = {
	axisY : {//let 객체명 = { 키 : {객체 안에 객체가능(배열)}}
		offset : 60 ,
		scaleMinSpace:50 ,
		labelInterpolationFnc: function(value){
			return value + '명'
		}
	},
	width : '100%',
	height : '440px'
};

new Chartist.Bar('.bar_chart',barData,barOptions)

//2.막대그래프
 let barData2 = {
	labels : [ ],
	series : [[]]
};

 let barOptions2 = {
	axisY : {//let 객체명 = { 키 : {객체 안에 객체가능(배열)}}
		offset : 60 ,
		scaleMinSpace:50 ,
		labelInterpolationFnc: function(value){
			return value + '원'
		}
	},
	width : '100%',
	height : '440px'
};
function button(){
	const name = document.getElementById('name').value;
	const mony = document.getElementById('mony').value;
	 barData2.labels.push(name)
	 barData2.series[0].push(mony)
 
 new Chartist.Bar('.bar_chart2',barData2,barOptions2)
}



//지원자 목록저장

 function 지원자등록(){
	console.log('지원자 등록')//1번 테스트
	let 입력리스트 = document.querySelectorAll('input')
	let 목록상자 = document.querySelector('select')
	let 긴글상자 = document.querySelector('textarea')
	//2번테스트
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

