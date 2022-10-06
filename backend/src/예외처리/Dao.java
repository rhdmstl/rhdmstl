package 예외처리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Dao {
	   //필드
	   private Connection con;
	   private PreparedStatement ps;
	   private ResultSet rs;
	   private static Dao dao = new Dao();
	   
	   public static Dao getInstance() {return dao;}
	   
	   //생성자
	   private Dao() {
	      try {
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmth", "root", "1234");
	      } catch (Exception e) {
	         System.out.println("경고 ) DB연동 실패 :" + e);
	      }
	   }
	   
	   //메소드
	   public void signup() throws SQLException {
	        
		   String sql = "insert into product values(null,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,"과자");
				ps.executeUpdate();
	   }
	   public void login() throws SQLException {
	      String sql="";
	      ps = con.prepareStatement(sql);
	      ps.executeQuery();
	   }
}
