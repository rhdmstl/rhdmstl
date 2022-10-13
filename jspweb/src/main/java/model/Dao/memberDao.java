package model.Dao;

import java.sql.SQLException;

import model.Dto.memberDto;
import java.util.ArrayList;

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
	
	//회원정보 호출
	public memberDto getinfo(String mid) {
		memberDto dto = null;
		String sql ="select * from member where mid= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				//풀생성자
				dto = new memberDto(rs.getInt(1), rs.getString(2), null,rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				/*
				//빈생성자
				dto = new memberDto();
				dto.setMno(rs.getInt(1));
				dto.setMid(rs.getString(2));
				//패스워드 제외
				dto.setMno(rs.getInt(1));
				dto.setMid(rs.getNString(2));
				dto.setMphone(rs.getString(4));
				dto.setMname(rs.getString(5));
				dto.setMemail(rs.getString(6));
				dto.setMaddress(rs.getString(7));
				dto.setMdate(rs.getString(8));
				dto.setMpoint(rs.getInt(9));
				*/
				//반환
				return dto;
			}
		} catch (Exception e) {System.out.println("회원정보 호출 오류" + e);}
		return dto;
	}
	
	// 7. 모든 회원 호출 
	public ArrayList<memberDto> getinfolist(){
		ArrayList<memberDto> list = new ArrayList<>();	// 1.리스트 선언 
		String sql ="select * from member";	// 2. SQL 작성 
		try {
			ps = con.prepareStatement(sql);	// 3. SQL 연결 
			rs = ps.executeQuery();			// 4. SQL 실행 
			while( rs.next() ) {			// 5. SQL 결과 레코드 반복 호출
				memberDto dto = new memberDto(	// 6. 레코드 --> DTO 객체 생성 
					rs.getInt( 1 ) , rs.getString( 2 ) , null ,
					rs.getString( 4 ), rs.getString( 5 ) ,
					rs.getString( 6 ), rs.getString( 7 ), 
					rs.getString( 8 ) , rs.getInt( 9 ));
				list.add(dto);					// 7. DTO -> 리스트 담기
			}
			return list;						// 8. 리스트 반환
		}catch (Exception e) {System.out.println("모든 회원 호출 오류"+e);}
			return list;
	}
	
	//8.회원탈퇴
	public boolean delete(String mid , String mpassword) {
		String sql = "delete from member where mid = ? and mpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			int count = ps.executeUpdate();
			System.out.println(count);
			if(count == 1) {return true;}
			// 삭제된 레코드가 1개 이면 성공 
		} catch (Exception e) {System.out.println("회원탈퇴 오류" + e);}
		return false;
	}
	//아이디 중복체크
	public boolean idcheck(String mid) {
		String sql = "select * from member where mid= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("아이디중복체크 오류"+ e);}
		return false;
	}
	//이메일 중복체크
	public boolean emailcheck(String memail) {
		String sql = "select * from member where memail= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("이메일 중복체크 오류"+e);}
		return false;
	}
	//회원정보 수정
	public boolean update(String mid , String mname) {
		String sql = "update member set mname = ? where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mid);
			ps.executeUpdate();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("회원정보 수정 오류"+ e);}
			return false;
	}
	//회원아이디->회원번호
	public int getMno(String mid) {
		String sql = "select * from member where mid= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (Exception e) {System.out.println("회원번호 오류"+e);}
			return 0;
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
