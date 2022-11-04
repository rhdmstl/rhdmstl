/**
 * 
 */
  let datalist = null //[전역변수]
  ////////////////////////////////////////////////[함수호출]///////////////////////////////////////
  getdata()
  /////////////////////////////////////////////공공데이터 api호출///////////////////////////////////
  function getdata(){
	 $.ajax({
		url : "/jspweb/board/api",
		success : function(re){
			let json = JSON.parse(re)
			console.log(json)	//공공데이터 전체
			datalist = json.data	//datalist:객체 중 daga속성[키,필드] 호출
			dataprint(  )	//검색이 없으면 모둔 약국호출
		}
	})
}
 //검색버튼 눌렀을때
 function addrsearch(){
	alert('검색')
	let addr = document.querySelector('.addrinput').value
	dataprint(addr)	//검색어 전달
}
 //html에 약국리스트 출력함수
 function dataprint(search){
	//console.log('타입확인'+typeof(search))
	//undefined vs "undefined"	or	null vs "null"
	if(search !== undefined){//검색이 있을경우
		let searchlist = []	//검색된 약국리스트[] 선언
		for(let i = 0 ; i < datalist.length ; i++){
			let addr = datalist[i].주소
			console.log(addr)
			if(addr.indexOf(search) !== -1){	//검색한 키워드와 포함된
				searchlist.push(datalist[i])	//리스트추가
			}
		}//for e
		console.log(searchlist)
		datalist = searchlist;	//검색된 약국 리스트 대입
	}
	else if(search == ' '){getdata()}
	
	let html = '<th>약국명</th>	<th>전화번호</th>	<th>주소</th>';
	
	console.log(datalist)
	
	for(let i = 0 ; i <datalist.length ; i++){
				let data = datalist[i]	//i번째 약국을 임시변수에 담는다
				
				html += '<tr onclick="mapview('+i+')">'+		//출저에서 필드명 확이해서 가져오기
						'<td>'+data.약국명+'</td><td>'+data.대표전화+'</td><td>'+data.주소+'</td>'+
						'</tr>';
			}
			
			document.querySelector('.apitable2').innerHTML = html //누적하면 안됨(하나만 검색함)
 }
 //////////////////////////////////*카카오지도 api*//////////////////////////////////////////
 function mapview(i){
	
	 //2. 지도 옵션
	 var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 					//
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨	[1~14]숫자가 작을수록 확대 크면 축소
	    };
	
	// 3.지도를 표시할 div와  지도 옵션으로  지도를 *생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	 /////////////////////////////////////////////////////////////////////
	 // 주소-좌표 변환 객체를 생성합니다
 	var geocoder = new kakao.maps.services.Geocoder();

 
	// 주소로 좌표를 검색합니다		[클릭한 i번쨰의 약국주소]
	geocoder.addressSearch(datalist[i].주소, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {
		//검색된 좌표 객체생성
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,	//해당 마커를 표시할 map객체
            position: coords	//마커 좌표대입
        });
        
        // 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', function() {
		      // 마커 위에 인포윈도우를 표시합니다
		      detailview(i)
		});
        
        // 인포윈도우로 장소에 대한 설명을 표시합니다[마커의 말풍선(설명)]
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+datalist[i].약국명+'</div>'
        });
        infowindow.open(map, marker);
        
        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
		}
	})
}
 function detailview(i){
	let html = '<div>'+datalist[i].약국명+'</div>'+
				'<div>'+datalist[i].주소+'</div>'+	
				'<div>'+datalist[i].대표전화+'</div>'+
				'<div><button>평점주기</button></div>'+
				'<div><button>문의하기</button></div>';
				
	document.querySelector('.detailbox').innerHTML = html
}
 getdata2()	//함수만들면 꼭 다시 불러오기
 function getdata2(){
	$.ajax({
		url : "/jspweb/board/api2",
		success : function(re){
			let json = JSON.parse(re)
			console.log(json)
			
			for(let i = 0 ; i < json.length ; i++){
				console.log(json)
				let data = json[i];
				let html = '';
				 html += '<tr>'+
						'<th>'+data.시군구+'</th>'+
						'<th>'+data.번지본번부번+'</th>'+
						'<th>'+data.단지명+'</th>'+
						'<th>'+data.전용면적+'</th>'+
						'<th>'+data.계약년월+'</th>'+
						'<th>'+data.계약일+'</th>'+
						'<th>'+data.거래금액+'</th>'+
						'<th>'+data.층+'</th>'+
						'<th>'+data.건축년도+'</th>'+
						'<th>'+data.도로명+'</th>'+
						'<th>'+data.해체사유발생일+'</th>'+
						'<th>'+data.거래유형+'</th>'+
						'<th>'+data.중개사소재지+'</th>'+
						'</tr>';
					console.log(data)
				document.querySelector('.apitable1').innerHTML += html
				console.log(html)
			}
			
		}
	})
}