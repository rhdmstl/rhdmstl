package ch8;

public class Car {
	Tire frontLeftTire = new HankokTire();
	Tire frontRightTire = new HankokTire();
	Tire backLefrTire = new HankokTire();
	Tire backRightTire = new HankokTire();
	
	void run() {
		frontLeftTire.roll();	frontRightTire.roll();
		backLefrTire.roll();	backRightTire.roll();
	}
}
