package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modle.misroomDTO;
import modle.misroomDao2;

@WebServlet("/misroom")
public class misroom extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public misroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디중복체크
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		
		boolean result =  misroomDao2.getInstance().idcheck(mid);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입
		request.setCharacterEncoding("UTF-8");
		
		//입력받은 데이터
		String mname = request.getParameter("mname");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mphone = request.getParameter("mphone");
				
		//DTO객체화
		misroomDTO dto = new misroomDTO(0, mname, mid, mpw, mphone);
				
		//통신확인
		System.out.println(dto.toString());
				
		//결과제어
		boolean result = misroomDao2.getInstance().signup(dto);
				
		if(result) {System.out.println("회원가입성공");}
		else{System.out.println("회원가입 실패");}
						
	}

}
