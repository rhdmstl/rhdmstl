package EX_17;

import java.util.Vector;

public class EX2_vector {
	public static void main(String[] args) {
		
		Vector<Board>list = new Vector<>();
		
		//스텍을 안씀(바로 힙 생성해서 주소저장)
		list.add(new Board("제목1","내용1","글쓴이1"));
		list.add(new Board("제목2","내용2","글쓴이2"));
		list.add(new Board("제목3","내용3","글쓴이3"));
		list.add(new Board("제목4","내용4","글쓴이4"));
		list.add(new Board("제목5","내용5","글쓴이5"));
		
		list.remove(2); 
		list.remove(3);
		//2번 인덱스 삭제 후 다시 0번부터 세서 3번 인덱스 삭제 = 내용3,내용5 삭제
		
		for(Board b : list) {
			System.out.println(b.subject+"\t"+b.content+"\t"+b.writer);
		}
	
		
	
	
	
	}
}
/*
 	동기화 : 특정 메소드의 하나의 스레드만 사용 가능도록 대기상태로 만드는것
 	->멀티실행에 많이 씀 /충돌에 대한 안전성보장
 
 */