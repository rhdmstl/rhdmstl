package EX_14인스턴스;

public class EX14실행 {
	public static void main(String[] args) {
		Car mycar = new Car("포르쉐");
		Car yourcar = new Car("벤츠");
		
		mycar.run();
		yourcar.run();
	}
}
