package EX4;

import java.security.PublicKey;

public class Korean {
	
		//필드
		String nation = "대한민국";
			//클래스 내부에 미리 초기화 -> 객체 생성시 대한민국으로 초기화
		String name;
		String ssn;
		
		//매개변수가 있는 생성자
		Korean(String n , String s){
			name = n;
			ssn = s;
		}
		//매개변수사 없는 생성자
		 Korean() {}
	
}
