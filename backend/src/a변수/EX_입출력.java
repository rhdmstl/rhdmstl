package a변수;

import java.util.Scanner;

public class EX_입출력 {
	public static void main(String[] args) {
		int 변수 = 123;
		System.out.println(변수 + "원");
		System.out.printf("%d원\n" , 변수);
		
		int value = 123;
		System.out.printf("상품의 가격 : %d원\n" , value);
		System.out.printf("상품의 가격 : %6d원\n" , value);
		System.out.printf("상품의 가격 : %-6d원\n" , value);
		System.out.printf("상품의 가격 : %06d원\n" , value);
		
		double area = 3.14159*10*10;//실수
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n" , 10 , area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s\n" , 1 , name ,job);
		
		// 입력 객체(클래스) 선언 
		Scanner 입력객체 = new Scanner(System.in);
		// [객체생성] 클래스명 객체명 = new 생성자();
			// new 객체 선언시 메모리 할당 키워드
		int 입력정수 = 입력객체.nextInt();
		System.out.println("입력받은 정수 : " + 입력정수);
		
		String 입력문자열 = 입력객체.next();
		System.out.println("입력받은 문자열 : " + 입력문자열);
		
		/*-----------------------------------*/
		// 입력예제 ) 
		// 1. 입력받기[ 준비물 : Scanner 클래스로 객체 1개 필요 ]
			// 키보드(System.in) --입력--> 객체 저장 --next()--> 변수 저장 
		// 2. 입력받은 데이터를 변수에 저장
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String 이름 = scanner.next();
		System.out.print("나이 : ");
		int 나이 = scanner.nextInt();
		System.out.println("키 : ");
		double 키 = scanner.nextDouble();
		
	}
}
/*
	System.out : 출력
	System.in : 입력 
	
	형식문자 
		1. %d : 정수
		 	%자리수d	: 오른쪽부터 자리수만큼 자리 차지	[만약에 숫자가 없을경우 공백 채움 ]
			%0자리수d	: 오른쪽부터 자리수만큼 자리 차지 	[만약에 숫자가 없을경우 0 채움 ]
			%-자리수d	: 왼쪽부터 ~~~ 
		
		2. %f : 실수 
			%자리수.소수자리f
			%10.2f : 10자리의 자리 차지 , 소수점 2자리 표시 
	
	3. %s : 문자열 */
