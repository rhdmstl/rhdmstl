package ch8;

public class EX_1실행 {
	public static void main(String[] args) {
		
		//객체 != 인터페이스 = 그냥 객체임
		//인터페이스는 *생성자가 없어서 구현클래스가 반드시 있어야함(여러개 조작하기 위함)
		Television tv = new Television();
		
		//인터페이스 구현객체
		//인터페이스 변수명 = new 구현 클래스();
		RemoteControl rc = new Television();
		//RemoteControl rc1;
		
		//인터페이스 변수에 구현객체 대입
		//리모콘에 텔레비전 기능 탑재
		//rc1 = new Television();
		rc = new Television();
		
		//메소드 실행
		//rc1.turnOn();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		System.out.println("TV -> Audio 변경");
		
		//tv -> audio
		//리모콘에 오디오 기능 변경
		rc = new Audio();
		
		//메소드 실행
		rc.turnOn();
		rc.setVolume(2);
		rc.turnOff();
		
		
		System.out.println("audio -> smart TV로 변경됩니다");
		
		//구현객체를 미리 만들어서 이용할 수 있음
		SmartTelevision stv = new SmartTelevision();
		
		rc = new SmartTelevision();
		rc.turnOn();
		rc.turnOff();
		Searchable sc = stv;
		sc.search("11번");
		
		
		
		
	}
}
