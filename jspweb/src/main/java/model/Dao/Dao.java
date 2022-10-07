package model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	   public Dao() {
	      try {
	      Class.forName("com.mysql.cj.jdbc.Driver");  
	            con=DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/jspweb", 
	            "root", 
	            "1234");
	      System.out.println("DB 연동 성공");
	   }catch (Exception e) {}
	}
}
