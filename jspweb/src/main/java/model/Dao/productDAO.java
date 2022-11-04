package model.Dao;

import java.sql.Statement;
import java.util.ArrayList;

import controller.admin.regist;
import controller.board.list;
import model.Dto.cartDTO;
import model.Dto.pcategoryDTO;
import model.Dto.prouctDTO;
import model.Dto.stockDto;

public class productDAO extends Dao{
	//1.카테고리 등록
	public boolean setpcategory(String pcname ) {
		String sql = "insert into pcategory(pcname) values(?)";
		try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, pcname);
	         ps.executeUpdate(); 
	         return true;
	      } catch (Exception e) {System.out.println("등록오류"+e);}
	      return false;
	   }
	//2.카테고리 출력
	public ArrayList<pcategoryDTO> getpcategory(){
		ArrayList<pcategoryDTO> list = new ArrayList<>();
		String sql = "select * from pcategory";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				pcategoryDTO dto 
					= new pcategoryDTO( 
							rs.getInt(1) , 
							rs.getString(2) );
				list.add(dto);
			}return list;
		} catch (Exception e) {System.out.println("카테고리 출력"+e);}
		return null;
	}
 	//3.제품등록
	public boolean setproduct (prouctDTO dto) {
		String sql ="insert into product(pname,pcomment,pprice,pdiscount,pimg,pcno) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getPname());	
			ps.setString( 2 , dto.getPcomment());
			ps.setInt( 3 , dto.getPprice());	
			ps.setFloat( 4 , dto.getPdiscount());
			ps.setString( 5 , dto.getPimg());	
			ps.setInt( 6 , dto.getPcno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("제품등록"+e);}
			return false;
	}
	//4.제품출력
	public ArrayList<prouctDTO>getproductlist( String option ){
		ArrayList<prouctDTO> list = new ArrayList<>();
		String sql = null;
		if(option.equals("all")) {
			sql = " select * from product ";
		}else if(option.equals("pactive1")) {
			sql = " select * from product where pactive = 0 order by pdate desc ";
		}
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				prouctDTO dto = new prouctDTO(
						rs.getInt(1) , rs.getString(2),
						rs.getString(3) , rs.getInt(4),
						rs.getFloat(5), rs.getByte(6),
						rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(dto);
			}
			System.out.println("다오"+list);
			return list;
		} catch (Exception e) {System.out.println("제품 출력"+e);}
		return null;
	}
	//5.제품 삭제
	public boolean deleteproduct(int pno) {
		String sql = "delete from product where pno = "+pno;
		try {
			ps = con.prepareStatement(sql);
			//삭제된 레코드수로 유무판단해야함(0개여도 성공만뜸)
			if(ps.executeUpdate()==1 ) { return true; }
		} catch (Exception e) { System.out.println("다오 확인"+e); }
			return false;
	}
	//개별출력
	public prouctDTO getProduct(int pno) {
		String sql = "select * from product where pno= "+pno;    
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				prouctDTO dto = new prouctDTO(
						rs.getInt(1) , rs.getString(2),
						rs.getString(3) , rs.getInt(4),
						rs.getFloat(5), rs.getByte(6),
						rs.getString(7),rs.getString(8),rs.getInt(9));
				return dto;
			}
		} catch (Exception e) {System.out.println("개별출력"+e);}
		return null;
	}
	// 7. 제품 업데이트 
		public boolean updateProduct( prouctDTO dto) {
			String sql = "update product set pname = ? , pcomment=? , pprice=? , pdiscount=? , pactive=? , pimg=? , pcno=? "
					+ "where pno = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString( 1 , dto.getPname());	ps.setString( 2 , dto.getPcomment());
				ps.setInt( 3 , dto.getPprice());	ps.setFloat( 4 , dto.getPdiscount());
				ps.setByte( 5 , dto.getPactive());	ps.setString( 6 , dto.getPimg());
				ps.setInt( 7 , dto.getPcno());		ps.setInt( 8 , dto.getPno());
				ps.executeUpdate(); return true;
			}catch (Exception e) { System.out.println(e);	} return false;
		}
	//8.재고등록
	public boolean setstock( String psize , int pno , String pcolor , int pstock ) {
		//1.사이즈 등록
		String sql = " insert into productsize ( psize , pno ) values( ? , ? ) ";
		try {	//// * 해당 sql에서 insert 된 pk값 가져오기 = Statement.RETURN_GENERATED_KEYS
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, psize);
			ps.setInt(2, pno);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();//pk값 호출
			if(rs.next()) {
				//색상재고등록
				int psno = rs.getInt(1);
				sql = " insert into productstock ( pcolor , pstock , psno ) values( ? , ? , ? ) ";
				ps = con.prepareStatement(sql); //꼭 해줘야함(들어오는 인수의 수가 다름)
				ps.setString(1, pcolor);
				ps.setInt(2, pstock);
				ps.setInt(3, psno);//첫번째 sql결과로 생성된 pk값
				ps.executeUpdate();
				return true;
			}
		}catch (Exception e) { System.out.println("재고등록"+e);}
			return false;
	}
	//9.재품별 재고출력
	public ArrayList<stockDto> getstock(int pno){
		ArrayList<stockDto> list = new ArrayList<>();
		String sql = " select ps.psno , ps.psize , pst.pstno , pst.pcolor , pst.pstock "
				+ " from productsize ps , productstock pst where ps.psno = pst.psno and ps.pno =  "+pno
				+ " order by ps.psize desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				stockDto dto = new stockDto(
						rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5));
				list.add(dto);
			}return list;
		} catch (Exception e) {System.out.println("재고출력"+e);}
			return null;
	}
	//10.제품 찜하기
	public int setPlike(int pno , int mno) {
		String sql = " select * from plike where pno = ? and mno = ? ";	//검색[해당 찜하기 여부확인]
		try { 
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			if(rs.next()) { //찜하기 있는 경우(검색결과 있으면 취소)
				sql = " delete from plike where pno = ? and mno = ? ";
				ps = con.prepareStatement(sql);
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps.executeUpdate();
				return 1; //찜하기 취소
			}else {//찜하기가 없는 경우(검색결과 없으면 등록)
				sql = " insert into plike ( pno , mno ) values ( ? , ? ) ";
				ps.setInt(1, pno);
				ps.setInt(2, mno);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
				return 2;//찜하기 등록
			} 
		} catch (Exception e) {System.out.println("찜하기 오류"+e);}
				return 3;//찜하기 오류
	}
	//11.장바구니에 선택한 제품 옵션 저장
	public boolean setcart(int pno , String psize , int amount , String pcolor , int mno) {
		String sql = "insert into cart(amount , pstno, mno) "
	            + " values("+amount+", (select pstno from productstock pst , (select psno from productsize where pno="+pno+" and psize='"+psize+"') sub "
	            + " where pst.psno=sub.psno and pcolor='"+pcolor+"'), "+mno+")";
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("카트오류"+e);}
			return false;
	}
	//12.회원번호의 모든 장바구니 호출
	public ArrayList<cartDTO>getcart(int mno){
		ArrayList<cartDTO> list = new ArrayList<>();
		String sql = "select"
				+ "   c.cartno, pst.pstno, p.pname, p.pimg, "
				+ "     p.pprice,p.pdiscount, pst.pcolor, ps.psize, c.amount"
				+ "from \r\n"
				+ "   cart c natural join "
				+ "   productstock pst natural join"
				+ "    productsize ps natural join"
				+ "    product p"
				+ "where"
				+ "   c.mno = "+mno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				cartDTO dto = new cartDTO(
				rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
				rs.getInt(5),rs.getFloat(5), rs.getString(6),rs.getString(7), rs.getInt(8));
				list.add(dto);
			}return list;
		} catch (Exception e) {System.out.println("장바구니 호출오류"+e);}
		return null;
	}
}


