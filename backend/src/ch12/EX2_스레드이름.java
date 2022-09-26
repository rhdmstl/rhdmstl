package ch12;

public class EX2_스레드이름 {
	public static void main(String[] args) {
		//1
		Thread 메인스레드 = Thread.currentThread();
		System.out.println("main함에 있는 스레드 이름 : " + 메인스레드.getName());
		//2
		스레드A 스레드a = new 스레드A();
		스레드a.start();
		//4
		스레드B 스레드b = new 스레드B();
		스레드b.start();
	
	
	}
}
/*
 	run(스레드가 실행할 코드)
 	start		멀티작업할 코드 정의
 	setName		run메소드 실행
 	
 	
 	
 	
 */
