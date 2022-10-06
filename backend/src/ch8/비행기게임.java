package ch8;

public class 비행기게임 implements 게임패드{
		//구현하다
	@Override
	public void A번튼() {System.out.println("미사일발사");}
	
	@Override
	public void B번튼() {System.out.println("비행기 교체");}
	
	@Override
	public void C번튼() {System.out.println("폭탄 던지기");}
}
