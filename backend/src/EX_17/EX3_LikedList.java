package EX_17;

import java.util.ArrayList;
import java.util.LinkedList;

public class EX3_LikedList {
	public static void main(String[] args) {
		
		//속도차이 검증
		ArrayList<String>list1 = new ArrayList<>();
		LinkedList<String>list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		//ArrayList 삽입을 만번 했을때 걸린 시간
		startTime = System.nanoTime();	//현재시스템[pc]의 시간(나노) 호출
		for(int i = 0 ; i <100000 ; i++) {
			list1.add(0,i+"");
			//숫자 -> 문자열 변환 : 1.숫자+""		2.string.valueOf(숫자)
		}//for e
		endTime = System.nanoTime();
		System.out.println("ArrayList 100000개를 삽입하는데 걸리는 시간 : " + (endTime-startTime)+"ns");
		
		
		startTime = System.nanoTime();
		for(int i = 0 ; i < 100000 ; i++) {
			list2.add(0,i+"");
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 100000개를 삽입하는데 걸리는 시간 : " + (endTime-startTime)+"ns");
	}//main e
}
