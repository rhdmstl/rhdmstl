package EX13비회원게시판_DB;

public class BoardContoller {
	boolean regist(String b_title , String b_content , String b_writer , String b_password) {
		return false;
	}
	
	//2.
	BoardDto[] getBoardlist( ) {
		BoardDto[] boardlist = null;
		return boardlist;
	}
	
	//3.
	BoardDto getBoard(int b_no) {
		BoardDto board = null;
		return board;
	}
	
	//4.
	boolean update(int b_no , String b_password , 
			String new_title , String new_content) {
		return false;
	}
	
	//5.
	boolean delete(int b_no , String b_password) {
		return false;
	}
	
}
