package EX3;

public class EX_3실행 {
	public static void main(String[] args) {
		/*배열	: 동일한 자료형의 데이터를 여러개 저장
			문제점	: int , String , double 등 
					  서로 다른 타입을 하나의 배열 저장 불가능
			보완 -> 클래스 사용 [서로다른 메모리 집합]
					  
		*/
		//1.배열만 사용한 버전
		String[] id = new String[100];
		int[] password = new int[100];
		String[] name = new String[100];
		int[] point = new int[100];
		String[] list = new String[100];
		
		//2.객체와 배열 같이 사용했을때 버전
		Member[] memberlist = new Member[100];
		
	}
}
