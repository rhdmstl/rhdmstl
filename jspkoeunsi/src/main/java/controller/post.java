package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import modle.DTO;
import modle.memberDao;

@WebServlet("/post")
public class post extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public post() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String mtitle = request.getParameter("mtitle");
		String mcontent = request.getParameter("mcontent");
		String mwtiter = request.getParameter("mwtiter");
		String mpw = request.getParameter("mpw");
		
		DTO dto = new DTO(0, mtitle, mcontent, mwtiter, mpw, mpw, 0);
		
		boolean result = memberDao.getInstance().post(dto);
		
		if(result) {System.out.println("글등록 성공");}
		else {System.out.println("글등록 실패");}
		response.getWriter().print(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
