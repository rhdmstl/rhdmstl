package java1;

import java.util.Scanner;

public class EX_연습 {
	public static void main(String[] args) {
		//안보고
		int 변수 = 123;
		System.out.println(변수 +"원");
		System.out.printf("%d원" , 변수);
		
		
		System.out.printf("상품의 가격 : %2d원" , 변수);
		System.out.printf("상품의 가격 : %6d원" , 변수);
		System.out.printf("상품의 가격 : %-6d원" , 변수);
		System.out.printf("상품의 가격 : %06d원" , 변수);
		
		double area = 3.14159*10*10;
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n",10,area );
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n" , 1 , name , job);
		
		Scanner 입력객체 = new Scanner(System.in);
		
		int 입력정수 = 입력객체.nextInt();
		System.out.println("입력받은 객체 : " + 입력정수);
		
		String 입력문자열 = 입력객체.next();
		System.out.println("입력 문자열 :" + 입력문자열);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 : ");
		String 이름 = scanner.next();
		System.out.println("나이 :");
		int 나이 = scanner.nextInt();
		System.out.println("키 :");
		double 키 = scanner.nextDouble();
		
		
	}//main e
}//class e
/*
	system.out : 출력
	system.in : 입력
	
	형식문자
		1. %d :정수
			%자리수d : 오른쪽부터 자리수만큼 자리 차지[만약에 숫자가 없을 경우 공백채움
			%0자리수d : 오른쪽부터 자리수만큼 자리 차지[만약에 숫자가 없을 경우 0채움
			%-자리수d : 왼쪽부터 ~
		2.%f : 실수 
			%자리수.소수점자리f
			%10.2f : 10자리의 자리 차지 소수점 2자리 표시
		3.%s : 문자열
 		
 
 
 
 */
