package EX9;

import java.util.Scanner;

public class EX_9실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		//객체 생성
		Rptksrl myCalc = new Rptksrl();
		
		//메소드 호출
		myCalc.powerOn();
		
		//메소드호출
		System.out.println(myCalc.plse(5, 6));
		int result = myCalc.plse(5, 6);
			//반환값을 result 에 저장(변수의 자료형이 동일해야함)
		
		System.out.println("result : " + result);
		
		byte x = 10;
		byte y = 4;
		
		double result2 = myCalc.divide(x, y);
		System.out.println("result2 : " + result2);
		
		myCalc.powerOff();
		
		
	}//main e
}//class e
