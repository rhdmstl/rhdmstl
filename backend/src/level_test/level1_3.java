package level_test;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level1_3 {
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		
		
		System.out.print("input boolean:");
		boolean dd = scanner.nextBoolean();
		
		System.out.print("input byte:");
		byte by = scanner.nextByte();
		
		System.out.print("input char:");
		char ch = scanner.next().charAt(0);
		
		System.out.print("input short:");
		short sh = scanner.nextShort();
		
		System.out.print("input int:");
		int in = scanner.nextInt();
		
		System.out.print("input long:");
		long lo = scanner.nextLong();
		
		System.out.print("input float:");
		float fl = scanner.nextFloat();
		
		System.out.print("input double:");
		double ddd = scanner.nextDouble();
		
		System.out.print("output boolean:"+dd);
		System.out.print("output byte:"+by);
		System.out.print("output char:"+ch);
		System.out.print("output short:"+sh);
		System.out.print("output int:"+in);
		System.out.print("output long:"+lo);
		System.out.print("output float:"+fl);
		System.out.print("output double:"+ddd);
	}
}
/* 
[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
[조건] 
	1. 모든 기본자료형 8개 사용
	2. print() 메소드 사용
	3. scanner 객체 사용하여 입력받기
*/
