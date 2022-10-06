package 예외처리;

public class EX_3예외던지기 {
	public static void main(String[] args){
		//메인은 못던짐  throws Exception 
		
		try {findClass();}
		catch(Exception e){System.out.println("함수에서 온 예외"+e);}
	}
									//예외 던지기 : 해당 메소드를 호출했던 곳으로 던지기
	public static void findClass() throws ClassNotFoundException {
		Class class1 = Class.forName("java.lang.string2");//예외 발생 시점
	}
	
}
