package EX12비회원게시판_함수;

public class Contorller {
	static Board[] boadlist = new Board[100];
	
	//1.게시물 등록 함수
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
	}//m e
	
	//2.게시물 삭제 함수
	static boolean con_delete(int bnum , String password) {
		if(boadlist[bnum].equals(password)) {
			for(int i = bnum ; i < boadlist.length ; i++) {
				boadlist[i] = boadlist[i+1];
				if(boadlist[i+1]== null) {break;}
			}//for e
			return true;
		}//if e
		else {return false;}
	}//boolean e
	
	//3.게시물 수정함수
	static boolean con_update(int bnum , String password , String title , String content) {
		if(boadlist[bnum].password.equals(password)) {
			boadlist[bnum].title = title;
			boadlist[bnum].content = content;
			return true;
		}else {return false;}
	}//boolean e
}
