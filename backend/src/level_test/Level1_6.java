package level_test;

public class Level1_6 {
	public static void main(String[] args) {
		System.out.println(" >> Level1_6 answer >> \n");
		
		
		short value1 = 30000;	
		byte a = (byte)value1;
		System.out.println("short -> byte: "+a);

		int value2 = 2000000000;
		short b = (short)value2;
		System.out.println("int -> short: "+b);

		long value3 = 40000000000L;	
		int c = (int)value3;
		System.out.println("long -> float: "+c);

		float value4 = 3.123123123F;
		long d =  (long)value4;
		System.out.println("float -> long: "+d);
		
		double value5 = 3.123123123;
		float e = (float)value5;
		System.out.println("double -> float: "+e);
		/* 문제풀이 위치 */
		
		/* ----------- */
	}
}
/* 
[문제] 그림과 같이 기본자료형을 이용하여 변수 5개 선언되어 있습니다. 그림과 같이 강제 형변환을 하여 출력하시오.
[조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.
	2. 강제 형변환 만 사용하여 그림과 같이 출력합니다.
	
*/