package d.배열;

import java.util.Random;
import java.util.Scanner;

public class EX_틱택토 {
	public static void main(String[] args) {
		String [ ] 게임판 = { "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]",};
		Scanner scanner = new Scanner(System.in);
		
		while(true) {//무한루프
			//1.게임판 출력
			for(int i = 0 ; i < 게임판.length ; i++) {
				System.out.print(게임판[i]);
				if(i == 2 || i == 5 || i == 8) {System.out.println();}
			}
		while(true) {
			System.out.println("안내 ) 위치선택 : ");	int 위치 = scanner.nextInt();
			if(위치 < 0 || 위치 > 8) {
				System.out.println("안내) 선택할 수 없는 번호입니다");
			}if(게임판[위치].equals("[ ]")) {게임판[위치] = "[o]"; break;
		}else {System.out.println("안내) 이미 알이 존재하는 위치입니다");
		}
	}
		//3.컴퓨터에게 위치 난수 생성
		while(true) {
		Random random = new Random();
		int 위치 = random.nextInt(9);
		if(게임판[위치].equals("[ ]")) {게임판[위치] = "[x]"; break;}
		}
		//4.승리 판단[과제]
		for(int i = 0 ; i < 3; i++) {
			if(게임판[i][0] == 'o' && 게임판[i][1] =='o' && 게임판[i][2] == 'o')||
			(게임판[0][i] == 'o' && 게임판[1][i] == 'o' && 게임판[2][i] == 'o')||
			(게임판[2][0] == 'o' && 게임판[1][1] == 'o' && 게임판[0][2] == 'o'){
				
			}
		}
}
}
}