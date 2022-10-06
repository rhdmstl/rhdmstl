package ch07상속설명;

public class EX2_상속 {
public static void main(String[] args) {
		
		// 객체 선언 
		Student student = 
				new Student("홍길동", "123456-1234567", 1);
		
		System.out.println("name : " + student.name);
		System.out.println("ssn : " + student.ssn);
		System.out.println("studentNo : " + student.studentNo);
	}
}
