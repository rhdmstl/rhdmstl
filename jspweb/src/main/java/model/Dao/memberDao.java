package model.Dao;

import java.sql.SQLException;

import model.Dto.memberDto;

public class memberDao extends Dao{
	
	private static memberDao mdao = new memberDao();
	public static memberDao getInstance() {return mdao;}
	
	public boolean singup(memberDto dto) {
	      String sql = "insert into member(mid,mpw,mname,mphone,memail,maddress)values(?,?,?,?,?,?)";
	      try {
	         ps=con.prepareStatement(sql);
	         ps.setString(1, dto.getMid());
	         ps.setString(2, dto.getMpw());
	         ps.setString(3, dto.getMname());
	         ps.setString(4, dto.getMphone());
	         ps.setString(5, dto.getMemail());
	         ps.setString(6, dto.getMaddress());
	         ps.executeUpdate(); return true;
	      } catch (Exception e) {System.out.println("memberDao오류"+e);}
	      return false;
	   }
	//로그인
	public int login(String mid ,  String mpassword) {
		String sql = "select * from member where mid = ?";
		try {
			 ps=con.prepareStatement(sql);
	         ps.setString(1, mid);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	        	 sql = "select * from member where mid = ? and mpw= ?";
	        	 ps=con.prepareStatement(sql);
		         ps.setString(1, mid);
		         ps.setString(2, mpassword);
		         rs = ps.executeQuery();
		         if(rs.next()) {return 1;}//성공
		         return 2;//비번 틀림
	         }
		} catch (Exception e) {System.out.println("login member db오류" + e); return 3;}//디비오류
		return 0; //아이디없음
	}
	
	//아이디찾기
	public String fineid(String mname , String memail) {
		String sql = "select * from member where mname = ? and memail= ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next())return rs.getString(2);
		} catch (Exception e) {System.out.println("아이디찾기 오류" + e);}
		return null;
	}
	
	//비번찾기[임시비번 발급]
	public boolean  finepw(String mid , String memail) {
		String sql = "select * from member where mid = ? and memail= ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {System.out.println("아이디찾기 오류" + e);}
		return false;
	}
	
	//임시비번으로 업데이트
	public boolean passwordchange(String mid , String randstr) {
		String sql = "update member set mpw = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, randstr);
			ps.setString(2, mid);
			ps.executeUpdate(); return true;
		} catch (Exception e) {System.out.println("임시비번 오류" + e);}
		return false;
	}
	
	
	private String getMpassword() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getMid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
