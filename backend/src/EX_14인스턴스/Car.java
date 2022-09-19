package EX_14인스턴스;

public class Car {
	String modle;		//인스턴스 멤버
	int speed;			//
	
	//2.생성자 : 클래스명과 동일하다
		//ㄱ개체 선언시 객체 필드의 쵝값 설정
		//클래스명 객체명 = new 생성장();
	
	Car(String modle){
		//생성자명(인수){필드초기화}
		this.modle = modle;//[x] 현재 클래스의 modle필드명과 매개변수명이 동이랗 경우 식별안됨
		//
	}
	
	public Car() {}

	public Car(String modle, int speed) {
		super();
		this.modle = modle;
		this.speed = speed;
	}
	void setSpeed(int speed) {this.speed = speed;}
	
	void run(){for(int i = 10 ; i <=50 ; i=10) {
		this.setSpeed(i);
		System.out.println(this.modle+"가 달립니다(시속 : " + this.speed+"km/h");
	}
	}
	
}
