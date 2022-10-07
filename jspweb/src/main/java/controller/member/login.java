package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
