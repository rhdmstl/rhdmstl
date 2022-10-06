package 예외처리;

public class EX1_예외처리 {
	public static void main(String[] args) {
		//String date = null;
		//System.out.println(date.toString());
		
		/*
		System.out.println(args);
		String date1 = args[0];
		String date2 = args[1];
		System.out.println("date1 : "+date1);
		System.out.println("date1 : "+date2);
	
		
		int[] 정수배열 = new int [3];
		for(int i = 0 ; i <= 정수배열.length ; i++) {
			System.out.println(정수배열[i]);}
			
		
		String date1 = "100";
		String date2 = "a100";
		
			//static 메소드는 바로 저장 클래스명.메소드명()
		int value1 = Integer.parseInt(date1);
		int value2 = Integer.parseInt(date2);
		
		int result = value1 + value2; 
		System.out.println(date1+"+"+date2+"="+result);
		*/
		
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
		
	}
	
									//다형성코드
	public static void changeDog(Animal animal) {
		//if(animal instanceof Dog) = 오류가 낫음
		Dog dog = (Dog)animal;
	}
}
