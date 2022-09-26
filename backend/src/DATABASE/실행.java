package DATABASE;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner= new Scanner( System.in);
		while(true) {
			System.out.print(" 1~12 예제 중 번호 선택 : ");
			int ch = scanner.nextInt();
			
			// 메소드 호출 방법
				// 1. static(정적) 선언된 함수 : 클래스명.함수명()
				// 2. 일반함수 : 객체명.함수명() 
			
			DAO dao = new DAO(); // dao 객체 생성 
			
			// 1. 
			if( ch == 1 ) {
				ArrayList< MemberDto > list = dao.예제1결과();
				System.out.println("---------------- 예제1 결과물 ---------------");
				// 향상된 for문
				for( MemberDto dto : list ) { // list 내 모든 객체를 하나씩 반복대입
					System.out.print( dto.mem_id		+"\t" );
					System.out.print( dto.mem_name 		+"\t");
					System.out.print( dto.mem_number 	+"\t");
					System.out.print( dto.addr 			+"\t");
					System.out.print( dto.phone1 		+"\t" );
					System.out.print( dto.phone2 		+"\t" );
					System.out.print( dto.height 		+"\t" );
					System.out.print( dto.debut_date 	+"\n" );
				} // for end 
			} // ch == 1 end 
			
			// 2. 
			if( ch == 2 ) {
				ArrayList< String > list = dao.예제2결과();
				System.out.println("---------------- 예제2 결과물 ---------------");
				for( String s : list ) {
					System.out.print( s +"\t");
				} // for end 
				System.out.println();
			} // ch == 2 end 
			
			// 3. 
			if( ch == 3 ) {
				MemberDto dto = dao.예제3결과();
				System.out.println("---------------- 예제3 결과물 ---------------");
				System.out.print( dto.mem_id		+"\t" );
				System.out.print( dto.mem_name 		+"\t");
				System.out.print( dto.mem_number 	+"\t");
				System.out.print( dto.addr 			+"\t");
				System.out.print( dto.phone1 		+"\t" );
				System.out.print( dto.phone2 		+"\t" );
				System.out.print( dto.height 		+"\t" );
				System.out.print( dto.debut_date 	+"\n" );
			}
			
			// 4.
			if( ch == 4 ) {
				ArrayList<MemberDto> list = dao.예제4결과();
				System.out.println("---------------- 예제4 결과물 ---------------");
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_id		+"\t" );
					System.out.print( dto.mem_name 		+"\n");
				}
			}
			// 5.
			if( ch == 5 ) {
				ArrayList< MemberDto > list =  dao.예제5결과();
				System.out.println("---------------- 예제5 결과물 ---------------");
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_name		+"\t" );
					System.out.print( dto.height	+"\t" );
					System.out.print( dto.mem_number 		+"\n" );
				}
			}
			
			// 6.
			if( ch == 6 ) {
				ArrayList< MemberDto > list =  dao.예제6결과();
				System.out.println("---------------- 예제6 결과물 ---------------");
				for( MemberDto dto : list ) {
					System.out.print( dto.mem_name		+"\t" );
					System.out.print( dto.height	+"\t" );
					System.out.print( dto.mem_number 		+"\n" );
				}
			}
			
			// 7.
			if( ch == 7 ) {
				MemberDto dto = dao.예제7결과();
				System.out.println("---------------- 예제7 결과물 ---------------");
				System.out.print( dto.mem_id		+"\t" );
				System.out.print( dto.mem_name 		+"\t");
				System.out.print( dto.mem_number 	+"\t");
				System.out.print( dto.addr 			+"\t");
				System.out.print( dto.phone1 		+"\t" );
				System.out.print( dto.phone2 		+"\t" );
				System.out.print( dto.height 		+"\t" );
				System.out.print( dto.debut_date 	+"\n" );
			}
			
			// 8.
			if( ch == 8 ) {
				ArrayList< MemberDto > list = dao.예제8결과();
				System.out.println("---------------- 예제8 결과물 ---------------");
				// 향상된 for문
				for( MemberDto dto : list ) { // list 내 모든 객체를 하나씩 반복대입
					System.out.print( dto.mem_id		+"\t" );
					System.out.print( dto.mem_name 		+"\t");
					System.out.print( dto.mem_number 	+"\t");
					System.out.print( dto.addr 			+"\t");
					System.out.print( dto.phone1 		+"\t" );
					System.out.print( dto.phone2 		+"\t" );
					System.out.print( dto.height 		+"\t" );
					System.out.print( dto.debut_date 	+"\n" );
				} // for end 
			}//ch_8 e
			//9.
			if(ch == 9) {
				ArrayList<MemberDto>list = dao.예제9결과();
				 System.out.println("---------------- 예제9 결과물 ---------------");
				 for(MemberDto dto : list){
					System.out.print( dto.mem_id		+"\t");
					System.out.print( dto.mem_name 		+"\t");
					System.out.print( dto.mem_number 	+"\t");
					System.out.print( dto.addr 			+"\t");
					System.out.print( dto.phone1 		+"\t" );
					System.out.print( dto.phone2 		+"\t" );
					System.out.print( dto.height 		+"\t" );
					System.out.print( dto.debut_date 	+"\n" );	
				 }
			}//ch == 9 end
			
		}//while e
	}//main e
}//class e
