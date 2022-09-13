package e.클래스;

public class EX1실행 {
	public static void main(String[] args) {
		//클래스 기반으로 객체선언
			//1.class명	: 객체 생성시 사용되는 설계도
			//2.변수명	: 객체 이름으로 사용할 임의로 정하기
			//3.new연산자	: 힙 영역에서 메모리 할당후 주소값을 
			//4.생성자명	: 객체 생성시 초기값 담담[클래스명]
		Student s1 = new Student();
		//1		2  = 3		4
		//스태개영역  = 힙영역
		System.out.println("s1변수가 Student 객체를 참조합니다");
		
		Student s2 = new Student();
		System.out.println("s2변수가 Student 객체를 참조합니다");
		
	}//main e
}//class e
