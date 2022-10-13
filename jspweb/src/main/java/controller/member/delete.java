package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.memberDao;

@WebServlet("/member/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 변수 요청 
		String mpassword = request.getParameter("mpassword");
		//세션 호출
		String mid = (String)request.getSession().getAttribute("mid");
		//2.Dao
		boolean result = memberDao.getInstance().delete(mid, mpassword);
		//4.
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
