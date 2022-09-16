package EX13비회원게시판_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//DB처리
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
			//1.SQL작성
			String sql =" insert "
					+"into "
					+"board( b_title , b_content , b_writer , b_password , b_view)"
					+"values(?,?,?,?,?)";
			//2.SQL 연결조작
			try {
				ps = con.prepareStatement(sql);//위에서 작성된 SQL를 ps로 연결
				ps.setString(1, boardDto.b_title); //1.첫번째 , 데이터
				ps.setString(2, boardDto.b_content); //2.두번째 , 데이터
				ps.setString(3, boardDto.b_writer); //3.세번째 , 데이터
				ps.setString(4, boardDto.b_password); //4.네번째 , 데이터
				ps.setInt(5, 0); //5.다섯번째 , 데이터
				ps.executeUpdate();
				return true;
				//3.SQL 결과
			} catch (SQLException e) {System.out.println("DB오류 " + e);}
			return false;//등록실패
		}
		
		//*전체 게시물 수 메소드
		int getrows() {
			//1.sql작성
			String sql = "select count(*)from board";
			//2.연결조작
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {return rs.getInt(1);}
			}catch (Exception e) {System.out.println("DB오류 " + e);}
			//3.결과
			return 0;
		}
		//2.모든 게시물 출력 메소드
		BoardDto[] getBoardlist( ) {
			//1.SQL작성
			int rowcount = getrows();//게시물수를 알려주는 함수 호출해서 반환값 저장
			BoardDto[] boardlist = new BoardDto[rowcount]; // 배열 선언
			String sql = "select *from board";
			//2.SQL연결 조작
			try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//ResulrSet rs : 쿼리[sql 결과]에 조작
				//rs -> null --.next() --> 검색된 레코드[행] --next()->다음레코드[행]
			int row = 0;//배열에 인덱스를 대체할 변수 선언
			while(rs.next()) {
				//레코드 한개당 6개필드
				int b_no =  rs.getInt(1);	//해당 레코드의 첫번째 필드의 데이터 호출
				String b_title =  rs.getString(2);
				String b_content =  rs.getString(3);
				String b_writer =  rs.getString(4);
				String b_password =  rs.getString(5);
				int b_view =  rs.getInt(6);
				//객체화
				BoardDto board = new BoardDto(b_no, b_title, b_content, b_writer, b_password, b_view);
			//	BoardDto board = new BoardDto(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6))
			boardlist[row] = board;
			//3.인덱스 증가
			row++;
			}
			}catch (Exception e) {
				System.out.println("DB오류 " + e);
			}
			//3.SQL결과
			return boardlist;
		}
		//3.개별게시물 출력메소드
		BoardDto getBoard(int b_no) {
			BoardDto board = null;
			String sql = "select * from board where b_no = ?";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, b_no);
				rs = ps.executeQuery();
				if(rs.next()) {
					//검색된 레코드의 필드를 객체화
					board = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
							rs.getString(5), rs.getInt(6));
				}
			}catch (Exception e) {System.out.println("DB오류 " + e);}
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


