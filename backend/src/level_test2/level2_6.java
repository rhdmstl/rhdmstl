package level_test2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level2_6 {
	public static void main(String[] args) {
		System.out.println(" >> Level2_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		
		/* 문제풀이 위치 */
		
		while(true) {
			String loop = scanner.next();
			if(loop.equals("end")) {
				break;
			}
		}
		/* ----------- */

	}
}
/* 
[문제] 그림과 같이 무한 입력 받다가 end 입력시 종료되는 반복문을 구현하시오.
[조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.

	
*/