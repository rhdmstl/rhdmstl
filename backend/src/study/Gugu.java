package study;

import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

public class Gugu {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int result;//사용자가 입력한 값
		int num1;//구구단 난수
		int num2;//구구단 난수
		int score = 0;//점수 
				
		System.out.println("구구단을 외자~");
		System.out.println("난이도 선택 : 1.초급 2.중급 3.고급"); 
		
		int ch = scanner.nextInt();
		
		if(ch == 1) {
			for(int i = 0 ; i < 5 ; i++) {//문제 5번씩 생성
				System.out.println( (int) Math.random() * 10 );
				
				num1 = random.nextInt(9)+1;	//난수생성
				num2 = random.nextInt(9)+1;
				
				System.out.println(num1+ "x"+num2+"=");	result = scanner.nextInt();
				
				if( result == num1*num2 ) {//사용자가 입력한 값과 답이 같을때
					System.out.println("정답~ +1" );
					score += 1;
				}else { result = num1*num2;
					System.out.println("땡!! 정답은"+result+"이지롱~");
				}
			
			}//for e	
			//점수 안내와 동시에 게임 종료
			System.out.println("게임 끝~");
			if(score == 5) {
				System.out.println(score+"점 만점~");
			}else {
				System.out.println("결과는"+score+"점 깝!");
			}
		}//if e
		
		if(ch == 2) {
			for(int i = 0 ; i < 5 ; i++) {//문제 5번씩 생성
				
				
					num1 = random.nextInt(22)+1;	//난수생성
					num2 = random.nextInt(22)+1;
				
				System.out.println(num1+ "x"+num2+"=");	result = scanner.nextInt();
				
				if( result == num1*num2 ) {//사용자가 입력한 값과 답이 같을때
					System.out.println("정답~ +1" );
					score += 1;
				}else { result = num1*num2;
					System.out.println("땡!! 정답은"+result+"이지롱~");
				}
				
				}//for e	
				//점수 안내와 동시에 게임 종료
				System.out.println("게임 끝~");
				if(score == 5) {
					System.out.println(score+"점 만점~");
				}else {
					System.out.println("결과는"+score+"점 깝!");
				}
		}//중급if e
	}//main e
}//class e
