package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.boardDao;
import model.Dao.memberDao;


@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {  super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션호출
		String mid = (String)request.getSession().getAttribute("mid");
		int mno = memberDao.getInstance().getMno(mid);
		System.out.println(mno);
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		boolean result = boardDao.getInstance().write(btitle, bcontent,mno);
		
		System.out.println(result);
		/*form 전송용*/
		//if(result) {response.sendRedirect("list.jsp");}
		//else {response.sendRedirect("write.jsp");}
		
		/*js용*/
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
