package ch8;

public class Bus implements Vehicle{
	@Override
	public void run() {System.out.println("버스기 달립니다");}
	
	public void checkfare() {
		System.out.println("승차요금 체크합니다");
	}
}
