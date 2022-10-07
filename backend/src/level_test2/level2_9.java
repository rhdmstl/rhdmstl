package level_test2;

import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import ch12.Beep_test;

public class level2_9 {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int result;//사용자가 입력한 값
		int score = 0;//점수 
				
		System.out.println("구구단을 외자~");
		
		while(true) {
			System.out.println("난이도 선택 : 1.초급 2.중급 3.고급"); 
			int ch = scanner.nextInt();
			
			if(ch == 1) {
				for(int i = 0 ; i < 5 ; i++) {//문제 5번씩 생성
					
							int[] num1 = new int[9];//구구단 난수
							int[] num2 = new int[9];//구구단 난수
							
							num1[0]=(int)(Math.random()*10+1);
							num2[0]=(int)(Math.random()*10+1);
							
							System.out.println(num1[0]+ "x"+num2[0]+"=");	result = scanner.nextInt();
						
							if( result == num1[0]*num2[0] ) {//사용자가 입력한 값과 답이 같을때
								System.out.println("정답~ +1" );
								score += 1;
							}else { result = num1[0]*num2[0];
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
				}//초급 e
			if(ch == 2) {
				for(int i = 0 ; i < 10 ; i++) {//문제 5번씩 생성 중급
					
					int[] num1 = new int[9];//구구단 난수
					int[] num2 = new int[9];//구구단 난수
					
					num1[0]=(int)(Math.random()*(22-10)+10);
					num2[0]=(int)(Math.random()*10+1);
					
					System.out.println(num1[0]+ "x"+num2[0]+"=");	result = scanner.nextInt();
					
					if( result == num1[0]*num2[0] ) {//사용자가 입력한 값과 답이 같을때
						System.out.println("정답~ +1" );
						score += 1;
					}else { result = num1[0]*num2[0];
						System.out.println("땡!! 정답은"+result+"이지롱~");
					}
					}//for e	
					//점수 안내와 동시에 게임 종료
					System.out.println("게임 끝~");
					if(score == 10) {
						System.out.println(score+"점 만점~");
					}else {
						System.out.println("결과는"+score+"점 깝!");
					}
			}//중급if e
			if(ch == 3) {
				for(int i = 0 ; i < 15 ; i++) {//문제 5번씩 생성
					
					int[] num1 = new int[9];//구구단 난수
					int[] num2 = new int[9];//구구단 난수
					
					num1[0]=(int)(Math.random()*(30-10)+10);
					num2[0]=(int)(Math.random()*(30-10)+10);
					
					System.out.println(num1[0]+ "x"+num2[0]+"=");	result = scanner.nextInt();
					
					if( result == num1[0]*num2[0] ) {//사용자가 입력한 값과 답이 같을때
						System.out.println("정답~ +1" );
						score += 1;
					}else { result = num1[0]*num2[0];
						System.out.println("땡!! 정답은"+result+"이지롱~");
					}
					
					}//for e	
					//점수 안내와 동시에 게임 종료
					System.out.println("게임 끝~");
					if(score == 15) {
						System.out.println(score+"점 만점~");
					}else {
						System.out.println("결과는"+score+"점 깝!");
					}
			}//고급if e
		}//while e
	}//main e
}
