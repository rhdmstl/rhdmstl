package 가계부;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
	//필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static Dao dao = new Dao();//싱글톤
	//생성자
	private Dao() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test",
					"root",
					"1234");
		} catch (SQLException e) {System.out.println("경고 ) DB 접속 실패" + e);}//DB연동 끝
	}
	//메소드
	public static Dao getInstance() {return dao;}
	
	//내용추가 SQL
	boolean create(Dto dto) {
		String sql = "insert into expense values( null , ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getEdate() );
			ps.setInt( 2 , dto.getEmoney() );
			ps.setString( 3 , dto.getEcomment() );
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println("DB오류:"+e);} 
		return false;
	}
	
	//2.내용출력 SQL 메소드
	ArrayList<Dto>read(){
		ArrayList<Dto>list = new ArrayList<>();
		String sql = "select * from expense";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				// 레코드[필드4개] 1개 --> 객체화[필드4개] 1개 [포장]
				Dto dto = new Dto(rs.getInt(1),rs.getString(2), 
						rs.getInt(3), rs.getString(4));
					// 객체 -> 리스트 담기
					list.add(dto);	
			}
			return list;
		}catch(Exception e) {}
		return list;
	}
	
	//4.내용삭제 메소드
	boolean delete(int eno) {
		String sql = "delete from expense where eno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eno);
			ps.executeUpdate(); return true;
		}catch(Exception e) { }
		return false;
	}
	
	//3.내용수정 메소드
	boolean update(Dto dto) {
		String sql = "update expense set "
				+ "edate = ? , "
				+ "emoney = ? , "
				+ "ecomment = ?  "
				+ "where eno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEdate());
			ps.setInt(2, dto.getEmoney());
			ps.setString(3, dto.getEcomment());
			ps.setInt(4, dto.getEno());
			ps.executeUpdate(); return true;
		}catch(Exception e) { System.out.println("DB오류:"+e);} 
		return false;
	}
}
