package d.배열;

import java.util.Scanner;

public class EX_비회원제게시판 {
		 public static void main(String[] args) {//main S
			 String[][]textlist=new String[100][4];//2차원배열=좌표설정을 통한 명령어 및 변수 최소화  
		     Scanner scanner = new Scanner(System.in); 
		     
		     while(true) {//무한루프 24시간 가동을 위한 코드
		         System.out.println("---------커뮤니티-------------");
		         System.out.println("번호\t 작성자\t \t제목");
			       
		         	for(int i=0;i<textlist.length;i++) {//2차원 배열 검색 0부터 99까지
			        	 	if(textlist[i][0]!=null) {
			        	 		System.out.print(i+"\t");
			        	 		System.out.print(textlist[i][2]+"\t\t");
			        	 		System.out.print(textlist[i][0]+"\n");
			        	 	}//if E  //2차원 리스트의 인덱스 번호와 작성자 제목을 표시
			         }//for E
		         
		         System.out.println("1.글쓰기\t 2.글보기\t \t선택 ");int num=scanner.nextInt();
		         //선택 페이지로 이동하기위한 입력받기
		         
		         
		         if(num==1){  	 
		            System.out.println("================글쓰기=============");
		            System.out.print("title :");String title=scanner.next();//제목 입력받기 
		            System.out.print("content :");String content=scanner.next();//내용 입력받기 
		            System.out.print("writer :");String writer=scanner.next();//작성자 입력받기 
		            System.out.print("password :");String password=scanner.next();//비번 입력받기 
		            for(int i=0;i<textlist.length;i++) {//2차원 배열 찾기 
		            if(textlist[i][0]==null) {//만약에 제목이 null이면 
		            textlist[i][0]=title;	textlist[i][2]=writer;
		            textlist[i][1]=content;	textlist[i][3]=password;
		            System.out.println("글이등록되었습니다."); break;//0,1,2,3,의 내용을 입력하고 반복문 while문으로 탈출 
		            }
		            if(i==99) {System.err.println("최대게시물를 초과할수 없습니다.[최대게시물100개]");}
		            //만약에 2차원 배열이 100개가 생성되면 초과될수 없음을 안내 
		            } 
		         }
		         
		         
		         else if(num==2){	
		        	 System.out.println("게시글을 선택하세요 ");int numT=scanner.nextInt();//보고싶은 게시물 선택을 받기위한  scanner	
		        		System.out.println("=========게시물 상세페이지=============");
		        		System.out.print("작성자 :"+ textlist[numT][2]);
		        		System.out.print("\n 제목 :"+ textlist[numT][0]);
		        		System.out.println("\n내용 :"+textlist[numT][1]);
		        		 System.out.println("1.목록보기 2.글삭제 3.글수정 \n선택");int ee=scanner.nextInt();
		        	
		        		//글 페이지에서 다음 원하는 항목 선택을 받기위한 scanner
		        		if(ee==1) //1.목록보기 선택시
		        		{continue;}//while문으로 탈출 [처음 화면으로 이동]
		        		else if(ee==2) //2.글삭제 선택시 
		        			
		        		{System.err.print("비밀번호를 입력하세요");String num2 =scanner.next();
		        			//입력한 비밀번호 확인하기위한 scanner
		        		if(textlist[numT][3]!=null&&textlist[numT][3].equals(num2)) {//만약에 입력한 비밀번호가 같으면 아래 코드 실행 
			        		textlist[numT][0]=null;	textlist[numT][1]=null;//저장된 값을 null로 바꾸고 
			        		textlist[numT][2]=null;	textlist[numT][3]=null;
			        		for(int a=numT;a<textlist.length; a++) {//알려주세요 
			        			textlist[a][0]=textlist[a+1][0];
			        			textlist[a][1]=textlist[a+1][1];
			        			textlist[a][2]=textlist[a+1][2];
			        			textlist[a][3]=textlist[a+1][3];
			        			if(textlist[a+1][0]==null){break;}	
			        			
		        		}//for E
			        		System.out.println("-------글이 삭제되었습니다-------.");
			        		
			        		//break가 있으면 전체 삭제됨
		        		}//if E
		        		else {System.err.println("비밀번호가 일치하지 않습니다."); break;}//일치하지 않으면 초기화면으로 이동 
		        		}//else if E
		        		else if(ee==3)//3.글수정 선택시
		        			{
		        			 System.err.println("현 게시물의 비밀번호 :"+textlist[numT][3]);//현 게시물의 비밀번호 출력
		        			 
		        			 System.out.println("수정할 제목을 입력해주세요\n"+textlist[numT][0]);
		        			 String change=scanner.next();//수정할제목 입력받기
		        			  if(textlist[numT][0]!=null) {//만약에 제목이 null이 아니고 =내용이 있으면
		        				   textlist[numT][0]=change;//입력받은 값을 대입하고 탈출
		        			   } 
		        			 System.err.println("제목수정이 완료되었습니다");
		        			 
		        			 System.out.println("수정할 내용을 입력해주세요\n"+textlist[numT][1]);
		        			 String change2=scanner.next();//수정할제목 입력받기
		        			  if(textlist[numT][1]!=null) {//만약에 내용이 null이 아니고 =내용이 있으면
		        				   textlist[numT][1]=change2;//입력받은 값을 대입하고 탈출
		        			   }//if E	
		        			 System.err.println("내용수정이 완료되었습니다");continue;
		        			  
		        			  
		        		}//else if E
		        	
		         }//else if E
		         
		         else {System.out.println("입력할수 없는 번호입니다."); }//리스트에있는 숫자가 아닐때 출력 
		          
		      }//whlie E
		      
		
		   }//main E

	}//class E