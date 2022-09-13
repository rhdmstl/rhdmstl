package EX6;

public class Member {
	//필드
	String id;
	String password;
	String name;
	int point;
	
	//생성자
		//빈생성자
	public Member() {}
	Member(String id,String password,String name,int point){
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}
		//회원수정시 사용되는 객체 생성자
	Member(String password){
		this.password = password;
	}
		//로그인시 사용되는 생성자
	Member(String id,String password){
		this.id = id;
		this.password = password;
	}
	//메소드(는 9/14다시,,)
}
