package level_test;

import java.time.LocalDateTime;

public class level1_2 {
	public static void main(String[] args) {
		System.out.println(" >> Level1_2 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		System.out.printf("%-10s   %15s   %30s\n" , "type" , "value" , "range" );
		System.out.println("-------------------------------------------------------------");
		/* 문제풀이 위치 */
		boolean boo = true;		System.out.printf("boolean\t\t\t\t\t"+boo+"\t\t\t\t\ttrue or false\n");
		byte by = 100;			System.out.printf("byte\t\t\t\t\t "+by+"\t\t\t\t\t\t -128~127\n");
		char ch = 'A';			System.out.printf("char\t\t\t\t\t   "+ch+"\t\t\t 0~65535[character 1]\n");
		short sh = 30000;		System.out.printf("shor\t\t\t\t   "+sh+"\t\t\t\t\t -32768~32767\n");
		int in = 2000000000;	System.out.printf("int\t\t\t\t  "+in+"\t\t\t\t   -+2000 million\n");
		long lo = 40000000000L; System.out.printf("long\t\t\t "+lo+"\t\t\t-+2000 million Excess\n");
		float fl = 3.1231232f;	System.out.printf("float\t\t\t   "+fl+"\t\t\t\t 8 decimal places\n");
		double do1 = 3.123123123; System.out.printf("double\t\t\t "+do1+"\t\t\t\t17 decimal places\n");
	
		/* ----------- */
	}
}
/* 
[문제] 그림과 같이 기본자료형을 이용하여 변수 8개 선언하고 임의값을 대입하여 출력하시오.
[조건] 
	1. 모든 기본자료형 8개 사용
	2. printf() 메소드 사용
*/