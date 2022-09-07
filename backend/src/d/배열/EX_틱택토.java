package d.배열;

import java.util.Random;
import java.util.Scanner;

public class EX_틱택토 {
	public static void main(String[] args) {
		String[ ] 게임판 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]" };
		Scanner scanner = new Scanner(System.in);
		boolean 승리판단 = true;
		int count = 0;
		
		//1.게임판 출력=배열내 모든 데이터 출력
		while(true) {//무한루프
			for(int i = 0 ; i<게임판.length ; i++) {//i는 0부터 마지막 인덱스까지 1씩증가
				System.out.print(게임판[i]);
				if(i % 3 ==2 ) {System.out.println();}
			}//for e
			
			//2.사용자 위치 선택
			while(true) {//무한루프
				System.out.println("안내) 위치 선택 :");
				int 위치 = scanner.nextInt();
				//위치입력 설정
				if(위치 < 0 || 위치 > 8) {//0이상 8미만 번호 선택
					System.out.println("안내) 선택 할 수 없는 번호입니다");}
				else {System.out.println("안내) 이미 알이 존재하는 위치입니다");}
				//해당위치에 알이 없을때
				if(게임판[위치].equals("[ ]")) {게임판[위치] = "[o]"; break;}
				else {System.out.println("안내) 이미 알이 존재하는 위치입니다");}
			}//while2 e
			
			//3.컴퓨터 난수생성
			while(true) {
				Random random = new Random();//랜덤객체 생성
				int 위치 = random.nextInt(9); //0~8 난수생성
				if(게임판[위치].equals("[ ]")) {게임판[위치] = "[x]"; break;}
			}//while3 e
			
			//4.승리여부 판단
			for (int i = 0; i <= 6 ; i += 3) {//가로
				if(게임판[i].equals(게임판[i+1])&& 게임판[i+1].equals(게임판[i+2]))
					{게임판[i].equals("[o]");
						System.out.println("[o]의 승리");return;}
				else{System.out.println("[x]의 승리"); return;}
			}//for e
		}//while e
	}//main e
}//class e
/*
	틱택토 게임 설계
		[ 조건 ]
		1. 게임판 9칸 사용 -> 배열[0~8] 
			1. String 배열		클래스는 비교연산자 불가능
				==  <---> 문자열1.equals(문자열2)
				!=  <---> !문자열1.equals(문자열2)
		2. 사용자[O]가 알을 두고자 하는 위치[인덱스] 입력[0~8]
			1. 선택된 위치가 이미 다른 알이 존재하면 재입력 [중복제거]
		3. 컴퓨터[X]가 난수생성[0~8]
			1. 난수의 위치가 이미 다르 알이 존재하면 재생성 [ 중복제거 ]
		4. 승리자 판단 [ 1.가로로 이기는수 2. 세로로 이기는수 3. 대각선으로 이기는수 4.무승부 ]
		[ 출력 ] 게임판 출력 예시 
			[ ] [ ] [ ] 
			[ ] [ ] [ ] 
			[ ] [ ] [ ] 
*/