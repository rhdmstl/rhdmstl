package model.Dto;

public class orderDto {
	private int ono;
	private String oname;
	private String ophon;
	private String oaddress;
	private String orequest;
	private String odate;
	private int mno;
	private int odno;
	private int odamount;
	private int odprice;
	private int odactive;
	private int pstno;
	public orderDto() {
		super();
	}
	public orderDto(int ono, String oname, String ophon, String oaddress, String orequest, String odate, int mno,
			int odno, int odamount, int odprice, int odactive, int pstno) {
		super();
		this.ono = ono;
		this.oname = oname;
		this.ophon = ophon;
		this.oaddress = oaddress;
		this.orequest = orequest;
		this.odate = odate;
		this.mno = mno;
		this.odno = odno;
		this.odamount = odamount;
		this.odprice = odprice;
		this.odactive = odactive;
		this.pstno = pstno;
	}
	public int getOno() {
		return ono;
	}
	public void setOno(int ono) {
		this.ono = ono;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOphon() {
		return ophon;
	}
	public void setOphon(String ophon) {
		this.ophon = ophon;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public String getOrequest() {
		return orequest;
	}
	public void setOrequest(String orequest) {
		this.orequest = orequest;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getOdno() {
		return odno;
	}
	public void setOdno(int odno) {
		this.odno = odno;
	}
	public int getOdamount() {
		return odamount;
	}
	public void setOdamount(int odamount) {
		this.odamount = odamount;
	}
	public int getOdprice() {
		return odprice;
	}
	public void setOdprice(int odprice) {
		this.odprice = odprice;
	}
	public int getOdactive() {
		return odactive;
	}
	public void setOdactive(int odactive) {
		this.odactive = odactive;
	}
	public int getPstno() {
		return pstno;
	}
	public void setPstno(int pstno) {
		this.pstno = pstno;
	}
	@Override
	public String toString() {
		return "orderDto [ono=" + ono + ", oname=" + oname + ", ophon=" + ophon + ", oaddress=" + oaddress
				+ ", orequest=" + orequest + ", odate=" + odate + ", mno=" + mno + ", odno=" + odno + ", odamount="
				+ odamount + ", odprice=" + odprice + ", odactive=" + odactive + ", pstno=" + pstno + "]";
	}
}
