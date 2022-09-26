package ch12;

import java.awt.Toolkit;

public class EX_스레드 {
	public static void main(String[] args) {//기본스레드
		//싱글스레드  : 소리가 5번 출력되고 문자열 5번 출력
		//525p
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : java ui제공 console
		for(int i = 0 ; i< 10 ; i++) {
		toolkit.beep();	//소리함수	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//현재 스레드를 밀리초만큼 일시정지
		}//소리의 속도보다 반복문 속도가 더 빨라서 소리가 한번밖에 안남
		
		
		for(int i = 0 ; i <5 ; i++){
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//526p 멀티스레드
		System.out.println("딩");
		Runnable beep_test = new Beep_test();
		Thread thread = new Thread(beep_test);
		thread.start();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("딩");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { }
			
		}
		//527p : 익명구현 객체 (1회용)
		Thread thread2 = new Thread(new Runnable() {
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
		}); //이름이 없어서 재호출이 안됌
		thread2.start();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("찜");
			try {Thread.sleep(500);} 
			catch (InterruptedException e) { }
		}
		
		//529p스레드 클래스를 이용한 객체만들기
		BeepThread thread3 = new BeepThread();
		thread3.start();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("띱");
			try {Thread.sleep(500);} 
			catch (InterruptedException e) { }
		}
		
		//530p 클래스명 객체명 = new  생성자() {멤버 재정의} 익명자식객체
		Thread thread4 = new Thread() {public void run() {
			Toolkit toolkit = Toolkit.getDefaultToolkit();	// Toolkit : java ui제공 console
			for(int i = 0 ; i< 10 ; i++) {
			toolkit.beep();	//소리함수	
			try {Thread.sleep(500);} 
			catch (InterruptedException e) { }	
			//현재 스레드를 밀리초만큼 일시정지
			}//소리의 속도보다 반복문 속도가 더 빨라서 소리가 한번밖에 안남
		};};
		thread4.start();
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("짱");
			try {Thread.sleep(500);} 
			catch (InterruptedException e) { }
		}
	}
}

//작업 스레드 생성준비
/*
 	
 */







