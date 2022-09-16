package EX13비회원게시판_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDao {
	Connection con;			//DB접속할 수 있는 인터페이스
	
	//"jdbc:mysql://localhost:3306/boardtest",
	//접속실패 시 대처 코드 있어야함[예외처리]

	PreparedStatement ps;	//접속된 db에 sql조작하는 인터페이스
	ResultSet rs;			//SQL결과를 조작하는 인터페이스
	
	public BoardDao() {
		//빈생성자에 DB 접속코드 (객체 생성시 자동으로 접속)
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardtest",
					"root",
					"1234");
		} catch (SQLException e) {System.out.println("경고 ) DB 접속 실패" + e);}
	}
	//3.메소드등록
		//1.등록메소드
		boolean regist(BoardDto boardDto) {
			return false;
		}
		//2.모든 게시물 출력 메소드
		BoardDto[] getBoardlist( ) {
			BoardDto[] Boardlist = null;
			return Boardlist;
		}
		//3.개별게시물 출력메소드
		BoardDto getBoard(int b_no) {
			BoardDto board = null;
			return board;
		}
		//4.수정처리 메소드
		boolean update(int b_no , String b_password , String b_title , String b_content) {
			return false;
		}
		//5.삭제처리 메소드
		boolean delete(int b_no , int b_password) {
			return false;
		}
}


