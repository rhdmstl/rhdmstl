package EX2;

public class EX_2실행 {
	public static void main(String[] args) {
		//객체선언
				Car myCar = new Car();
					//1.Car		:클래스명
					//2.myCar	:객체명[임의]
					//3.new		:객체 선언시 사용되는 키워드
					//4.Car()	:객체 선언시 초기값 담당
				
				//2.필드호출
					//1.	.(점) 연산자를 이용한 멤버호출
				System.out.println("제작회사 : "+ myCar.company);
				System.out.println("모델명 : "+ myCar.modle);
				System.out.println("색깔 : "+myCar.color);
				System.out.println("최고속도 : "+myCar.maxSpeed);
				System.out.println("현재속도 : "+myCar.speed);
				
				//3.필드값 변경[객체명.필드명 = 새로운값]
				myCar.speed = 60;
				System.out.println("수정된 현재속도 : " + myCar.speed);
	}
}
