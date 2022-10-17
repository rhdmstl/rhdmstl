package modle;

public class misroomDTO {
	private int mno;
	private String mid;
	private String mpw;
	private String mphone;
	public misroomDTO() {
		super();
	}
	public misroomDTO(int mno, String mid, String mpw, String mphone) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
		this.mphone = mphone;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	@Override
	public String toString() {
		return "misroomDTO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mphone=" + mphone + "]";
	}
	
}
