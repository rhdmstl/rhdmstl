package ch12;

import java.util.Scanner;

public class EX4_예제1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean musicstart = false;	//재생여부 판단변수
		Music music = new Music();//music 선언
		
		boolean moviestart = false;//movie 재생여부 판단 변수
		Movie movie = new Movie();
		Thread thread = new Thread(movie);
		
		while(true) {
			
			if(musicstart == false) System.out.println("1. music[ing]");
			else System.out.println("1.music stop");
			
			if(moviestart == false) System.out.println("2. movie[ing]");
			else System.out.println("2.movie stop");
			
			System.out.println("1.music 2.movie");
			
			int ch = scanner.nextInt();
			
			if(ch == 1 && musicstart == false) {
				music.start();
				musicstart = true;	//기록
				}//music start
			else if(ch == 1 && musicstart == true) {
				music.setstop(false);//music stop
				musicstart = false;		
				music = new Music();
			}
			
			if(ch == 2 && moviestart == false) {
				thread.start();
				moviestart = true;	//기록
			}
			else if(ch == 2 && moviestart == true) {
				movie.setStop(false);
				moviestart = false;
				movie = new Movie();
				thread = new Thread(movie);
			}
		}
		
	}
}
