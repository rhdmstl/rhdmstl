


let datalist = null; // 선언만 [ 전역변수 : 여러 함수에서 같이 쓸려고 ] 
//////////////////////// 함수 호출 /////////////////////////////
getdata()
/////////////////////// 공공데이터 api 호출 //////////////////////////////

// 1. 공공데이터 호출 함수
function getdata(){

$.ajax({
   url : '/jspweb/board/api',
   success : function(re){
      let json = JSON.parse(re);    console.log(json) // 객체중 data 속성 [키,필드]호출 // 약국 리스트
      datalist = json.data;       console.log(datalist)    
      dataprint() 
      }
})
}
      
// 2. 검색 버튼을 눌렀을때 함수      
function addrsearch(){
   let addr = document.querySelector('.addrinput').value
   dataprint(addr)
   
}      
// 3. html에 약국리스트 출력 함수
function dataprint( search ){ // search : 검색어
      
         // undefined vs "undefined"         // "null" , ""
      if(search !== undefined){ // 검색이 있을경우
         let searchlist = []   // [검색된] 약국리스트 선언
         for( let i = 0 ; i<datalist.length ; i++ ){
            let addr = datalist[i].주소
            console.log(addr)
            if( addr.indexOf(search) !== -1 ){ // 입력한 검색어가 포함되어 있으면
               searchlist.push( datalist[i] )   // 리스트 추가
            }
         }// for end
         
         console.log(searchlist)
         datalist = searchlist; // 약국리스트를 [검색된] 약국리스트 대입
      
         if (search == ''){ alert('공백검색'); getdata(); } // 만약에 검색 키워드에 입력값이 없으면 초기화
      } // 검색 if end
      
      let html = '<tr><th> 약국명 </th> <th> 전화번호 </th> <th> 주소 </th></tr>';
   
      for(let i =  0 ; i<datalist.length ; i++ ){ // 약국 하나씩 호출
         let data = datalist[i] // i번째 약국 임시 변수
         html += '<tr onclick="mapview('+i+')">'+    // 해당 행 클릭시 map 메소드 실행 [ 클릭한 인덱스 매개변수 전달 ]
                  '<td>'+data.약국명+'</td><td>'+data.대표전화+'</td><td>'+data.주소+'</td>'+
               '</tr>';
         
      }// for end
      document.querySelector('.apitable2').innerHTML = html ;
}
      
// 주소-좌표 변환 객체를 생성합니다
//////////////////////// 카카오 지도 API /////////////////////////
function mapview(i){
   
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨 [ 숫자가 적으면 확대 클수록 축소 ]
    };

// 2. 지도 옵션 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
   var map = new kakao.maps.Map(mapContainer, mapOption); 

   
   // 주소로 좌표를 검색합니다 [ 클릭한 i번째 약국의 주소 ]
   var geocoder = new kakao.maps.services.Geocoder();
   geocoder.addressSearch( datalist[i].주소 , function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {
      console.log(result[0].y)
      console.log(result[0].x)
      
      // 좌표 : 주소로 검색된 좌표 생성객체
      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
      
      // 마커 : 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,         // 해당 마커를 표시할 map 객체 대입
            position: coords   // 마커 좌표 대입
        });
        
        // 마커 이벤트
        
        // 마커에 클릭이벤트를 등록합니다
      kakao.maps.event.addListener(marker, 'click', function() {
         // 마커 위에 인포윈도우를 표시합니다
         detailview(i)
      });
        // 인포윈도우 : 마커의 설명[말풍선]달기
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
            '<div><button>평점주기</button></div>'   +
            '<div><button>문의하기</button></div>'   
   document.querySelector('.datailbox').innerHTML = html;
      
}      

////////////////////////////////////////////////////////////
getdata2()
function getdata2(){
   
   $.ajax({
      url : '/jspweb/board/api2',
      success : function(re){ 
      let json = JSON.parse(re);
         console.log(json)
         // 해당 테이블에 부동산 정보 출력
      
      
      let html = ''
      for(let i = 0 ; i<json.length ; i ++){   
       html += '<tr>'+
         '<th> '+json[i].시군구+' </th>'+
         '<th> '+json[i].번지본번부번+' </th>'+
         '<th> '+json[i].단지명+' </th>'+
         '<th> '+json[i].전용면적+' </th>'+
         '<th> '+json[i].계약년월+' </th>'+
         '<th> '+json[i].계약일+' </th>'+
         '<th> '+json[i].계약금액+' </th>'+
         '<th> '+json[i].층+' </th>'+
         '<th> '+json[i].건축년도+' </th>'+
         '<th> '+json[i].도로명+' </th>'+
         '<th> '+json[i].해제사유발생일+' </th>'+
         '<th> '+json[i].거래유형+' </th>'+
         '<th> '+json[i].중개사소재지+' </th>'+
      '</tr>'   
      } // for end
      document.querySelector('.apitable1').innerHTML += html;
      console.log(html)
         
      }
      
   })
}
      
   
   
      