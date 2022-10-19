package model.Dao;

import java.util.ArrayList;

import model.Dto.BoardDto;

public class boardDao extends Dao{
	//싱글톤
	private static boardDao Bdao = new boardDao();
	public static boardDao getInstance() {return Bdao;}
	//1.글등록
	public boolean write(String btitle , String bcontent ,int mno,String bfile) {
		String sql = "insert into board (btitle,bcontent,mno,bfile) values(?,?,?,?)";
		System.out.println(mno);
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, mno);
			ps.setString(4, bfile);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("boardDao오류"+e);}
		return false;
	}
	//글출력
	public ArrayList<BoardDto> getlist(int startrow , int listsize , String key, String keyword){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "";
		if(!key.equals("")&&!keyword.equals("")) {
		 sql = "select b.* , m.mid from member m , board b "
				+ " where m.mno = b.mno  and "+key+" like '%"+keyword+"%' "
				+ " order by b.bdate desc limit "+startrow+" , "+listsize; }
		else {
			sql = " select b.* , m.mid from member m , board b "
					+ " where m.mno = b.mno order by b.bdate desc limit "+startrow+" , "+listsize;
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getInt(6),
						rs.getInt(7),rs.getInt(8),
						rs.getString(9));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("boardDao 글출력 오류"+e);}
		return list;
	}
	//글조회
	public BoardDto getboard(int bno) {
		String sql = "select b.* , m.mid from member m , board b where m.mno = b.mno and bno =" +bno;
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
		} catch (Exception e) {System.out.println("boardDao 글조회 오류"+e);}
			return null;
	}
	//삭제
	public boolean delete(int bno) {
		String sql = "delete from board where bno =" +bno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count == 1)
			return true;
		} catch (Exception e) {System.out.println("boardDao 삭제오류" + e);}
			return false;
	}
	//첨부파일만 삭제[업데이트]
		public boolean bfiledelete( int bno ) {
			String sql = "update board set bfile = null where bno = "+bno;
			try {
				ps = con.prepareStatement(sql);
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println(e);	} return false;
			
		}
	//게시물 수정 
	public boolean bupdate( int bno , String btitle , String content , String bfile ) {
		String sql = "update board set btitle = ? , bcontent=? , bfile = ?  where bno = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , btitle );
				ps.setString( 2 , content );
				ps.setString( 3 , bfile );
				ps.setInt( 4 , bno );
				ps.executeUpdate(); return true;
			}catch (Exception e) {System.out.println(e);} return false;
		}
	//조회수 증가
	public void bviewupdate(int bno) {
		String sql = "update board set bview = bview+1 where bno"+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("조회수 증가 오류"+e);}
	}
	//전체 게시물 수
	public int gettotalsize() {
		String sql = "select count(*) from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())return rs.getInt(1);
		} catch (Exception e) {System.out.println("전체게시물 오류"+e);}
			return 0;
	}
	//검색된 게시물
	public int gettotalsize(String key , String keyword){
		String sql = "";
		if(!key.equals("")&& !keyword.equals("")) {//검색이 있을경우
		 sql = " select count(*) from member m , board b where m.mno = b.mno and "+key+" like '%"+keyword+"% ";
		}else{//검색이 없는 경우
		 sql = " select count(*) from member m , board b where m.mno = b.mno ";}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (Exception e) {System.out.println("검색오류"+e);}
			return 0;
	}
}
