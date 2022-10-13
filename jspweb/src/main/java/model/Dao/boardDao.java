package model.Dao;

import java.util.ArrayList;

import model.Dto.BoardDto;

public class boardDao extends Dao{
	//싱글톤
	private static boardDao Bdao = new boardDao();
	public static boardDao getInstance() {return Bdao;}
	//1.글등록
	public boolean write(String btitle , String bcontent ,int mno) {
		String sql = "insert into board (btitle,bcontent,mno) values(?,?,?)";
		System.out.println(mno);
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("boardDao오류"+e);}
		return false;
	}
	//글출력
	public ArrayList<BoardDto> getlist(){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("글출력 오류"+e);}
		return list;
	}
	//글조회
	public BoardDto getboard(int bno) {
		String sql = "select * from board where bno = " +bno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8),
						rs.getString(9));
				return dto;
			}
		} catch (Exception e) {System.out.println("글조회 오류"+e);}
			return null;
	}
	
}
