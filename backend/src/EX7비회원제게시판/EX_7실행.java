package EX7비회원제게시판;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class EX_7실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Board[] Boardlist = new Board[100]; 
		
		while(true) {
			
			//모든 게시물[배열]출력
			System.out.println("번호\t작성자\t제목");
//			for(int index = 0 ; index<Boardlist.length ; index++) {
//				System.out.printf("%d\t%s\t%s" , index , Boardlist[index].title);
//			}//for e
			int num = 0;
			for(Board temp : Boardlist) {
				num++;
				if(temp != null)//만일 객체가 존재하면 출력
				System.out.printf("%d \t %s \t %s \n" ,num , temp.writer , temp.title);
			}//for e
			
			System.out.println("1.글쓰기 2.글보기 선택 : ");
			int ch = scanner.nextInt();
			if(ch == 1) {///////////////1.글쓰기 실행//////////////////////
				//1.출력
				System.out.println("제목 : ");	String title = scanner.next();
				System.out.println("내용 : ");	String content = scanner.next();
				System.out.println("작성자 : ");	String writer = scanner.next();
				System.out.println("비밀번호 : "); String password = scanner.next();
				//2.저장된 변수 4개를 하나의 객체로 만들기[4개변수 묶음]
				Board regist = new Board(title,content,writer,password,0);
					//객체선언 : 클래스명 변수명 = new 생성자(매개변수 순서대로)
				//3.배열의 객체 저장
				for(int index = 0; index<Boardlist.length ; index++ ) {
					if(Boardlist[index] == null)//해당 인덱스에 객체가 없으면
					{Boardlist[index] = regist; System.out.println("글쓰기가 완료되었습니다"); break;}
				}//for e
				//2.입력
				//3.저장
			}//if e
				///////////////1.글쓰기 끝//////////////////////
			else if(ch == 2) {
				System.out.println("게시글을 선택하세요 ");
				int select =scanner.nextInt();//보고싶은 게시물 선택을 받기위한  scanner	
				Board board = Boardlist[select];
				
				System.out.println("========="+select+"번 상세페이지=============");
	        		System.out.print("작성자 :"+ board.writer);
	        		System.out.print("\n 제목 :"+ board.title);
	        		System.out.println("\n내용 :"+board.content);
	        		System.out.println("1.목록보기 2.글삭제 3.글수정 \n선택");int ch2=scanner.nextInt();
	        		if(ch2 == 1 ) {}//if e 생략 시 while 반복됨
	        		else if(ch2 ==2) {
	        			System.out.println("안내) 비밀번호");	String password = scanner.next();
	        			if(board.password.equals(password)) {
	        				System.out.println("수정할 제목 : ");	Boardlist[select].title = scanner.next();
	        				System.out.println("수정할 내용 : ");	Boardlist[select].content = scanner.next();
	        				System.out.println("안내)수정처리 했습니다");	
	        			}//if e
	        			else {System.out.println("안내)패스워드가 다릅니다");}
	        			
	        		}//else if e
			}//else if e
			else {
				
			}//else e
		}//while e
	}
}






















