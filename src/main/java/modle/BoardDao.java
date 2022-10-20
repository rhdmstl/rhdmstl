package modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	   public BoardDao() {
	      try {
	      Class.forName("com.mysql.cj.jdbc.Driver");  
	            con=DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/jsptest", 
	            "root", 
	            "1234");
	      System.out.println("DB 연동 성공");
	   }catch (Exception e) {}
	}
	   //글쓰기
	   boolean getwrite() {
		   String sql = "insert into board(ttitle,tcontent,twriter,tpw) values(?,?,?,?);";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getTtitle());
				ps.setString(2, dto.getTcontent());
				ps.setString(3, dto.getTwriter());
				ps.setString(4, dto.getTpw());
				ps.executeUpdate();
				return true;
			} catch (Exception e) {System.out.println("글등록 오류"+e);}
		   return false;
	   }
}
