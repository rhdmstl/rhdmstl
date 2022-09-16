package EX12비회원게시판_함수;

public class Board {
	String title;
	String content;
	String writer;
	String     password;
	int view;
	
	//생성자
	public Board() {}

	public Board(String title, String content, String writer, String password, int view) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.view = view;
	}
	
	       
	
}
