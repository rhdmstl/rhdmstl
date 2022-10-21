package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.memberDao;

@WebServlet("/member/finepw")
public class finepw extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public finepw() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //요펑시 한글인코딩
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		boolean result = memberDao.getInstance().finepw(mid, memail);
		String randstr = "";	//랜덤문자열을 저장
		//아이디와 이메일이 동일할 경우[true] 임시비번 생성
		if(result) {	//문자난수 15자리 : 랜덤클래스[임시비밀번호]
			Random random = new Random();
			
			for(int i = 0 ; i <=15 ; i++) {
				randstr += (char)(random.nextInt(26)+97);	//숫자 -> 강제형변환[문자로 변환] *영소문자[아스키코드] = 97~122
			}//for e
			//회원 비밀번호를 임시번호로 교체
			memberDao.getInstance().passwordchange(mid, randstr);
		}//if e
		response.getWriter().printf(randstr);	//ajax 전송
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
