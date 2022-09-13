package EX7비회원제게시판;

public class Board {
	//클래스멤버
	
	//필드
	String title; //상자크기 상자이름;[자료형 변수명]
	String content;
	String writer;
	String password;
	int viwe;//데이터 자료형이랑 달라도 저장이됌
	
	//생성자
		//기본생성자
	Board(){}
		//풀생성자
	Board(String  title,String  content,String  
			writer,String  password,int viwe){
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.viwe = viwe;
	}
	//메소드
}
