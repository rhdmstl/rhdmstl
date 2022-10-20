package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.misroomDao2;

/**
 * Servlet implementation class misrPW
 */
@WebServlet("/misrPW")
public class misrPW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public misrPW() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String mphone = request.getParameter("mphone");
		
		boolean result = misroomDao2.getInstance().findPW(mid, mphone);
		//랜덤 문자열 저장할 공백임
		String ranstr = "";
		// 
		if(result) {
			//랜덤객체 생성
			Random ran = new Random();
			for(int i = 0 ; i <= 15 ; i++) {
				//숫자 -> 강제형변환[문자로 변환] *영소문자[아스키코드] = 97~122
				ranstr += (char)(ran.nextInt(26)+97);
			}
			misroomDao2.getInstance().PWchage(mid, ranstr);
		}
		response.getWriter().printf(ranstr);	//ajax 전송
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
