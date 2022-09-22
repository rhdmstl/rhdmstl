package 가계부;

import java.util.ArrayList;

public class Controller {
	
	// 1. 내용추가 컨트롤러
		boolean create( String edate , 
				int emoney , String ecomment) {
			// 매개변수3개 --> 1개 dto 객체 선언 
			Dto dto = new Dto( 0 , edate,
					emoney, ecomment);
			// dto객체 -> dao 메소드 
			return Dao.getInstance().create( dto );
		}
		
		//내용호출 컨트롤러
		ArrayList<Dto>read(){
			return Dao.getInstance().read();
		}
		
		//내용삭제 컨트롤러
		boolean delete(int eno) {
			return Dao.getInstance().delete(eno);
		}
		
		//내용수정 컨트롤러
		boolean update( int a , String b , int c , String d  ) {
			return Dao.getInstance().update( new Dto(a, b, c, d) );
		}

}
