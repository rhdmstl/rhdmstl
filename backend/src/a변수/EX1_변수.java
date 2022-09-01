package a변수; //패키지명 48p

public class EX1_변수 {
	//[main함수] 코드를 읽어줌
	public static void main(String[] args) {
		//변수[1개 이상 저장하는 수]
		int value;
		value = 10;
		System.out.println(value); //console출력함수
		
		int result = value +  10;
		System.out.println(result);
		
		//53p
		int hour = 3;
		int minute = 5;
		System.out.println(hour+"시간" + minute+"분");
		int totalMinute = (hour*60)+minute; 			//더하기연산자(변수만있음)
				System.out.println("총"+totalMinute+"분");//연결연산자(문자열이 포함됨)
				
		int x= 3;
		int y= 5;
		System.out.println("x : "+x+" , y : "+y);
		
		//[temp] 임시변수 생성
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x : "+x+" , y : "+y);
	}
}
