package c.조건문반복문;

import java.util.Scanner;//외부 클래스 호출

public class EX_별찍기 {
	public static void main(String[] args) {
		//0.입력객체 [ 1번 선언 ]
		Scanner scanner = new Scanner(System.in);
		
		//1.입력받은 수만큼 출력
		System.out.print("문제1) 별개수 : "); int s1 = scanner.nextInt();
				for(int i = 1 ; i <= s1 ; i++) {
					System.out.print("*");
				}
		System.out.println("\n-------------------------------------------------");
		//2. 입력받은 수 만큼 * 출력[3줄마다 줄바꿈처리]
				System.out.print("문제2) 별개수 : "); int s2 = scanner.nextInt();
						for(int i = 1 ; i <= s2 ; i++) {
						System.out.print("*");
						if(i % 3 ==0) {
							{System.out.println();}
						}
						}
		System.out.println("\n-------------------------------------------------");
		//3.입력받은 줄 만큼 *출력[줄바뀌면 *도 늘어남]
				System.out.print("문제3) 줄수 :"); int line3 = scanner.nextInt();
						for( int i = 1 ; i <= line3 ; i++ ) {
							for ( int s = 1 ; s <= i ; s++) {
								System.out.print("*");
							}System.out.println();//줄바꿈
						}
		System.out.println("\n-------------------------------------------------");	
		//4.입력받은 줄수와 별수가 반비례
				System.out.print("문제4) 줄수 :"); int line4 = scanner.nextInt();
						for( int i = 1 ; i <= line4 ; i++ ) {
							for ( int s = 1 ; s <= line4-i+1 ; s++) {
								System.out.print("*");
							}System.out.println();//줄바꿈
				}
		System.out.println("\n-------------------------------------------------");
		//5.입력받은 줄수와 별수 비례 공백비례
				System.out.print("문제5) 줄수 :"); int line5 = scanner.nextInt();
						for(int i = 1 ; i <= line5 ; i++) {
							for(int j = 1 ; j <= line5-i ; j++) {//공백찍기
								System.out.print(" ");
							}for(int s = 1 ; s <= i ; s++) {//별찍기
								System.out.print("*");
							}
							System.out.println();
						}
	   System.out.println("\n-------------------------------------------------");
	   //6.입력받은 줄수와 별수 비례 공백 반비례
				System.out.print("문제6) 줄수 :"); int line6 = scanner.nextInt();
					for(int i = 1 ; i <= line6 ; i++) {
						for(int j = 1 ; j <= i-1 ; j++) {//공백찍기
							System.out.print(" ");
						}for(int s = 1 ; s <= line6-i+1 ; s++) {//별찍기
							System.out.print("*");
						}
						System.out.println();
					}
	 System.out.println("\n-------------------------------------------------");
	 //7.피라미드 s= i*2-1로 1씩증가
	 		System.out.print("문제7) 줄수 :"); int line7 = scanner.nextInt();
	 			for(int i = 1 ; i <= line7 ; i++) {
	 				for(int j = 1 ; j <= line7-i ; j++) {//공백
	 					System.out.print(" ");
	 				}
	 				for(int s = 1 ; s <= i*2-1 ; s++) {//별
	 					System.out.print("*");
	 				}
	 				System.out.println();
	 			}
	System.out.println("\n-------------------------------------------------");
	//8.뒤집힌 피라미드
			System.out.print("문제8) 줄수 :"); int line8 = scanner.nextInt();
			for(int i = 1 ; i <= line8 ; i++) {
				for(int j = 1 ; j < line8-i ; j++) {
					System.out.print(" ");{
						for(int s = 1 ; s <= i*2+1 ; s++) {
							System.out.print("*");
						}
						System.out.println();
					}
	
				}
				
			}
			System.out.println("\n-------------------------------------------------");
	}
	}

