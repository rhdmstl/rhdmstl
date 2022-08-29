/**
 * 차트리스트.js 이용한 차트구현
 */
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
			return value + '명'
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