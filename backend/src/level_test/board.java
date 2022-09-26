package level_test;

public class board {
	//필드
		String 작성자; //상자크기 상자이름;[자료형 변수명]
		String 방문록;
		
		//생성자
				//기본생성자
		board(){}
				//풀생성자

		public board(String 작성자, String 방문록) {
			super();
			this.작성자 = 작성자;
			this.방문록 = 방문록;
		}
			
}
