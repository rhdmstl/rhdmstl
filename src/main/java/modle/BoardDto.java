package modle;

public class BoardDto {
	private int tno;
	private String ttitle;
	private String tcontent;
	private String twriter;
	private String tpw;
	private String tdate;
	private int tview;
	public BoardDto(int tno, String ttitle, String tcontent, String twriter, String tpw, String tdate, int tview) {
		super();
		this.tno = tno;
		this.ttitle = ttitle;
		this.tcontent = tcontent;
		this.twriter = twriter;
		this.tpw = tpw;
		this.tdate = tdate;
		this.tview = tview;
	}
	public BoardDto() {
		super();
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getTwriter() {
		return twriter;
	}
	public void setTwriter(String twriter) {
		this.twriter = twriter;
	}
	public String getTpw() {
		return tpw;
	}
	public void setTpw(String tpw) {
		this.tpw = tpw;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public int getTview() {
		return tview;
	}
	public void setTview(int tview) {
		this.tview = tview;
	}
	@Override
	public String toString() {
		return "BoardDto [tno=" + tno + ", ttitle=" + ttitle + ", tcontent=" + tcontent + ", twriter=" + twriter + ", tpw="
				+ tpw + ", tdate=" + tdate + ", tview=" + tview + "]";
	}
	
	
}
