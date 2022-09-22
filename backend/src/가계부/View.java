package 가계부;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	Scanner scanner = new Scanner(System.in);
	Controller con = new Controller();
	
	public static void main(String[] args) {
		//메소드 호출
		View view = new View();
		view.menu();
	}//main e

	void menu() {
		while(true) {
			read();
			System.out.println("1.추가 \t 2.수정 \t 3.삭제 \t 4.검색 \t 5.통계 \n");
			int btn = scanner.nextInt();
			if(btn == 1) {create();}
			else if(btn == 2) {update();}
			else if(btn == 3) {delete();}
			else {
			System.out.println("안내) 선택할수 없는 작동입니다. "); 
			scanner = new Scanner(System.in); // scanner 객체 초기화
			}
			
		}//while e
	}//void e
	//1.내용추가 메소드
	void create() {
		System.out.println("날짜 : ");	String edate = scanner.next();
		System.out.println("금액 : ");	int emoney = scanner.nextInt();
		System.out.println("내용 : ");	String ecomment = scanner.next();
		
		boolean result = con.create(edate, emoney, ecomment);
		
		if(result) {System.out.println("등록성공");}
		else {System.out.println("등록실패");}
	}
	
	//내용출력
	void read() {
		ArrayList<Dto>list = con.read();
		System.out.println("번호\t날짜\t\t금액\t내용");
		for(Dto dto : list) {
			System.out.print(dto.getEno() +"\t");
			System.out.print(dto.getEdate() +"\t");
			System.out.print(dto.getEmoney() +"\t");
			System.out.print(dto.getEcomment() +"\n");
		}
	}
	//내용수정
	void update() {
		System.out.println("수정할 번호 :");	int eno = scanner.nextInt();
		System.out.println("수정할 날짜 :");	String edate = scanner.next();
		System.out.println("수정할 금액 :");	int emoney = scanner.nextInt();
		System.out.println("수정할 내용 :");	String ecomment = scanner.next();
		
		boolean result = con.update(eno, edate, emoney, ecomment);
		if(result) {
			System.out.println("수정성공");
		}else {
			System.out.println("수정실패");
		}

		
	}
	//내용삭제
	void delete() {
		System.out.println("삭제할 번호 :");
		int eno = scanner.nextInt();
		boolean result = con.delete(eno);
		if(result) {System.out.println("삭제성공");}
		else {System.out.println("삭제실패");}
	}
}
