package level_test2;

import ch12.스레드A;

public class level2_9스레드 {
	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		
		스레드A 스레드a = new 스레드A();
		스레드a.start();
				
	}
}
