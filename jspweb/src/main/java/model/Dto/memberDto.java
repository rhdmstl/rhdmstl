package model.Dto;

public class memberDto {
	//DB테이블명 <-필드명->
		private int mno;
		private String mid;
		private String mpw;
		private String mname;
		private String mphone;
		private String memail;
		private String maddress;
		private String mdate;
		private int mpoint;
		
		public memberDto() {
			super();
		}
		public memberDto(int mno, String mid, String mpw, String mname, String mphone, String memail, String maddress,
				String mdate, int mpoint) {
			super();
			this.mno = mno;
			this.mid = mid;
			this.mpw = mpw;
			this.mname = mname;
			this.mphone = mphone;
			this.memail = memail;
			this.maddress = maddress;
			this.mdate = mdate;
			this.mpoint = mpoint;
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
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getMphone() {
			return mphone;
		}
		public void setMphone(String mphone) {
			this.mphone = mphone;
		}
		public String getMemail() {
			return memail;
		}
		public void setMemail(String memail) {
			this.memail = memail;
		}
		public String getMaddress() {
			return maddress;
		}
		public void setMaddress(String maddress) {
			this.maddress = maddress;
		}
		public String getMdate() {
			return mdate;
		}
		public void setMdate(String mdate) {
			this.mdate = mdate;
		}
		public int getMpoint() {
			return mpoint;
		}
		public void setMpoint(int mpoint) {
			this.mpoint = mpoint;
		}
		
		
}
