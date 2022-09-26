package ch12;

import java.awt.Toolkit;

public class Beep_test implements Runnable{//구현객체
						//중복 상속 가능(구현 여러번 가능)
						//implements : 구현[추상->구현]
						//Runnable : 스레드 인터페이스
	
	//필드
	
	//생성자
	
	//메소드[멀티스레드 제공 = run]
	@Override
	public void run() {//추가 스레드
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : java ui제공 console
		for(int i = 0 ; i< 10 ; i++) {
		toolkit.beep();	//소리함수	
		try {Thread.sleep(500);} 
		catch (InterruptedException e) { }	
		//현재 스레드를 밀리초만큼 일시정지
		}//소리의 속도보다 반복문 속도가 더 빨라서 소리가 한번밖에 안남
	}
}
