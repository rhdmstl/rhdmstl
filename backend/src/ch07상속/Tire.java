package ch07상속;

public class Tire {
	// 1. 필드
		public int maxRotation; // 최대 회전수( 타이머수명 ) 
		public int accumulatedRotation; // 누적 회전수
		public String location;
		public Tire(int maxRotation, String location) {
			this.maxRotation = maxRotation;
			this.location = location;
		}
		public boolean roll() {
			++accumulatedRotation;	// 누적 회전수 1씩증가 
			if( accumulatedRotation < maxRotation ) { // 최대회전수 보다 누적회전수가 더 작으면 [ 수명남음 ]
				System.out.println( location + " Tire 수명 : " 
					+ (maxRotation-accumulatedRotation) + "회");
				return true; // 수명 있을경우 true
			}else {
				System.out.println("*** " + location +" Tire 펑크 ***");
				return false; // 수명 없을경우 false [ 펑크 일경우 ]
			}
		}
}
