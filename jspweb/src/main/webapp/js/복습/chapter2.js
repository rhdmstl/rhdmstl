/**
 * 	typeof(데이터) : 해당 데이터의 자료형 확인
 	상수 : 고정값	const
 	변수 : 변하는 수 let
 	undefined : 없음
 	자료형변화
 		Number(데이터) : 숫자형 변환
 		String(데이터) : 문자열 변환
 		boolean(데이터) : 불형 변환
 		
 */
 //88p
 console.log('abcd');
 console.log('abcd'+'efg');
 console.log('abcd'.length);
 console.log(273);
 console.log(273.275);
 
 //102p(107p참고)
 const pi = 3.141592
 console.log(pi);
 
 let pi2 = 3.141592
 console.log(pi2);
 pi2 = 4.14
 
 prompt('ddd')
 confirm('ddd')
 
 
 //지폐세기
 //조건 금액 입력받아 출력하기 console()
 //십만,만원,천원,백원까지
 //parseInt 소수점 잘라줌 = 정수
 let money = prompt('입력받은 돈');
 console.log("안내) 입력받은 금액 : " + money + "원");
 console.log("십만원" + parseInt(money/100000)+"장");
 	money -= parseInt(money/100000)*100000;
 console.log("만원"+parseInt(money/10000)+"장");
 	money -= parseInt(money/10000)*10000;
 console.log("천원"+parseInt(money/1000)+"장");
 	money -= parseInt(money/1000)*1000;
 console.log("백원"+parseInt(money/100)+"개");
 	money -= parseInt(money/100)*100
 
 let 금액 = Number(prompt("금액 : "));
 console.log("입력받은 금액 : " + 금액);
 
 let 십만원 = parseInt(금액/100000);
 console.log("십만원 : " + 십만원);
 금액 -= 십만원*100000;		//원 금액에서 십만원권 제거
 
 let 만원 = parseInt(금액/10000);
 console.log("만원 : " + 만원);
 금액 -= 만원*10000;
 
 let 천원 = parseInt(금액/1000);
 console.log("천원 : "+만원);
 금액 -= 천원/1000;
 
 let 백원 = parseInt(금액/100);
 console/log("천원 : " + 천원);
 금액 -= 천원/1000;
 
 let 정수1 = Number(prompt("정수1 : "));
 console.log("홀수 여부" + (정수1%2===1));
 
 let 정수2 = Number(prompt("정수2 : "));
 console.log("배수 여부" + (정수2%7===0));
 
 
 