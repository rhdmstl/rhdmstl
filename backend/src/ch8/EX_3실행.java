package ch8;

public class EX_3실행 {
	public static void main(String[] args) {
		Car car = new Car();
		
		car.run();
		
		//구현객체 교체(자동형변환생김 Car -> EX_3실행올때)
		//스텍이랑 힙이 달라서 다형성이 생김 -> 메모리 효율성이 좋아짐
		car.frontLeftTire = new KumhoTire();
		car.frontRightTire = new HankokTire();
		
		car.run();
		
	}
}
