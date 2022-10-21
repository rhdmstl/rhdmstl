package modle;

public class misroomDTO {
	//필드
	private int mno;
	private String mname;
	private String mid;
	private String mpw;
	private String mphone;
	public misroomDTO() {
		super();
	}
	public misroomDTO(int mno, String mname, String mid, String mpw, String mphone) {
		super();
		this.mno = mno;
		this.mname = mname;
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
		return "misroomDTO [mno=" + mno + ", mname=" + mname + ", mid=" + mid + ", mpw=" + mpw + ", mphone=" + mphone
				+ "]";
	}
	
	
}
