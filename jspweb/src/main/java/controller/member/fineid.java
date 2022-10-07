package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.memberDao;

@WebServlet("/member/fineid")
public class fineid extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public fineid() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //요펑시 한글인코딩
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		String result = memberDao.getInstance().fineid(mname, memail);
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
