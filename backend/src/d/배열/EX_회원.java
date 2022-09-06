package d.배열;

import java.util.Scanner;

public class EX_회원 {
	public static void main(String[] args) {
		//0.메모리
		String [][] memberlist = new String[100][4];
		Scanner scanner = new Scanner(System.in);
		
		//1.무한루프
		while(true) {
			System.out.println("==========회원제 페이지==========");
			System.out.println("메뉴: 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기");
			System.out.println("===========================");
			System.out.println("선택 :");		int btn = scanner.nextInt();
			if( btn == 1 ){
				System.out.println("=================로그인==================");
				//1.아이디 / 비밀번호 입력받기
				System.out.println("아이디 : ");	String id = scanner.next();
				System.out.println("비밀번호 : ");	String pw = scanner.next();
				//2.배열내 모든 항목[인덱스]와 비교해서 입력한 아이디와 비밀번호 있는지 확인
				int login = 0;//로그인 처리에 대한 경우의 수 상태를 저장하는 변수
				for(int i = 0 ; i < memberlist.length ; i++) {
					if(memberlist[i][0] != null ) {//회원이 존재하면서
						if(memberlist[i][0].equals(id)) {//해당 인덱스의 아이디가 입력받은 값이 동일할때
							login = 2;//아이디만 맞고 비밀번호 틀림
							if(memberlist[i][1].equals(pw)) {//해당 인덱스의 비밀번호가 입력받은 값이 동일할때
								System.out.println("안내) 로그인 성공");
								login =1;//로그인 성공[아이디/비밀번호 일치]
								
									//(추후코드) 로그인메뉴
									while(true) {
										System.out.println("메뉴 : 1.회원탈퇴 2.로그아웃");
										int btn2 = scanner.nextInt();
										if(btn2 ==1 ) {
											//----------------------------------------------
											//i가 로그인 성공한 인덱스 = 로그인된 회원의 인덱스
											memberlist[i][0] = null;	memberlist[i][1] = null;
											memberlist[i][2] = null;	memberlist[i][3] = null;
												//null 뒤로 한칸씩 당기기
												for(int j = i ; j <memberlist.length ; j++) {
													memberlist[j][0] = memberlist[j+1][0];
													memberlist[j][1] = memberlist[j+1][1];
													memberlist[j][2] = memberlist[j+1][2];
													memberlist[j][3] = memberlist[j+1][3];
													if(memberlist[i+1][0] == null)break;
												}//for e
											//----------------------------------------------
											System.out.println("안내) 회원 탈퇴가 완료되었습니다");
											break;
										}//if e
										else if (btn2 == 2) {
											break;
										}//else e 
									}//while e
								break;
							}//if e
						}//if e
					}//if e
				}//for e
				if(login == 0) {
					System.out.println("안내)동일한 아이디가 없습니다");
				}//if e
				else if(login ==2 ) {
					System.out.println("안내)비밀번호가 일치하지않습니다");
				}//else if e
				else if(login == 1 ) {
					System.out.println("안내)로그아웃 되었습니다");
				}//else if e
				//3.있으면 로그인 성공 없으면 로그인 실패
			}//1 입력
			else if( btn == 2 ){             
				System.out.println("=================회원가입==================");
				//1. 회원정보 변수로 입력받기[바로 배열에 대임안함]
				System.out.println("아이디 : ");	String id = scanner.next();
				//2.아이디 중복체크: id가 배열내 존재하면 회원가입 실패
				boolean idcheck = true; //아이디 중복 여부확인[true=중복없다/false=중복]
				
					for(int row = 0 ; row< memberlist.length ; row++) {
						if( memberlist[row][0] != null && memberlist[row][0].equals(id)) {
							//**null 은 equals메소는 사용불가 [== null , !== null]
							System.out.println("이미 사용중인 아이디입니다");
							idcheck = false; break;
						}//if e
					}//for e
					//3.아이디 중복 흐름제어
					if(idcheck) {
				System.out.println("비밀번호 : ");	String pw = scanner.next();
				System.out.println("이름 : ");	String name = scanner.next();
				System.out.println("전화번호 : ");	String phon = scanner.next();
				//4.입력받은 배열에 저장한다[배열호출]
					//4-1.배열내 빈행을 찾는다
				for(int row = 0 ; row < memberlist.length ; row++) {
					if(memberlist[row][0] == null) {
						//row번째 아이디가 null이면 회원이 없다
						//2-2. null 행 위치에 입력받은 데이터 하나씩 대입
						memberlist[row][0] = id;
						memberlist[row][1] = pw;
						memberlist[row][2] = name;
						memberlist[row][3] = phon;
						System.out.println("안내) 회원가입 성공");
						//2-3저장 후 반복문 종료(안하면 모든 null에 저장)
						break;
					}//if e
					if(row == 99) {System.out.println("안내)최대 회원수가 찼습니다[관리자에게 문의하기]");}
				}//for e
			}//if e
			}//2 입력
			else if( btn == 3 ){
				System.out.println("=================아이디 찾기==================");
				//1. 이름, 전화번호 입력받기
				System.out.println("이름 : ");	String name = scanner.next();
				System.out.println("전화번호 : ");	String phon = scanner.next();
				//2. 배열내 모든 항목 비교해서 동일한 이름,전화번호
				for(int i = 0 ; i < memberlist.length ; i++) {
					if(memberlist[i][0] != null &&
						memberlist[i][2].equals(name)&&
						memberlist[i][3].equals(phon)) {
					System.out.println("안내) 회원님의 아이디 : " + memberlist[i][0]);
					break;
					}//if e
					if(i==memberlist.length-1) {//모두 검사했는데 조건을 못찾음
						System.out.println("안내) 동일한 회원 정보가 없습니다");
					}//if e
				}//for e 
				//3. 존재하면 해당 아이디 출력 아니면 미출력
			}//3 입력
			else if( btn == 4 ){
				System.out.println("=================비밀번호 찾기==================");
				//1.아이디,전화번호 입력받기
				System.out.println("아이디 : ");	String id = scanner.next();
				System.out.println("전화번호 : ");	String phon = scanner.next();
				//2. 배열내 모든 항목 비교해서 동일한 이름,전화번호
				for(int i = 0 ; i < memberlist.length ; i++) {
					if(memberlist[i][1] != null &&
						memberlist[i][0].equals(id)&&
						memberlist[i][3].equals(phon)) {
					System.out.println("안내) 회원님의 비밀번호 : " + memberlist[i][1]);
					break;
					}//if e
					if(i==memberlist.length-1) {//모두 검사했는데 조건을 못찾음
						//인덱스 = 길이-1
						System.out.println("안내) 동일한 회원 정보가 없습니다");
					}//if e
				}//for e 
				//3. 존재하면 해당 비밀번호 출력 아니면 비밀번호 출력
			}//4 입력
			else {System.out.println("안내) 알 수 없는 번호 입니다");}//그 외 입력
		}//while e
	}//main e
}//class e
/*
 	회원제 프로그램 구현
 		[조건]
 			1.회원가입 기능
 				아이디 비밀번호 이름 전화번호
 				배열 내 빈 공간의 인덱스를 찾아서 회원정보 넣기
 					string = null
 					int = 0 
 					double = 0.0
 					boolean = false
 				아이디 중복체크
 				최대 회원 100명
 				*1명 4개 > 400개 변수 > 2차원변수사용[100][4]
 				*행 = 1명
 				*0열 = 아이디 1열 = 비밀번호 2열 = 이름 3열 = 전화번호
 			2.로그인 기능
 				아이디 비밀번호가 동일하면 로그인 성공
 			3.아이디찾기 기능
 				이름 전화번호 동일하면 아이디정보 제공
 			4.비밀번호찾기 기능
 				아이디 전화번호 동일하면 비밀번호정보 제공
 			
 		[출력]
 			1.메뉴: 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
 */