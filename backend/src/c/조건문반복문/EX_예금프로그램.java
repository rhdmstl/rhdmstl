package c.조건문반복문;

import java.util.Scanner;

public class EX_예금프로그램 {
	public static void main(String[] args) {
		//161p
		
		boolean run = true; //종료하는 스위치 변수
		int balance = 0; //금액을 저장하는 변수
		Scanner scanner = new Scanner(System.in); //입력객체 선언
		//객체 선언 : 클래스명 변수명 = new 생성자명(매개변수)
			//객체마다 변수와 메소드 (함수) 포함=멤바
		while(run) {
			System.out.println("--------------------------");
			System.out.println("1.예금\t2.출금\t3.잔고\t4.종료");
			System.out.println("--------------------------");		
			System.out.println("선택> "); int ch = scanner.nextInt();
			if( ch == 1 ) {
			System.out.println("안내)예금금액>"); balance += scanner.nextInt();	
		}else if( ch == 2 ){
			System.out.println("안내)출금금액>"); balance -= scanner.nextInt();
		}else if(ch == 3 ) {
			System.out.println("안내)잔고>"+ balance); 
		}else if( ch == 4 ) {
			break;
		}else {System.out.println("안내)알수없는 번호입니다");
			
		}
		System.out.println("프로그램 종료");
		}
	}
}
