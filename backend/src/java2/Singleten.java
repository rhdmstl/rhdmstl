package java2;

public class Singleten {
	private static Singleten s1 = new Singleten();
	//싱글톤 : 객체 한개만 선언 가능한클래스
		//방법: 외부에서 생성자를 못씀
		//접근제한자 : private 현재클래스만 접근가능
		//public : 프로젝트 어디서든 호출 가능
		//2.필드에 정적객체 선언
	private Singleten() {
		
	}
	public static Singleten getInstance() {
		return s1;
	}
}
