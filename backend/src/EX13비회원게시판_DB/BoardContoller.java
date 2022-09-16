package EX13비회원게시판_DB;

public class BoardContoller {
	BoardDao boardDao = new BoardDao();//현재 클래스의 존재하는 메소드들이 dao객체 매소드 호출용
	//1.
	boolean regist(String b_title , String b_content , 
			String b_writer , String b_password) {//입력을 받아서 선언함
		//1.4개의 매개변수 받는다
		//2.변수 많을때 이동하면 매개변수 코드가 많으니까 객체화하자
		BoardDto boardDto = new BoardDto(0, b_title, b_content, b_writer, b_password, 0);
		//3.유효성검사[추후에 할 예정]
		//4.DB처리
		boolean result = boardDao.regist(boardDto);//dao.regist 메소드 호출 후 결과값을 result에 저장
		//5.DB결과 반환
		return result;
	}
	
	//2.
	BoardDto[] getBoardlist( ) {
		BoardDto[] boardlist = null;//선언
		boardlist = boardDao.getBoardlist();//결과
		return boardlist;//반환
		//return = boardDao.getBoardlist();전부 생략 후 가능
	}
	
	//3.
	BoardDto getBoard(int b_no) {
		BoardDto board = null;
		board = boardDao.getBoard(b_no);
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
