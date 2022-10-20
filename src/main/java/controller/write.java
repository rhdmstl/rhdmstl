package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.BoardDao;
import modle.BoardDto;

@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String ttitle = request.getParameter("ttitle");
		String tcontent = request.getParameter("tcontent");
		String twriter = request.getParameter("twriter");
		String tpw = request.getParameter("tpw");
		
		boolean result = false;
				
		if(result)response.getWriter().print("1");
		else {response.getWriter().print("2");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
