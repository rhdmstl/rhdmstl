package a변수;

public class EX_문자열 {
	public static void main(String[] args) {
		// p.64 String 타입 [ String 클래스 ]
			// char 문자 = "자바"; // 오류발생 : char 문자 한개만 저장할수 있다.
		String 문자열 = "자바";
		
		
		//65p
		String name = "홍길동";	System.out.println(name);
		String job = "개발자";	System.out.println(job);
		
		//66p
		System.out.println("안녕하세요");
		System.out.print("자바입니다");		// print : 출력후 줄바꿈처리 X 
		System.out.println("하하");
		
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는\"개발자\"입니다");
		System.out.println("봄\\여름\\가을\\겨울");
		
		
		/*  예제1 ) console 에 토끼모양 출력
		\    /\
		 )  ( ')
		(  /  )
		 \(__)|
	
		*/
		System.out.println("\n-----------------");
	 //예
		System.out.println("\\  /\\");
		System.out.println(") ( ')");
		System.out.println("( / )");
		System.out.println("\\(__)");
	/*
	    예제2 ) 강아지 console 출력
		|\_/|
		|q p|   /}
		( 0 )"""\
		|"^"`    |
		||_/=\\__|
	 */
		// 예2)
				System.out.println("|\\_/|");
				System.out.println("|q p |  /}");
				System.out.println("( 0 )\"\"\"\\");
				System.out.println("|\"^\"`    |");
				System.out.println("||_/=\\\\__|");
	/*
	    예제3 ) 출석부 출력
	    	            [[ 출석부 ]]
		 --------------------------------------
		 이름			1교시	    2교시	    3교시
		 강호동		출석		결석		출석
		 유재석		출석		결석		출석
		 --------------------------------------
		*/		
	 
	
	// 예3)
		System.out.println("\t[[출석부]]");
		System.out.println("\n--------------");
		System.out.println("\n이름\t1교시\t2교시\t3교시");
		System.out.println("\n유재석\t출석\t결석\t출석");
		System.out.println("\n강호동\t출석\t결석\t출석");
		System.out.println("\n---------------");
		
		
	}
}

/*
문자[ 한글자 ]			: char		:	'자'
문자열[ 두글자 이상 ]	: String	:	"자바 입니다"

- console 화면에 출력하는 함수
	print()		: 출력
	println()	: 출력 후 줄바꿈[\n] 포함
	printf()	: 형식문자 출력 

- 제어[이스케이프] 문자
	1. \n : 줄바꿈	2.\t : 들여쓰기[tab 5칸]
	3. \특수문자 : 특수문자 출력	
		"홍길동" ----> 홍길동 
		"\"홍길동\""----> "홍길동"
		
*/
