package c.조건문반복문;

import java.util.Scanner;

public class EX_자판기 {
	public static void main(String[] args) {
		//0.입력객체
		Scanner scanner = new Scanner(System.in);
		
		//1.공통 변수(제품3개 ->3개 , 장바구니제춤 3개 -> 3개)
		int 콜라 = 10; int 환타 = 10; int 사이다 = 10;
		int 콜라구매수 = 0; int 환타구매수 = 0; int 사이다구매수 = 0;
		
		while(true) {
			System.out.println("---------------[자판기]---------------");
			System.out.println("메뉴 : 콜라(300원) 2.환타(400원) 3.사이다(500원) 4.결제");
			System.out.println("선택 : "); int 메뉴선택 = scanner.nextInt();
			if(메뉴선택 == 1 ) {//1를 입력했을때
				if(콜라 > 0 ) {
					콜라--;	콜라구매수++;
					System.out.println("안내) 콜라를 장바구니에 담았습니다");
				}else {
					System.out.println("안내)콜라재고가 없습니다");
				}
			}else if(메뉴선택 == 2) {//2를 입력했을때
				if(환타 > 0 ) {
					환타--;	환타구매수++;
					System.out.println("안내) 환타를 장바구니에 담았습니다");
				}else {
					System.out.println("안내)환타재고가 없습니다");
				}
			}else if(메뉴선택 == 3) {//3를 입력했을때
				if(사이다 > 0 ) {
					사이다--;	사이다구매수++;
					System.out.println("안내) 사이다를 장바구니에 담았습니다");
				}else {
					System.out.println("안내)사이다재고가 없습니다");
				}
			}else if(메뉴선택 == 4) {//4를 입력했을때
				System.out.println("==========장바구니==========");
				System.out.println("제품명\t구매수\t가격");
				if(콜라구매수 > 0 ) {System.out.println("콜라\t"+콜라구매수+"\t"+(콜라구매수*300));}
				if(환타구매수 > 0 ) {System.out.println("환타\t"+환타구매수+"\t"+(환타구매수*400));}
				if(사이다구매수 > 0 ) {System.out.println("사이다\t"+사이다구매수+"\t"+(사이다구매수*500));}
				int 총결제금액 = (콜라구매수*300)+(환타구매수*400)+(사이다구매수*500);
				System.out.println("안내) 총결제 예정금액 : " + 총결제금액 + "원");
				
				System.out.print("안내) 결제 하시겠습니까? [Y] [N]"); String 결제여부 = scanner.next();
				
				boolean 결제성공 = false;//결제성공여부 저장하는 변수
				
				if(결제여부.equals("Y")||결제여부.equals("N")) {
					System.out.print("안내) 결제금액을 투여해주세요"); int 투입금액 = scanner.nextInt();
					if(총결제금액 > 투입금액) {
						System.out.println("안내)금액이 부족합니다[결제취소]");
					}else {
						System.out.println("안내) 구매완료 번호 : 0000 [잔돈 : "+(투입금액-총결제금액)+"원]");
					}
					if(결제성공) {//결제성공 : 장바구니 0으로 초기화
						콜라구매수 = 0; 환타구매수 = 0; 사이다구매수 = 0;
					}else {//결제취소 : 금액이 부족하거나 , 결제여부가 n이면 => 다시 재고채우기
						콜라 += 콜라구매수; 환타 += 환타구매수; 사이다 += 사이다구매수;
					}
					콜라구매수 = 0; 환타구매수 = 0; 사이다구매수=0;
				}
				int 투입금액 = scanner.nextInt();
				System.out.println("==========================");
			}else {//그외 입력했을때
				System.err.println("안내)선택할 수 없는 범위입니다[다시선택]");
			}
		}
	}
}
