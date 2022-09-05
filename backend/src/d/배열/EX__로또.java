package d.배열;

import java.util.Random;
import java.util.Scanner;

	/*
	 	로또 판별기
	 		1.구매번호 : 사용자에게 6개 수 입력 -> 배열저장
	 			1.1~45사이 만 입력받기 아니면 재입력		2.중복x
	 		2.추첨번호 : 컴퓨터 난수 6개 생성 -> 배열저장
	 			1.1~45 사이의 난수
	 		3.구매번호와 추첨번호의 동일한 수 
	 */

public class EX__로또 {
	public static void main(String[] args) {
		//0.메모리선언[변수/베열]
		Scanner scanner = new Scanner(System.in);
		int[] 구매번호 = new int[6];
		int[] 추첨번호 = new int[6];
		
		//1.사용자에게 입력을 받는다[6번]
		 for(int i = 0 ; i<6 ; i++) {//i=인덱스 0~5까지 1씩 증가
			 System.out.println("안내) " + (i+1)+"번째 번호 선택");
			 구매번호[i] = scanner.nextInt();//입력받는 값을 i번쨰 인덱스에 저장
			 if(구매번호[i] < 1 || 구매번호[i] > 46) {//만약 입력값이 1보다 작거나 45보다 크면 재입력
				 System.err.println("안내)선택할 수 없는 번호 입니다");
				 i--;//현재  i는 무효
				 continue;//다시 실행 ->증감식임
			 }//if end
			 //[조건2] 배열 내 중복데이터 검사
			 boolean 중복체크 = false;
			 for(int j = 0 ; j < i ; j++) {
				 if(구매번호[j] == 구매번호[i]) {
					 System.out.println("안내) 이미 선택된 번호입니다");
					 중복체크 = true;
				 }
			 }
			//중복체크 변수가 true이면 재입력
			 if(중복체크) { i--; continue;}
			 
			 //[조건1/조건2] 모두 통화 후 코드
			 System.out.println(구매번호[i] + "숫자 선택하셨습니다");
		}
	/////////////////////////////////////////////////////////////////////////
		 //2.추첨번호 난수받기
		 for(int i = 0 ; i<6 ; i++) {
			 Random random = new Random();
			 추첨번호[i] = random.nextInt(45)+1;
			 //[조건2] 증복체크
			 for(int j = 0 ; j<i ; j++) {
				 if(추첨번호[j] == 추첨번호[i]) {i--; continue;}
			 }
		 }
	////////////////////////////////////////////////////////////////////////
			 for(int value : 구매번호) {
				 System.out.printf("%2d\t" , value);
			 }
			 System.out.println();
			 
			 for(int value : 추첨번호) {
				 System.out.printf("%2d\t" , value);
			 }//for end
			 System.out.println();
	 /////////////////////////////////////////////////////////////////////////////////
			 //구매번호 추첨번호 두 배열간 동일한 수 출력
			 int 당첨갯수 = 0;
			 for(int i = 0 ; i<구매번호.length ; i++) {//각 i마다 j비교 6회
				 for(int j =0 ; j<추첨번호.length ; j++) {//6*6 = 36
					 if(구매번호[i] == 추첨번호[j]) {
						 당첨갯수++;		//i번째 인덱스와 j번째 인덱스의 값이 같으면
					 }
				 }
			 }
			 System.out.println("총 당첨갯수 : " + 당첨갯수);
	}
}
