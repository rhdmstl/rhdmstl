package EX15;

public class EX_15실행 {
	public static void main(String[] args) {
		//정적멤버 호출
			//클래스명.정적멤버
		double result = EX_15정적멤버.pi2;
		EX_15정적멤버.plus2(10,5);
		EX_15정적멤버.minus2(10,5);
			//static멤버가 아닌건 호출 x
			//->객체생성하면 됌
		
		//인스턴스 멤버호출
			//객체명.인스턴스멤버
		EX_15정적멤버 c = new EX_15정적멤버();
		double result2 = c.pi2;
		c.plus1(10,5);
		c.minus(10,5);
	}
}
