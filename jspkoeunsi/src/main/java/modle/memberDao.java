package modle;

import java.util.ArrayList;

public class memberDao extends DAO{
	
	private static memberDao mdao = new memberDao();
	public static memberDao getInstance() {return mdao;}
	
	public boolean post( DTO dto) {
		String sql = "insert into post(mtitle,mcontent,mwtiter,mpw)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMtitle());
			ps.setString(2, dto.getMcontent());
			ps.setString(3, dto.getMwtiter());
			ps.setString(4, dto.getMpw());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("글등록 오류" + e);}
			return false;
	}
	//모든 게시물 호출
	public ArrayList<DTO> getpostlist(){
		ArrayList<DTO> list = new ArrayList<>();
		String sql = "select * from post";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO(
					rs.getInt(1),rs.getString(2),
					rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),
					rs.getInt(7));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {System.out.println("모든 게시물 호출 오류" + e);}
			return list;
	}
	//글삭제
	public boolean delete(int mno) {
		String sql = "delete from post where mno =" +mno;
		try {
			ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if(count == 1)
				return true;
		} catch (Exception e) {System.out.println("글삭제 오류" + e);}
			return false;
	}
}
