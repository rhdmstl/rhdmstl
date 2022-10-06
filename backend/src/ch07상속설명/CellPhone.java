package ch07상속설명;

public class CellPhone {
	// 1.필드
		String model;
		String color;
		// 2.생성자 
			// [ 기본생성자 : 생성자 1개도 없을때 자동으로 선언되는 생성자 = 빈생성자 ]
			// 만일 빈생성자가 아닌 다른 생성자를 선언했으면 기본생성자는 자동선언이 안된다.
		// 3.메소드
		void powerOn() { System.out.println("전원을 켭니다.");}
		void powerOff() { System.out.println("전원을 끕니다.");}
		void bell() { System.out.println("벨이 울립니다.");}
		void sendVoice(String message) { System.out.println("자기 : " + message );}
		void receiveVoice(String message) { System.out.println("상대방 : " + message );}
		void hangUp() { System.out.println("전화를 끊습니다."); }
}
