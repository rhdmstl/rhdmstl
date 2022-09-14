package EX12;

public class Contorller {
	static Board[] boadlist = new Board[100];
	
	static boolean con_regist(String title , String content , String writer , String password ) {
		//1.객체생성
		Board board = new Board(title,content,writer,password,0);
		//2.배열에 빈공간에 배치
		for(int index = 0 ; index<boadlist.length ; index++) {
			if(boadlist[index] == null) {
				boadlist[index] = board;
				return true;
			}
		}
		return false;//게시물 등록 실패
	}
	
}
