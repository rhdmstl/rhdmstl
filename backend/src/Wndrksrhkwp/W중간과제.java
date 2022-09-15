package Wndrksrhkwp;

import java.util.Random;
import java.util.Scanner;

public class W중간과제 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int result;//사용자가 입력한 값
		int num1;//구구단 난수
		int num2;//구구단 난수
		int score = 0;//점수
		
		
		System.out.println("구구단을 외자~");
		
		
			for(int i = 0 ; i < 5 ; i++) {//문제 5번씩 생성
				
			num1 = random.nextInt(8)+1;	//난수생성
			num2 = random.nextInt(8)+1;
			
			System.out.println(num1+ "x"+num2+"=");	result = scanner.nextInt();
			
			if( result == num1*num2 ) {//사용자가 입력한 값과 답이 같을때
				System.out.println("정답~ +1" );
				score += 1;
			}else{result = num1*num2; 
				System.out.println("땡!! 정답은"+result+"이지롱~");
			}
			
			}//for e	
			//점수 안내와 동시에 게임 종료
			System.out.println("게임 끝~");
			if(score == 5) {
				System.out.println(score+"만점~");
			}else {
				System.out.println("결과는"+score+"점 깝!");
			}
		
	}//main e
}//class e