package EX8;

public class Member {
		
	//2.생성자 : 객체 생성시 초기값 필드의 처음값 설정
		//생성자가 하나도 정의하지 않으면 기본생성자 자동추가
		//클래스명 이름 동일
		//매개변수 개수에 따라 오버로딩[여러개사용]
		//1.빈생성자 [매개변수X] : 기본생성자
	
	
		String id;
		String password;
		String name;
		
		Member(){}
		
		Member(String id){this.id = id;}
		
		Member(String id , String password){this.id = id; this.password = password;}
		
		public Member(String id, String password, String name) {
			this.id = id;
			this.password = password;
			this.name = name;
		}

		
		
		
}
