package EX5;

public class Car {//239
	
	//목적		:반복적인 코트,식별용[내부필드와 매개변수]
	//this.필드명 	:현재 클래스의 필드 호출
	//this( )		:현재 클래스의 생성자 호출
	//this.메소드명	:현재 클래스의 메소드 호출
	
	//필드
	String cpmpany = "현대자동차";
	String modle;
	String color;
	int maxspeed;
	
	//생성자
		//오버로딩 : 동일한 이름으로 선언[매개변수에 따라 구별]
		//생성자에서 사용되는 매개변수명은 필드명과 동일하게 작성
		//1.빈생성자 : 매개변수가 없는 생성자[기본생성자]
	Car(){}
		//2.매개변수가 1개인 생성자
	Car(String model){this.modle = model;
		}
		//3.매개변수가 2개인 생성자
	Car(String modle , String color){
		this(modle,color,5000);
	}
		//4.매개변수가 3개인 생성자
	Car(String modle , String color , int maxspeed){}
}
//반복적인 코드를 줄일 수 있음