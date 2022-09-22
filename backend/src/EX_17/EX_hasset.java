package EX_17;

import java.util.HashSet;
import java.util.Iterator;

public class EX_hasset {
	public static void main(String[] args) {
		HashSet<String>set = new HashSet<>();
		
		set.add("java");	System.out.println("set현황 : " + set.toString());
		set.add("jdbc");	System.out.println("set현황 : " + set.toString());
		set.add("servlet/jsp");	System.out.println("set현황 : " + set.toString());
		//중복[set 해시코드사용 ->주소값 변환저장]
		set.add("java");	System.out.println("set현황 : " + set.toString());
		set.add("ibatis");	System.out.println("set현황 : " + set.toString());
		
		System.out.println("set 내 객체수 : " + set.size());
		
		//해시코드 함수 확인
		System.out.printf("자바 문자열의 해시코드변환 : %x \n","javq".hashCode());
		System.out.printf("자바 문자열의 해시코드변환 : %x \n","java".hashCode());

		
		//순서없는 자료를 하나씩 순회하는 인터페이스
			//배열,컬렉션프레임워크 제공받음
		Iterator<String>iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
		}//순서 보장 못받음
		
		
		for(int i = 0 ; i < set.size(); i++) {//우리가 직접 순회
			}
		
		for(String s : set) {System.out.println("\t"+s);}//[ : ] Iterator제공
		
		
	}//main e
}
