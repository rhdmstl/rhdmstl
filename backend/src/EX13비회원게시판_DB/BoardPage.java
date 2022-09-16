package EX13비회원게시판_DB;

import java.awt.print.Pageable;
import java.util.Scanner;

public class BoardPage {
	Scanner scanner = new Scanner(System.in);//계속 사용할라고?
	public static void main(String[] args) {
		//메소드호출 방식
		
		BoardPage page = new BoardPage();
		page.view();
		
	}
	
	//0.메인화면
	void view ( ) {
		BoardPage page = new BoardPage();//메소드 호출용 객체
		
		while(true) {
			page.getBoardlist(); //모든 게시물 출력함수
			System.out.println("1.글쓰기 2.글보기 선택: ");
			int btn = scanner.nextInt();
			//경우의 수 2개
			if(btn == 1) {page.regist();}
			else if (btn == 2) {page.getBoard();}
			else {System.out.println("알수 없는 번호입니다");}
		}
	}
	
	//1.등록화면
	void regist( ) {
		System.out.println("====등록페이지");
	}//m end
	
	//2.모든 게시물 출력화면
	void getBoardlist( ) {
		System.out.println("====게시판");
		System.out.println("번호\t작성자\t제목\t조회수");
	}//m end
	
	//3.개별게시물 출력화면
	void getBoard() {
		System.out.println("====개별 조회 페이지");
		System.out.println("제목 :");
		System.out.println("작성자 :");
		System.out.println("조회수 :");
		System.out.println("내용 :");
		//출력
		System.out.println("1.뒤로가기 2.수정 3.삭제 :");
		int btn = scanner.nextInt();
		BoardPage page = new BoardPage();
		if(btn == 1) {return;}
		else if (btn == 2) {page.update();} //2번선택시 업데이트 함수 호풀
		else if (btn == 3) {page.update();} //3번 선택시 삭제함수 호출
		else {}
	}//m end
	
	//4.수정처리 출력화면
	void update( ) {
		System.out.println("====수정처리 페이지");
	}//m end
	
	//5.삭제처리 출력화면
	void delete() {
		System.out.println("====삭제처리 페이지");
	}//m end
}
