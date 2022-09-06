package d.배열;

import java.util.Scanner;

public class EX_학생점수관리 {
	public static void main(String[] args) {
		
		boolean run = true;		//무한루프 제어변수
		int studuntNum = 0;		//학생수 저장변수
		int [] scores = null;	//여러 점수 저장할 변수[메모리 할당 전](깡통)
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) { //무한루프 [종료조건 : 5입력]
			System.out.println("--------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4. 분석 5.종료");
			System.out.println("선택 :" ); int selectNo = scanner.nextInt();
			
			if( selectNo == 1) {
				System.out.println("학생수 : ");
				studuntNum = scanner.nextInt();
				scores = new int[studuntNum];//**입력받은 학생수 만큼 배열의 길이 변경
				System.out.println("배열에 " + studuntNum + "명의 점수 입력가능");
			}//1입력했을때
			else if(selectNo == 2) {//학생수 입력전 실행 불가
				for(int i = 0 ; i < scores.length ; i++) {//i는 0부터 배열의 길이까지 1씩 증가반복
					System.out.print("scores[" +i+"] : ");
					scores[i] = scanner.nextInt();//i번째 인덱스 입력값 대입
				}//for end
			}//2입력했을때
			else if(selectNo == 3) {
				for(int i = 0 ; i < scores.length ; i++) {
					//System.out.println("scores["+i+"]>%d" + scores[i]); 아래 문법과 같음
					System.out.printf("scores[%d]>%d \n" , i , scores[i]);
				}//for end
			}//3입력했을때
			else if(selectNo == 4) {
				int max = 0;//최고점수
				int sum = 0;//평균구하기
				for(int value : scores) {
					if(value > max) {max = value;}//만약 해당 값이 max보다 크면 max대입
					sum += value;	// 해당 값을 sum 변수에 누적 더하기
				}//for end
					System.out.println("최고점수 : " + max);
					double avg = sum/scores.length;
					System.out.println("평균점수 : " + (sum/scores.length));
					
					 	//순위별 내림차순 출력
					for(int i = 0 ; i < scores.length ; i++) {
						for(int j = i+1 ; j < scores.length ; j++) {
							if(scores[i] > scores[j]) {//>오름차순 <내림차순
								//두 변수 위치 교환
								int temp = scores[i];
								scores[i] = scores[j];
								scores[j] = temp;
							}//if end
						}//for end
					}//for end
					//확인
					int rank = 0;
					for(int value : scores) {
						System.out.println((rank+1)+"순위점수 : " + value);
						rank++;
					}//for end
					 
			}//4입력했을때
			else if(selectNo == 5) {run=false;}//5입력했을때
			else{System.out.println("안내) 알 수 없는 경로입니다");}//그 외 입력했을때
			
		}//while end
		
	}//main end
}//class end
