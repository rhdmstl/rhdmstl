package ch8;

import java.util.Scanner;

public class EX_2실행 {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		게임패드 gpad;	//인터페이스 변수
		
		while(true) {
			System.out.println("1.축구게임 2. 비행기게임");
			int ch = scanner.nextInt();
			if(ch == 1) {gpad = new 축구게임();//인터페이스 구현객체에 주소대입
			System.out.println("축구게임 시작");	게임스타드(gpad);}
			else if (ch == 2 ) {gpad = new 비행기게임(); 
			System.out.println("비행기게임 시작");	게임스타드(gpad);}
		}
	}

	public static void 게임스타드(게임패드 gpad) {
		while(true) {
			char 버튼 = scanner.next().charAt(0);
			if(버튼 == 'A') {gpad.A번튼();}
			if(버튼 == 'B') {gpad.A번튼();}
			if(버튼 == 'C') {gpad.A번튼();}
			if(버튼 == 'E') {return;}
		}
	}
}   


	
