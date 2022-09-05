package c.조건문반복문;

import java.util.Random;
import java.util.Scanner;

/*
		[조건]
		1.플레이어에게  가위[0] 바위[1] 보[2]중에입력받기
		2.컴퓨터에게[0~2]난수 생성
			* Random 클래스
				*Random 변수명 = new Random
				*변수명.nextInt(수) : 0~수-1까지의 난수 발생
		3.승리자 판단[경우의 수]
		4.게임종료시 최종승리자가 출력
		[메뉴]
			가위(0) 바위(1) 보(2) 종료(3)
		
		변수명(메모리) 설정하기 중요**
		
		*/
public class EX_가위바위보 {
		
	public static void main(String[] args) {
		//0.모든 코드에서 사용될 변수[메모리] 선언
		Scanner scanner = new Scanner(System.in);
		int 플레이어; int 컴퓨터; int 게임판수=0; int 승리수 = 0; //0이면 무승부 || 양수:플레이어 || 음수:컴퓨터
		while(true) {//무한루프[종료조건 : 3을 입력했을떄]
			//1.플레이어에게 입력받는다
			System.out.print("가위(0) 바위(1) 보(2) 종료(3) : "); 플레이어 = scanner.nextInt();
				//6.입력 경우의 수[1. 0~2:정상입력 || 3.종료 || 그외 : 비정상입력
			if(플레이어 >= 0 && 플레이어 <=2){
				//2.컴퓨터가 난수 생성
				Random random = new Random(); //2-1랜덤객체 생성
				컴퓨터 = random.nextInt(3); //2-2.랜덤객체를 이용한 int형 난수생성 : 객체명.nextInt(수) 0~(수-1)
				//3.승리자판단 [경우의 수 : 1.승리 2. 패배 3.무승부]
				if((플레이어 == 0 && 컴퓨터==2) || (플레이어==1 && 컴퓨터==0) || (플레이어==2 && 컴퓨터==1)){//가위(0),보(2) || 바위(1),가위(0) ||  보(2),바위(1)
					System.out.println("결과) 플레이어 승리"); 승리수++;
				}else if((플레이어 == 0 && 컴퓨터==0) || (플레이어==1 && 컴퓨터==1) || (플레이어==2 && 컴퓨터==2)){//무승부[가위(0),보(0) || 바위(1),가위(1) ||  보(2),바위(2)]
					System.out.println("결과) 컴퓨터 무승부");
				}else {//그 외 컴퓨터승리
					System.out.println("결과)컴퓨터 승리"); 승리수--;}
				//5.게임횟수 증가
				게임판수++;
				
			}else if(플레이어 == 3){
				//7.게임종료했을떄
				System.out.println("게임종료) 게임횟수 : " + 게임판수);
				if(승리수 == 0 ) {
					System.out.println("최종결과)무승부");
				}else if(승리수 >= 1) {
					System.out.println("최종결과) 플레이어 승리");
				}else {
					System.out.println("최종결과) 컴퓨터 승리");
					break;//무한루프 탈출[반복문 종료]
				}
			}else {
				System.out.println("안내) 알 수 없는 번호 입니다[다시입력]");//그 외 버튼 눌렀을때
			}
		}//while end
	}
}
