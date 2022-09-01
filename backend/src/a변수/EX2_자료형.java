package a변수;

public class EX2_자료형 {//class 시작
	public static void main(String[] args) {//main시작
		//61p
		//1.byte : +-128정도
		byte 바이트변수1 = -128; System.out.println("바이트변수1 :" + 바이트변수1);
		byte 바이트변수2 = 127; System.out.println("바이트변수2 :" + 바이트변수2);
			//byte 바이트변수3 = 128; System.out.println("바이트변수3 :" + 바이트변수3); = 저장범위 초과되서 오류나는게 맞음
		
		//2.char [한글자] : 유니코드
		char 문자변수1 = 65; System.out.println("문자변수1 : "+문자변수1);
		char 문자변수2 = 'A'; System.out.println("문자변수2 : "+문자변수2);
		int 문자변수3 = 'A'; System.out.println("문자변수3 : "+문자변수3);//int 는 문자표현이 안됌
		char 문자변수4 = '가'; System.out.println("문자변수4 : "+문자변수4);
		int 문자변수5 = '가'; System.out.println("문자변수5 : "+문자변수5);//int
		
		//3.short [10진수] : +-3만정도
		short 쇼트변수1 = 30000; System.out.println("쇼트변수1 : "+쇼트변수1);
			//short 쇼트변수2 = 40000; System.out.println("쇼트변수2 : "+쇼트변수4); = 저장범위 초과되서 오류나는게 맞음
		
		//4.int [*정수 기본 자료형] : +-20억정도
		int 인트변수1 = 1000000000; System.out.println("인트변수1 : " + 인트변수1);
			//int 인트변수2 = 3000000000; System.out.println("인트변수2 : " + 인트변수2); = 저장범위 초과되서 오류나는게 맞음
		
		//5.long [ - 입력숫자뒤에 L ] : int이상
		long 롱변수1 = 1000000000; System.out.println("롱변수1 : "+ 롱변수1);
		long 롱변수2 = 3000000000L; System.out.println("롱변수2 : "+ 롱변수2);
		
		
		//.int : 10진수 정수를 저장하는 자료형[상자]
		int var1 = 0b1011;
		System.out.println("2진수[1011--int(10진수)-->1341] : " + var1);
		//2진수를 다른 진수로 변환해서 다양한 표현 단위 사용 => 많은 단위표현가능
		int var2 = 0206;
		System.out.println("8진수[206--int(10진수)-->134 : " + var2);
		int var3 = 365;
		System.out.println("8진수[365--int(10진수)-->365 : " + var3);
		int var4 = 0xb3;
		System.out.println("16진수[b3--int(10진수)-->179 : " + var4);
		
		
	}//main 끝
}//class끝
