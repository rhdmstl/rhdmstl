package ch8;

public class Television implements RemoteControl{
						//[implements] 구현하다 . class (추상도구현)
						//구현 클래스
	private int volume;
	
	//RemoteControl 인터페이스의 추상메소드를 구현하자
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");	
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 TV volume : " + this.volume);
	}
	
}
