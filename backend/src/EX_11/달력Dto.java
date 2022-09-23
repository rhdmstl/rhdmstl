package EX_11;

import java.util.Date;

public class 달력Dto {
	int cno;
	Date cdate ;
    String ccomment;
    
	public 달력Dto() {}

	public 달력Dto(int cno, Date cdate, String ccomment) {
		super();
		this.cno = cno;
		this.cdate = cdate;
		this.ccomment = ccomment;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCcomment() {
		return ccomment;
	}

	public void setCcomment(String ccomment) {
		this.ccomment = ccomment;
	}
    
	
    
}
