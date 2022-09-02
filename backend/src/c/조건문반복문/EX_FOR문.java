package c.조건문반복문;

public class EX_FOR문 {
	public static void main(String[] args) {
		//154p 1~10까지 출력
		for(int i = 1 ; i <=10 ; i++) {
			System.out.println(i);
		}
		
		int i = 1 ;
		while( i <= 10 ) {
			System.out.println(i);
			i++;
		}	
		int 합계1 = 0;          
		for( int j = 1 ; j <= 10 ; j ++) {
			합계1 += j;
		}
		
		int 합계3 = 0;
		int h = 1;
		while(h<=10) {
			합계3 += h;
			h++;
		}
		System.out.println("1결과 : " + 합계1);
		System.out.println("1결과 : " + 합계3);
		//---------------------------------------------------------
		//예제3) 1부터 100까ㅣ 7배수의 누적합계
		int 예제3합계 = 0;
		for(int x = 1 ; x <= 100 ; x++) {
			if( x % 7 == 0 ) 예제3합계 += x;
		}
		System.out.println("예제3 결과 : " + 예제3합계);
		//2.
		int 예제3합계2 = 0;
		for(int x = 0 ; x<=100 ; x+=7) {
			예제3합계2 += x;
		}
		System.out.println("예제3 결과 : " + 예제3합계2);
		
		//-----------------------------------------------------
		//예제4)2단
		for(int 곱 = 1 ; 곱 <= 9 ; 곱++) {
			int 연산결과 = 2*곱;
			System.out.println("2 x "+곱+ " = " + 연산결과);
		}
		//3.
		int 곱2 = 1;
		while(곱2 <= 9) {
			int 연산결과 = 2*곱2;
			System.out.println("2 x "+곱2+ " = " + 연산결과);
			곱2++;
		}
		//------------------------------------------------
		//구구단
		int 실행횟수 = 0;
		for(int 단 = 2 ; 단 <=9 ; 단++) {
			//단 2부텅 9까지 1씩 증가
			for(int 곱 = 1 ; 곱 <=9 ; 곱++) {
				System.out.printf("%2d X %2d = %2d \n", 단 , 곱 , (단*곱));
				실행횟수++;
			}
		}
		/*System.out.println("총 반복횟수 ; " + 실행횟수);
		
		//2.무한루프 = 무한반복
		for(int y = 0 ; true ; y++) {
			System.out.println("실행");
		}*/
		//-----------------------------------------
		
	}
}
