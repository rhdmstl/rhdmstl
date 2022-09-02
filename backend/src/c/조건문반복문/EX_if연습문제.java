package c.조건문반복문;

import java.util.Scanner;

public class EX_if연습문제 {
	public static void main(String[] args) {
		// * 입력객체
				Scanner scanner = new Scanner(System.in);
				// 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 
				System.out.println("문제1) 정수1 입력 : ");	int 문제1_1 = scanner.nextInt();
				System.out.println("문제1) 정수2 입력 : ");	int 문제1_2 = scanner.nextInt();
				if( 문제1_1 > 문제1_2) {System.out.println("결과1 : " + 문제1_1);}
				else if(문제1_1 < 문제1_2) {System.out.println("결과1 : " + 문제1_2);}
				else {System.out.println("결과1 : 두 수는 같다");}
				
				// 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
				System.out.println("문제1) 정수1 입력 : ");	int 문제2_1 = scanner.nextInt();
				System.out.println("문제1) 정수2 입력 : ");	int 문제2_2 = scanner.nextInt();
				System.out.println("문제1) 정수3 입력 : ");	int 문제2_3 = scanner.nextInt();
				int max = 문제2_1;
				if(max < 문제2_2) {max = 문제2_2;}
				if(max < 문제2_3) {max = 문제2_3;}
				System.out.println("결과2 : 가장큰수 :" + max );
				//else if쓰면 안되는 이유는 조건을 하나밖에 실행하지못함 = 다중조건 중 하나라도 참이면 끝나버림
				
				// 문제4 : 3개의 정수를 입력받아서 오름차순 / 내림차순 
				System.out.println("문제1) 정수1 입력 : ");	int 문제4_1 = scanner.nextInt();
				System.out.println("문제1) 정수2 입력 : ");	int 문제4_2 = scanner.nextInt();
				System.out.println("문제1) 정수3 입력 : ");	int 문제4_3 = scanner.nextInt();
				if(문제4_1 > 문제4_2) {int temp = 문제4_1; 문제4_1 = 문제4_2; 문제4_2 = temp;}
				if(문제4_1 > 문제4_3) {int temp = 문제4_1; 문제4_1 = 문제4_3; 문제4_3 = temp;}
				if(문제4_2 > 문제4_3) {int temp = 문제4_2; 문제4_2 = 문제4_3; 문제4_3 = temp;}
				
				
				
				
				System.out.printf("%d %d %d" , 문제4_1 , 문제4_2 , 문제4_3);
				//부등호를 바꾸면 내림차순으로 바뀜
				
				// 문제6 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 
				System.out.println("문제6) 정수1 입력 : ");	int 문제6_1 = scanner.nextInt();
				if( 문제6_1 >= 90 ) {System.out.println("합격");}
				else{System.out.println("불합격");}
				
				//문제7
					// 점수를 입력받아 점수가 90점 이상이면 A등급
					//				점수가 80점 이상이면 B등급
					//				점수가 70점 이상이면 C등급
					//				그외 재시험
				System.out.println("문제7) 정수1 입력 : ");	int 점수 = scanner.nextInt();
				if( 점수 >= 90 ) {System.out.println("A등급");}
				else if( 점수 >= 80 ) {System.out.println("B등급");}
				else if( 점수 >= 70 ) {System.out.println("C등급");}
				else {System.out.println("재시험");}
				
				
				
				/* 문제8 [경우의 수 3개 , 첫번쨰 경우의 수 : 3개 , 두번째 경우의 수 : 3개]
				 * [ 입력 ] : 국어,영어,수학 입력받기
				   [ 조건 ]
					평균이 90점 이상이면서 
						국어점수 100점 이면 '국어우수' 출력
						영어점수 100점 이면 '영어우수' 출력
						수학점수 100점 이면 '수학우수' 출력
					평균이 80점 이상이면서 
						국어점수 90점이상 이면 '국어장려' 출력
						영어점수 90점이상 이면 '영어정려' 출력
						수학점수 90점이상 이면 '수학장려' 출력
						그외 재시험 */
				//경우의 수 3개
				System.out.println("문제7) 정수1 입력 : ");	int 국어 = scanner.nextInt();
				System.out.println("문제7) 정수1 입력 : ");	int 영어 = scanner.nextInt();
				System.out.println("문제7) 정수1 입력 : ");	int 수학 = scanner.nextInt();
				double 평균 = (국어+영어+수학)/3;
				
				if (평균 >= 90) {}
				else if(평균 >= 80) {}
				else {}
				
				 
				//문제9 로그인페이지
					// [ 입력 ] : 아이디와 비밀번호를 입력받기
					// [ 조건 ] : 회원아이디가 admin 이고 
					//           비밀번호가 1234 일 경우에는 
					//          로그인 성공 아니면 로그인 실패 출력
				
				System.out.println("-------[로그인]---------");
				System.out.println("아이디 : "); String 아이디 = scanner.next();
				System.out.println("비밀번호 : "); String 비밀번호 = scanner.next();
				
				if(아이디.equals("admin")){//아이디가 admin면
					if(비밀번호.equals("1234")){
						System.out.println("안내) 로그인 성공");
					}else {
					System.out.println("비밀번호가 다릅니다");
				}
				}else {//아이디가 틀리면
					System.out.println("안내) 아이디가 다릅니다");
				}//if첫번째
	}
}























