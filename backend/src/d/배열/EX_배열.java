package d.배열;

public class EX_배열 {
	public static void main(String[] args) {
		//예1)180p
		//1.배열의 선언
		int [] scores = {83 , 90 , 87}; //int형 배열 선언 3개 값 초기화,인덱스 0~2
		//2.배열의 호출
		System.out.println("배열[0] : " + scores[0]);
		System.out.println("배열[1] : " + scores[1]);
		System.out.println("배열[2] : " + scores[2]);
		System.out.println("배열 : " + scores); //배열명 주소 호출
		//3.배열 반복문 활용
		int sum = 0;
		for(int i = 0 ; i < scores.length ; i++) {//i는 0부터 배열의 길이 미만까지 1씩 증가
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + (sum/3.0));
									// sum/3 -> int/int = int
		 						    // sum/3.0 -> int/double = double
		//예2)
		//1.new 연산자를 이용한 선언
		int[] 배열 = new int[3]; //int형 3개를 저장할 수 있는 배열[고정길이]
		//2.값이 없을때
		for(int i = 0 ; i<배열.length ; i++) {
			System.out.println(배열[i]);
		}
		//3.배열에 데이터 넣기
		배열[0] = 100;
		배열[1] = 93;
		배열[2] = 20;
		//4.for문 배열내의 모든 인덱스 호출
		for( int i = 0 ; i<배열.length ; i++) {
			System.out.println(배열[i]);
		}
		//5.향상된 for문
		for(int temp : 배열) {
			//반복변수 : 배열명
			System.err.println(temp);
		}
	}
}
