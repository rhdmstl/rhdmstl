package level_test2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level2_7 {
	public static void main(String[] args) {
		System.out.println(" >> Level2_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		while(true) {
			System.out.print("배수 입력 :"); int input = scanner.nextInt();
		/* 문제풀이 위치 */
			for(int i = 1 ; i <=100; i++) {
				if(i%input == 0) {
					System.out.println(i+" ");
				}
			}
		/* ----------- */
		}
	}
}
/* 
[문제] 다음과 같이 배수를 무한입력을 받아 1~100 사이의 입력받은 배수 만 출력하시오.
[조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.
*/