package ch8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class EX_4실행 {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		
		//인터페이스에 없는메소드이므로 사용불가
		//vehicle.checkfare();
		
		//강제 형변환 [인터페이스 -> 객체]
		//객체명/변수명 instanceof 클래스명을 넣으면 확인할 수 있음(강제형변환시 사용)
		System.out.println("관계확인 : " +(vehicle instanceof Bus));
		System.out.println("관계확인 : " +(vehicle instanceof Television));
		Bus bus = (Bus)vehicle;
		
		bus.run();
		bus.checkfare();
		
		//컬렉션 프레임워크
		//저장아니고 객체 조작만 함
		List<String>list;
		
		list = new ArrayList<>();
			list.add(" o o ");
			
		list = new Vector<>();
			list.add(" 0 0 ");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		list = new LinkedList<>();
			list.add(" 0,0 ");
			
		System.out.println(list.toString());
		
		//HashMap클래스는 list 인터페이스 구현X
		//list = new HashMap;
	}	
}
