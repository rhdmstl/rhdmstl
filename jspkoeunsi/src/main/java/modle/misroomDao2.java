package modle;

public class misroomDao2 extends misroomDAO{
	
	private static misroomDao2 misdao = new misroomDao2();
	public static misroomDao2 getInstance() {return misdao;}
	
	//1.회원가입
	public boolean signup( misroomDTO dto ) {
		String sql = " insert into misroom(mname,mid,mpw,mphone) values (?,?,?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMname());
			ps.setString(2, dto.getMid());
			ps.setString(3, dto.getMpw());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("signup 오류"+e);}
			return false;
	}
	//2.아이디 중복체크
	public boolean idcheck(String mid) {
		String sql = "select * from misroom where mid= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		} catch (Exception e) {System.out.println("아이디중복체크 오류"+ e);}
		return false;
	}
	//3.로그인
	public int login(String mid , String mpw) {
		String sql = "select * from misroom where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "select * from misroom where mid = ? and mpw= ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				ps.setString(2, mpw);
				rs = ps.executeQuery();
				if(rs.next()) {
					return 1;	//성공
				} return 2;	//비번틀림
			}
		} catch (Exception e) {System.out.println("로그인"+e);}
		return 0;	//아이디없음
	}
	//4.아이디 찾기
	public String findID(String mname , String mphone) {
		String sql = " select * from misroom where mname = ? and mphone= ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mphone);
			rs = ps.executeQuery();
			if(rs.next()) 
			return rs.getString(3);
		} catch (Exception e) {System.out.println("아이디찾기" + e);}
		return null;
	}
	//5.비번찾기[임시비번 발급]
	public boolean findPW(String mid , String mphone) {
		String sql = " select * from misroom where mid = ? and mphone= ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mphone);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {System.out.println("임시비번"+e);}
		return false;
	}
	//6.임시비번 업뎃
	public boolean PWchage(String mid , String ranstr) {
		String sql = " update misroom set mpw = ? where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ranstr);
			ps.setString(2, mid);
			ps.executeUpdate();
			System.out.println("다오되니");
			return true;
		} catch (Exception e) {System.out.println("임시비번업뎃"+e);}
		return false;
	}
}
