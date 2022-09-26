package ch12;

public class Music extends Thread{
	//run 제어 메소드
	private boolean stop = true;
	
	public void setstop(boolean stop) {this.stop = stop;}
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("music start");
			try { Thread.sleep(1000); } 
			catch (InterruptedException e) { }
		}//while e
	}//run e
}
