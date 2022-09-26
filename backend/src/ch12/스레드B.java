package ch12;

public class 스레드B extends Thread{
	@Override//5
	public void run() {
		for(int i = 0 ; i < 2 ; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	} 
}
