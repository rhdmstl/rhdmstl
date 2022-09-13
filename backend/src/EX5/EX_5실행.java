package EX5;

public class EX_5실행 {
	public static void main(String[] args) {
		//객체선언
		Car car1 = new Car();
		
		//매개변수 1개인 객체 선언
		Car car2 = new Car("자가용");
		
		//매개변수 2개인 객체 선언
		Car car3 = new Car("자가용","빨강");
		
		//매개변수가 3개인 객체선언
		Car car4 = new Car("택시","검정",200);
	}
}
