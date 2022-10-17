package modle;

public class misroomDao2 extends misroomDAO{
	
	private static misroomDao2 misdao = new misroomDao2();
	public static misroomDao2 getInstance() {return misdao;}
	
	public boolean signup( misroomDTO dto ) {
		String sql = "insert into misroom(mid,mpw,mphone) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMphone());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("signup 오류"+e);}
			return false;
	}
}
