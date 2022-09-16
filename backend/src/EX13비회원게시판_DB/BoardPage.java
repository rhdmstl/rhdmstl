package EX13비회원게시판_DB;

import java.awt.print.Pageable;
import java.util.Scanner;

public class BoardPage {
	Scanner scanner = new Scanner(System.in);//모든 메소드에서 사용할려고
	BoardContoller contol = new BoardContoller();//모든 메소드에서 호출할려고
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
		System.out.println(">>제목 : ");		String b_title = scanner.next();
		System.out.println(">>내용 : ");		String b_content = scanner.next();
		System.out.println(">>작성자 : ");	String b_writer = scanner.next();
		System.out.println(">>패스워드 : ");	String b_password = scanner.next();
		//2.입력받은 데이터를 contol 이동[다른 클래스 메소드 호출]
		boolean result = contol.regist(b_title, b_content, b_writer, b_password);
		//3.contol처리된 결과를 result에 저장한 다음 제어[contol 실행 후 결과의 경우의 수]
		if(result) { System.out.println("게시물 등록완료.");}//if e
		else {System.out.println("게시물 등록 실패");}
	}//m end
	
	//2.모든 게시물 출력화면
	void getBoardlist( ) {
		System.out.println("====게시판");
		System.out.println("번호\t작성자\t제목\t조회수");
		
		BoardDto[] boardlist = contol.getBoardlist();//contol에서 모든 게시물의 배열을 요청한다
		
		for(BoardDto dto : boardlist) {
			System.out.print(dto.b_no+"\t");		System.out.print(dto.b_writer+ "\t");
			System.out.print(dto.b_title+ "\t");	System.out.print(dto.b_view+ "\n");
		}
	}//m end
	
	//3.개별게시물 출력화면
	void getBoard() {
		System.out.println(">>게시물 번호 : ");		int b_no = scanner.nextInt();
		
		BoardDto board = contol.getBoard(b_no);//입력받은 번호를 getBoard전달하면 해당 게시물 정보가져오기
			if(board == null) {System.out.println("해당게시물이 없습니다"); return;}
		System.out.println("====개별 조회 페이지");
		System.out.println("제목 :" + board.b_title);
		System.out.println("작성자 :"+board.b_writer);
		System.out.println("조회수 :"+board.b_view);
		System.out.println("내용 :"+board.b_content);
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
