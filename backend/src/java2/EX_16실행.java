package java2;

public class EX_16실행 {
	public static void main(String[] args) {
		//객체선언[클래스명 객체명 = new 생성자();
		Singleten s3 = Singleten.getInstance();
		Singleten s4 = Singleten.getInstance();
		
		if(s3 == s4) {
			System.out.println("주소값이 같다");
		}else{
			System.out.println("다르다");
		}
	}
}
