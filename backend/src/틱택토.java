import java.util.Random;
import java.util.Scanner;

public class 틱택토 {
	
	public static void main(String[] args) {
		// * String(문자) 9개 를 저장할수 있는 배열 선언과 초기값[처음값]
		String[ ] 게임판 = { "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]" };
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		
		
		while (true) { // 무한루프 [ 종료조건 : 승리판단 있을경우 ] // while 1 
			
			// 1. 게임판 출력 - 배열내 모든 데이터 출력 
			for( int i = 0 ; i<게임판.length ; i++ ) { // i는 0부터 마지막인덱스( 배열의길이-1 ) 까지 1씩 증가
				System.out.print( 게임판[i] );
				// 1-2 3줄[ 인덱스 : 2 , 5 , 80 ] 마다 줄바꿈
				if( i == 2 || i == 5 || i == 8 ) { System.out.println(); }
				// if( i == 2 || i == 5 || i == 8 ) ---> if( i % 3 == 2 )
			} // for end 
			
			// 2. 사용자 에게 위치 입력받기 
			while( true ) { // 무한루프 [ 종료조건 : 알을 두었을때 종료 break ] // while 2
				System.out.print("안내) 위치 선택 : "); int 위치 = scanner.nextInt();
				if( 위치 < 0 || 위치 > 8 ) { System.out.println("안내) 선택할수 없는 번호입니다.");}
				// 해당 위치에 알이 없으면 해당 위치에 알두기 
				if( 게임판[위치].equals("[ ]") ) {  게임판[위치] = "[O]"; count++; break; } // 알을 두면 무한루프 종료
				else { System.out.println("안내) 이미 알이 존재하는 위치 입니다. "); }
			} // while 2 end 

			//5.무승부
			if(count == 9) {System.out.println("무승부입니다"); return;}
			
			// 3. 컴퓨터 에게 위치 난수 생성
			while( true ) { // while 2
				Random random = new Random(); // 랜덤 객체 생성 
				int 위치 = random.nextInt(9); // 0~8 난수 생성 
				if( 게임판[위치].equals("[ ]")){ 게임판[위치] = "[X]"; count++; break; } // 알을 두면 무한루프 종료
			} // while 2 end 
			
			// 4. 승리 판단 [ 과제 ] 
			for(int i = 0 ; i<=6; i+=3) {
			if( !게임판[i].equals("[ ]" ) && 게임판[i].equals( 게임판[i+1]) && 게임판[i+1].equals( 게임판[i+2]) ) {
				if(게임판[i].equals("[O]")) {System.out.println("사용자 승리입니다");}
				if(게임판[i].equals("[X]")) {System.out.println("컴퓨터 승리입니다");}}
					}//for e
				
					    		
			//4.승리판단 [세로]
			for(int i = 0; i<=2; i++) {
				if(!게임판[i].equals("[ ]" ) && 게임판[i].equals( 게임판[i+3]) && 게임판[i+3].equals( 게임판[i+6]) ){
					if(게임판[i].equals("[O]")) {System.out.println("사용자 승리입니다");}
					if(게임판[i].equals("[X]")) {System.out.println("컴퓨터 승리입니다");}
					}
				}
			//for e
			
			
			//4.승리판단[대각선]
			if(!게임판[2].equals("[ ]" ) && 게임판[2].equals( 게임판[4]) && 게임판[4].equals( 게임판[6]) ) {
						if(게임판[2].equals("[O]")) {System.out.println("사용자 승리입니다");}
						if(게임판[2].equals("[X]")) {System.out.println("컴퓨터 승리입니다");}
					}
				
			if(!게임판[0].equals("[ ]" ) && 게임판[0].equals( 게임판[4]) && 게임판[4].equals( 게임판[8]) ) {
				if(게임판[0].equals("[O]")) {System.out.println("사용자 승리입니다");}
				if(게임판[0].equals("[X]")) {System.out.println("컴퓨터 승리입니다");}
			}
			
			
		} // while 1  end 
	} // main end 

}//class e

/*
[조건]
1.게임판 9칸-> 배열 0~8    String 배열 .equals
2.사용자가 위치[인덱스] 입력
	중복제거 
3.컴퓨터가 난수로 위치 입력 0~8
	중복제거
4.승리 판단   1가로 2세로 3대각선 4무승부
[] [] []
[] [] []
[] [] []
*/












