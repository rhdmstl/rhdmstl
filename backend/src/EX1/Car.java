package EX1;

public class Car {
	//클래스 설계도 변수와 메소드 선언만함
	//필드
	int gas;
	
	
	void setGas(int gas) {
		this.gas = gas;
		return;
	}
	
	//반환값 boolean 매개변수 X
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다");
			return false;
		}else {
			System.out.println("gas가 있습니다");
			return true;
		}//else e
	}//boolean e
	
	void run() {
		while(true) {
			if(gas > 0 ) {
				System.out.println("달립니다[gas잔량 : " +gas+"]");
				gas -= 1;//gas 감소
			}else {
				System.out.println("멈춥니다[gas잔량 : " +gas+"]");
				return;
			}
		}//while e
		//while 이후에 코드가 존재하지않기때문에 브레이크도 가능
	}//void e
}
