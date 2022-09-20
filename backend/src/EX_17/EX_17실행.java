package EX_17;

public class EX_17실행 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("123456-1234567","홍길동");
		
		//p2.natin = "USA";	//오류 : final는 수정불가
		//p2.ssn = "123456-1234567";
		p2.name = "홍삼원";
	}
}
