package 예외처리;

public class EX1_예외처리2 {
	public static void main(String[] args) {
		
		//try/catch != 수정 || == 대처방안
		
		//0.
		try {
			Class clazz = Class.forName("java.lang.string2");
		} catch (ClassNotFoundException e) {System.out.println("클래스가 존재하지않습니다"+e);
		}finally {
			System.out.println("무조건 실행");
		}
		
		try {
		String date = null;
		System.out.println(date.toString());
		} catch (NullPointerException e) {System.out.println("객체의 내용이 없습니다"+e);}
		
		try {
		System.out.println(args);
		String date1 = args[0];
		String date2 = args[1];       
		System.out.println("date1 : "+date1);
		System.out.println("date1 : "+date2);
		} catch (ArrayIndexOutOfBoundsException e) {System.out.println("배열의 데이터가 없습니다"+e);}
	
		try {
		int[] 정수배열 = new int [3];
		for(int i = 0 ; i <= 정수배열.length ; i++) {
			System.out.println(정수배열[i]);}
		} catch (ArrayIndexOutOfBoundsException e) {System.out.println("배열의 없는 인덱스입니다"+e);}
		
		try {
		String date1 = "100";
		String date2 = "a100";
		
			//static 메소드는 바로 저장 클래스명.메소드명()
		int value1 = Integer.parseInt(date1);
		int value2 = Integer.parseInt(date2);
		
		int result = value1 + value2; 
		System.out.println(date1+date2+"="+result);
		} catch (NumberFormatException e) {System.out.println("정수형 변환 실패"+e);}
		
		try {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
		} catch (ClassCastException e) {System.out.println("클래스형 변환 실패"+e);}
		
	}
	
									//다형성코드
	public static void changeDog(Animal animal) {
		//if(animal instanceof Dog) = 오류가 낫음
		Dog dog = (Dog)animal;
	}
}
