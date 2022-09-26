package ch12;

public class Movie implements Runnable{
	private boolean stop = true;
	
	public void setStop(boolean stop) {this.stop = stop;}
	
	@Override        
	public void run() {
		while(stop) {
		System.out.println("movie start");
		try { Thread.sleep(1000); } 
		catch (InterruptedException e) { }
		}
	}
}
