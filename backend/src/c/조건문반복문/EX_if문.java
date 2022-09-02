package c.조건문반복문;

public class EX_if문 {
	public static void main(String[] args) {
		
		//연습
		if( 3 > 1) System.out.println("예1) 3이 1보다크다");//참 실행문이 1개 = {} 생략가능
		//if(3 > 5) System.out.println("예1) 3이 5보다크다"); //조건 = true 실행 / false 실행안됨
		
		//p.136
		int score = 93;
		if(score >= 90) { //실행문(;) 2개 이상이면 {}로 묶음
			System.out.println("점수가 90점보다 큽니다");
			System.out.println("등급은 A입니다");
		}//if e
		if(score < 90) { 
			System.out.println("점수가 90점 이하입니다");
			System.out.println("등급은 B입니다");
		}//if e
		
		//137p
		int score2 = 85;
		if(score2 >= 90) {
			System.out.println("점수가 90보다 큽니다");
			System.out.println("등급은 A입니다");
		}//if e
		else {
			System.out.println("점수가 90점 이하입니다");
			System.out.println("등급은 B입니다");
		}//else e
		
		//138p	조건이 다수일때 else if
		int score3 = 75;
		if(score3>=90) {
			System.out.println("점수가 100~90점입니다");
			System.out.println("등급은 A입니다");
		}
		else if(score3 >= 80) {
			System.out.println("점수가 80~89점입니다");
			System.out.println("등급은 B입니다");
		}
		else if(score3 >= 70) {
			System.out.println("점수가 70~79점입니다");
			System.out.println("등급은 C입니다");
		}
		else {System.out.println("점수가 70점 미만입니다"); System.out.println("등급은 D입니다");}
		
		//예제6
		int score4 = 95;	char 성별 = 'M';
		if(score4 == 100) {
			if(성별 == 'M') {
				System.out.println("100점이면서 남자이다");
			}else {System.out.println("100점이면서 여자이다");}
		}else {
			if(성별 == 'F') {
				System.out.println("100점 아니면서 여자이다");
			}else {System.out.println("100점 아니면서 남자이다");}
		}
	}
}
