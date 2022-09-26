package ch12;

import java.awt.Toolkit;

public class BeepThread extends Thread{	
	//b(부모)클래스의 설계된 메모리를 a클래스에게 물려줌
	//상속 = a클래스 -> b클래스 멤버사용가능(상속 1번만 가능)
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : java ui제공 console
		for(int i = 0 ; i< 10 ; i++) {
		toolkit.beep();	//소리함수	
		try {Thread.sleep(500);} 
		catch (InterruptedException e) { }	
		//현재 스레드를 밀리초만큼 일시정지
		}//소리의 속도보다 반복문 속도가 더 빨라서 소리가 한번밖에 안남
	}

}
