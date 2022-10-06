package ch8;

// 클래스 선언 : 접근제한자 class명 {}
//인터페이스 선언 : 접근제한자 interface 인터페이스명{}
//동일한 목적과 기능 수행하기 위함 -> 여러기능 수행

public interface RemoteControl {
	//변수(변하는 수) VS 상수(고정된수)
	//[static(먼저) final(수정불가)] : 상수 키워드 생략시 자동으로 상수 선언
	//초기값 필수(선언시 대입하는 값) 
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//추상메소드[abstract] 생략 : 추상키워드 생략시 자동으로 추상 선언
	//선언만 해야함 {} -> 쓰면안됌
	public abstract void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	
	
}
