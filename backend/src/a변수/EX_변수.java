package a변수;

public class EX_변수 {
	public static void main(String[] args) {
		//변수 선언
		int value;
		
		value = 10; //변수에 값대입
		System.out.println(value);
		
		int result = value + 10;
		System.out.println(result);
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");
		
		int totalMinute = (hour*60) + minute;
		System.out.println("총 : " + totalMinute + "분");
		
		int x = 3;
		int y = 5;
		System.out.println("x : " + x + ",y : " + y);
		
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x : " + x + ",y : " + y);
	}
}
/*----------------------------------------*/
/*
 
 	변수 선언 
 		1. 자료형 [ 변수의 크기 ]
 		2. 변수명 [ 변수의 이름 ]		----- 번역 ----->  메모리 주소 찾아가기
 		3. 값 [ 변수에 들어있는 데이터 ] 
 		
 		int value = 10
		[1]	 [2]    [3]
		자료형 변수명 = 데이터
	변수 호출 
		변수명
		
컴퓨터[ 0 , 1 ]			본체
							1.CPU				: 관리,감독,제어,번역 등
							2.주기억장치[RAM]		: 저장[변수] : 프로그램 실행시 [ 휘발성 메모리 ]		
							3.보조기억장치[ROM]		: .class코드파일 [ 비휘발성 메모리 ] : DB
							
						메모리[RAM]
int 변수 = 10					0x1f8b1d2	[ 16진수 메모리 주소 ]*/