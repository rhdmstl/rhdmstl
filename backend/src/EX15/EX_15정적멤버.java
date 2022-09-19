package EX15;

public class EX_15정적멤버 {
	//1.필드
	double pi1 = 3.14159;			//인스턴스필드	=	객체마다 메모리 할당
	static double pi2 = 3.14159;	//정적필드	=	메소드 영역 메모리 할당
	
	int plus1(int x,int y) {
		return x+y;
	}
	
	static int plus2(int x,int y) {
		return x+y;
	}
	
	int minus(int x , int y) {return x-y;}
	
	static int minus2(int x, int y) {return x-y;}
}
