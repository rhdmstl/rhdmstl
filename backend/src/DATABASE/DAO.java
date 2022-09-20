package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	//1.필드
	Connection con;		//DB연결 인터페이스
	PreparedStatement ps;//SQL연결 조작 인터페이스
	ResultSet rs;		//SQL결과[쿼리] 조작 인터페이스
	
	//생성자 : 객체 생성시 초기값
	public DAO() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/market_db",
					"root",
					"1234");
		} catch (SQLException e) {System.out.println("오류 : " + e);}
	}
	
	//메소드
	//예제1 : 레코드 10줄  -> memberDTO 8개 -> 배열/리스트
	public ArrayList<MemberDto> 예제1결과( ) {
		// 배열(array) 대신에 배열을 편하게 사용할수 있는 미리 만들어진 클래스 [ 컬렉션(수집) 프레임워크 ]
			// 리스트 [선언] :  ArrayList< 리스트에 들어갈 객체의 클래스 > 리스트명 = new ArrayList<>();
			// 리스트에 객체 담기 : 리스트명.add( 객체명 ) 
		ArrayList<MemberDto>list = new ArrayList<>();	// MemberDto 로 생성된 객체 여러개를 담을수 있는 list 객체 선언
		//SQL작성
		String sql = "select * from member";
		//SQL연결 조작
		try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			// 레코드 -> 객체화
			MemberDto dto = new MemberDto(
					rs.getString(1), rs.getString(2), 
					rs.getInt(3), rs.getString(4),
					rs.getString(5), rs.getString(6),
					rs.getShort(7), rs.getString(8));
			// 객체 -> 배열/리스트 담기
			list.add(dto);
  		}//while e
		return list;
		} catch (SQLException e) {System.out.println("예제 출력");}
		return list;
	}
	// 2. 예제 2: 레코드10줄 1칸
	ArrayList< String > 예제2결과() {
		// 1. String 객체( 문자열 ) 여러개를 저장할수 있는 list 객체 선언 
		ArrayList< String > list = new ArrayList<>();
		String sql = "select mem_name from member";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) { // rs.next() : 다음 레코드 이동
				list.add( rs.getString( 1 ) ); // rs.get자료형(필드번호)
			} // while end 
			return list; // 반환 
		}catch (Exception e) {  System.out.println(" 예제2 오류 : " + e); }
		return list; // 반환 
	}
	//3.
	MemberDto 예제3결과() {
		String sql = "select*from member where mem_name='블랙핑크'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getShort(7), rs.getString(8));
				return dto;
			}
		}catch(Exception e) {  System.out.println(" 예제3 오류 : " + e); }
		return null;
	}
	//4.
	ArrayList<MemberDto> 예제4결과() {
		ArrayList<MemberDto>list = new ArrayList<>();
		
		String sql ="select mem_id , mem_name from member where height <= 162";
				
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
						dto.mem_id = rs.getString(1); 
						dto.mem_name = rs.getString(2);
				list.add(dto);
			}
			return list;
		}catch(Exception e) {  System.out.println(" 예제4 오류 : " + e); }
		return list;
	}
	//5.
	ArrayList<MemberDto> 예제5결과() {
		ArrayList<MemberDto>list = new ArrayList<>();
		
		String sql = "select mem_name , height , mem_number from member where height >= 165 and mem_number > 6";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
						dto.mem_name = rs.getString(1);
						dto.height = rs.getShort(2);
						dto.mem_number = rs.getInt(3);
				list.add(dto);
			}
			return list;
		}catch(Exception e) {  System.out.println(" 예제5 오류 : " + e); }
		return list;
	}
	//6.
	ArrayList<MemberDto> 예제6결과() {
		ArrayList<MemberDto>list = new ArrayList<>();
		String sql = " select mem_name , height , mem_number from member where height >= 165 or mem_number > 6";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
						dto.mem_name = rs.getString(1);
						dto.height = rs.getShort(2);
						dto.mem_number = rs.getInt(3);
				list.add(dto);
			}
			return list;
		}catch(Exception e) {  System.out.println(" 예제6 오류 : " + e); }
		return list;
	}
	//7.
	MemberDto 예제7결과() {
		MemberDto dto = null;
		String sql ="select * from member where mem_name like '우%'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto = new MemberDto(
						rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getShort(7), rs.getString(8));
				return dto;
			}
		}catch(Exception e) {  System.out.println(" 예제7 오류 : " + e); }
		return dto;
	}
	//8.
	ArrayList<MemberDto> 예제8결과(){
		ArrayList<MemberDto>list = new ArrayList<>();
		String sql = "select * from member where mem_name like '__핑크'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getShort(7), rs.getString(8));
				list.add(dto);
			}
			return list;
		}catch(Exception e) {  System.out.println(" 예제8 오류 : " + e); }
		return list;
	}
	//9.
	ArrayList<MemberDto> 예제9결과(){
		ArrayList<MemberDto>list = new ArrayList<>();
		String sql = "select mem_id , mem_name , debut_date from member order by debut_date desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getShort(7), rs.getString(8));
				list.add(dto);
			}
			return list;
		}catch(Exception e) {  System.out.println(" 예제9 오류 : " + e); }
		return list;
	}
}
