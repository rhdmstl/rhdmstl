package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao.memberDao;

@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public login() {super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		
		int result = memberDao.getInstance().login(mid, mpassword);
		//만약 로그인 성공하면 세션에 메모리할당
		if(result== 1) {
			HttpSession tptus = request.getSession(); //객체생성
			tptus.setAttribute("mid", mid); //setAttribute(식별자 , 데이터)
		}
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//form에서 변수 요청
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		
		
//		int result = memberDao.getInstance().login(mid, mpassword);
		
///		if(result) {response.sendRedirect("/jspweb/index.jsp");}
//		else {response.sendRedirect("/jspweb/login.jsp");}
	}
}
