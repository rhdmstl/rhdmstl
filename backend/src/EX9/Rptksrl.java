package EX9;

public class Rptksrl {
	
	//반환과 매개변수가 없는함수
	void powerOn() {
		//함수 종료되면서 반환값 없다
		System.out.println("전원을 켭니다");
		return;
	}//void e
	
	//반환하는 매개변수가 2개인 함수
	int plse(int x,int y) {
		int result = x+y;
		return result;
	}//int e
	
	//반환하는 매개변수 2개인 함수
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}//double e
	
	//반환없고 매개변수 없는 함수
	void powerOff() {
		System.out.println("전원을 끕니다"); return;
	}//void e
	
}//class e
