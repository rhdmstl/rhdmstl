package ch12;

public class EX3_동기화 {
	public static void main(String[] args) {
		계산기 my계산기 = new 계산기();
		
		사람1 user1 = new 사람1();
		user1.set계산기(my계산기);
		user1.start();
		
		사람2 user2 = new 사람2();
		user2.set계산기(my계산기);
		user2.start();
	}
}
/*
	계산기라는 객체 1개 
	사용자가 2개 
	synchronized 대기 검 싱글스레드는 사용안함
*/
