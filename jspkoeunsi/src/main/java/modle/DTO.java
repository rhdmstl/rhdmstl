package modle;

public class DTO {
	int mno;
	String mtitle;
	String mcontent;
	String mwtiter;
	String mpw;
	String mdate;
    int mview;
	public DTO() {
		super();
	}
	public DTO(int mno, String mtitle, String mcontent, String mwtiter, String mpw, String mdate, int mview) {
		super();
		this.mno = mno;
		this.mtitle = mtitle;
		this.mcontent = mcontent;
		this.mwtiter = mwtiter;
		this.mpw = mpw;
		this.mdate = mdate;
		this.mview = mview;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMwtiter() {
		return mwtiter;
	}
	public void setMwtiter(String mwtiter) {
		this.mwtiter = mwtiter;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getMview() {
		return mview;
	}
	public void setMview(int mview) {
		this.mview = mview;
	}
	@Override
	public String toString() {
		return "DTO [mno=" + mno + ", mtitle=" + mtitle + ", mcontent=" + mcontent + ", mwtiter=" + mwtiter + ", mpw="
				+ mpw + ", mdate=" + mdate + ", mview=" + mview + "]";
	}
	
}
