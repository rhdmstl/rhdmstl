package EX_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class 달력Dao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static 달력Dao dao = new 달력Dao();//싱글톤
		//싱글톤 외부로 호출시키는 메소드
		public static 달력Dao getIntance() {return dao;}
		
	
	//생성자
	private 달력Dao() {
		//private 접근제한자 : 외부 클래스에서 사용가능
		try{
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test",
				"root",
				"1234");
	} catch (SQLException e) {System.out.println("경고 ) DB 접속 실패" + e);}//DB연동 끝
}
	//SQL메소드
	boolean 일정추가(String cdate , String ccomment) {
		String sql = "insert into calendar values(null,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cdate);
			ps.setString(2, ccomment);
			ps.executeUpdate();
			return true;
		}catch(SQLException e) {System.out.println("경고 ) DB 접속 실패" + e);}
			return false;
	}//일정추가 e
	    
	HashMap<Integer,ArrayList<String>> 일정출력(String year , String month) {
		String sql ="select * "
				+ "from calendar "
				+ "where substring( cdate , 1 , 4 ) = ? "
				+ "and substring( cdate , 6 , 2 ) = ? ";
		HashMap<Integer, ArrayList<String>> map = new HashMap<>(); 
		try {
			ps = con.prepareStatement(sql);
			ps.executeQuery();
			while(rs.next()) {
				
				ArrayList<String> values = new ArrayList<>();
				values.add(rs.getString(2));
				values.add(rs.getString(3));
				//pk와 리스트를 map에 담기
				map.put(rs.getInt(1), values);
			}
			return map;
		}catch(SQLException e) {System.out.println("경고 ) DB 접속 실패" + e);}
			return map;
	}//일정출력 e
}
