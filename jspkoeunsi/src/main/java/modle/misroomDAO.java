package modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class misroomDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
   public misroomDAO() {
      try {
      Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/room", 
            "root", 
            "1234");
            System.out.println("DB연동 성공");
   }catch (Exception e) {System.out.println("DB연동 실패");}
}
}
