package java연동;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

public class JDBC연동2 {
	public static void main(String[] args) {
		try {Class.forName("com.mysql.cj.jdbc.Driver");//MYSQL드라이버로 이동
		
		Connection con1 = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/shop_db3",
				"root",
				"1234");
		System.out.println("DB 연동성공");
		/*
			String sql = "insert into product values('바나나','1500','2021-07-01','델몬트',17)";
			PreparedStatement ps = con1.prepareStatement(sql);
			ps.executeUpdate();
			
			sql = "insert into product values('카스','2500','2022-03-01','OB',3)";
			ps = con1.prepareStatement(sql);	
			ps.executeUpdate();
			
			sql = "insert into product values('삼각김밥','800','2023-09-01','CJ',22)";
			ps = con1.prepareStatement(sql);
			ps.executeUpdate();
			
			
			//카스 재고변경
			String sql = "update product set amount = 10 where product_name = '카스'";
			PreparedStatement ps = con1.prepareStatement(sql);
			ps.executeUpdate();
			
			//삼각김밥 삭제
			sql = "delete from product where product_name = '삼각김밥'";
			ps = con1.prepareStatement(sql);
			ps.executeUpdate();
		*/
			//모든 멤버 호출
			String sql = "select *from product";
			PreparedStatement ps = con1.prepareStatement(sql);
			ResultSet re = ps.executeQuery();//쿼리[sql결과]
			
			while(re.next()) {
				System.out.println("회원아이디 : " + re.getString(1) + "\t");//첫필드의 데이터를 가져온다
				System.out.println("회원명 : " + re.getString(2) + "\t");
				System.out.println("회원주소 : " + re.getString(3) + "\n");
			}
		
		
		} //try e
		catch(Exception e){System.out.println("연동실패 : " + e);}
	}//main e
}//class e