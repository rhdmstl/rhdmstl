package level_test;

import java.time.LocalDateTime;
import java.util.Scanner;

public class level1_7 {
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println("answer time : " + LocalDateTime.now()+">>\n");
		Scanner scanner = new Scanner(System.in);
		
		
		String output = "";
		
		System.out.println("회원명 string : "+ output);	String name = scanner.next();
		
		System.out.println("상태 boolean : "+ output);	boolean con = scanner.nextBoolean();
	
		System.out.println("회원번호 byte : "+ output);	byte no = scanner.nextByte();

		System.out.println("성별 char : "+ output);	char gen = scanner.next().charAt(0);

		System.out.println("나이 short : "+ output);	short age = scanner.nextShort();
		
		System.out.println("포인트 int : "+ output);	int po = scanner.nextInt();
		
		System.out.println("예금액 long : "+ output);	long mo = scanner.nextLong();
		
		System.out.println("키 float : "+ output);	float lo = scanner.nextFloat();
		
		System.out.println("몸무게 double : "+ output);	double kg = scanner.nextDouble();

		System.out.println("=====회원 개인정보=====");
		System.out.println("|\t회원명 : "+name+"\t\t|");
		System.out.println("|\t상태 : "+con+"\t\t|");
		System.out.println("|\t회원 번호 : "+no+"\t\t|");
		System.out.println("|\t성 별 : " +gen+"\t\t|");
		System.out.println("|\t나 이 : " +age+"\t\t|");
		System.out.println("|\t포인트 : "+po+"\t\t|");
		System.out.println("|\t예금액 : "+mo+"\t\t|");
		System.out.println("|\t키 : "+lo+"\t\t|");
		System.out.println("|\t몸무게 : "+kg+"\t\t|");
		System.out.println("==================");
	}
}
/* 
[문제조건] 
	1. 문제풀이 위치 외 코드는 수정 불가 합니다.
	2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
	3. 입력받은 9개 변수를 그림과 같이 출력합니다.
	4. 기존에 미리 작성된 변수를 최대한 활용합니다.
	
*/