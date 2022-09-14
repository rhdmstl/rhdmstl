package EX1;

public class EX_10실행 {
	public static void main(String[] args) {
		//객체선언
		Car myCar = new Car();
		
		//객체 메소드 호출
		myCar.setGas(5);//매개변수 5
		
		//객체에 메소드 호출
		boolean gasState = myCar.isLeftGas();
			//매개변수없고 반환은 boolean
		
		//반환값을 저장해서 if문에 적용
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();//매개변수 , 반환 X
		}
		
		//바로 반환타입을 가지고 제어함
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 있습니다");
		}else {
			System.out.println("gas를 주입하세요");
		}
		
	}//main e
}//class e
