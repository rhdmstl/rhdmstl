package 키오스크.관리자;

import java.util.ArrayList;

public class AdminController {
	
	/// 2. 메뉴 추가 로직
	boolean inMenu( String menuname ) {
		return AdminDao.getInstance().inMenu(menuname); // 싱글톤객체 메소드 호출 
	}
	//3.메뉴호출로직
	ArrayList<MenuDto>getMenu(){
		return AdminDao.getInstance().getMenu();
	}
	
	// 4. 제품 추가 로직 
	boolean inProduct( String pname , int ppriece , 
			String pcomment , int pamount , int mno  ) {
		ProductDto pdto = new ProductDto(0,pname,price,pcomment,pamount,mno);
		return false;
	}
	// 5. 주문 확인 로직 
	void getOrder( ) { }
}
