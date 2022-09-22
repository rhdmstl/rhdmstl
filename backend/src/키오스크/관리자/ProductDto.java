package 키오스크.관리자;

public class ProductDto {
	private int pno;
	private String pname;
	private int price;
	private String pcomment;
	private short pamount;
	private byte mno;
	
	//생성자를 외부에서 쓸수 있도록 private는 사용하지않음 (싱글톤에서는 사용하기도함)
	public ProductDto() {}

	public ProductDto(int pno, String pname, int price, String pcomment, short pamount, byte mno) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.pcomment = pcomment;
		this.pamount = pamount;
		this.mno = mno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcomment() {
		return pcomment;
	}

	public void setPcomment(String pcomment) {
		this.pcomment = pcomment;
	}

	public short getPamount() {
		return pamount;
	}

	public void setPamount(short pamount) {
		this.pamount = pamount;
	}

	public byte getMno() {
		return mno;
	}

	public void setMno(byte mno) {
		this.mno = mno;
	}
	
}
