package level_test2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level2_8 {
	public static void main(String[] args) {
		System.out.println(" >> Level2_8 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
	
		/* 문제풀이 위치 */
		int[] i;
		int s;
		int sum = 0;
		int total = 0;
		
		while(true) {
			System.out.print("input : ");
			s = scanner.nextInt();
			if(s==-1) break;{
			sum=sum+s;
			
			for(int j=1; j<=sum; j++) {
				System.out.print("■ ");
			}
			System.out.println();
			} 
			
			if(sum < 0) {
				s = scanner.nextInt();
				break;
			}
			
		}
		/* ----------- */

	}
}
/* 
[문제] 그림과 같이 계속입력한 수에 따라 누적으로 저장되어 저장된 수 만큼 ■ 를 출력하시오.
[조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.
	2. 만약에 누적값이 0 보다 작으면 종료됩니다.
*/