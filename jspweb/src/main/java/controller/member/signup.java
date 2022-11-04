package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.memberDao;
import model.Dto.memberDto;

@WebServlet("/member/signup")	//해당 클래스로 매칭(연결) URL설정 - [@WebServlet("URL정의")]
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public signup() { super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding( "UTF-8" );
		//입력받을 데이터
		String id = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mpwdconfirm = request.getParameter("mpwdconfirm");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		
		//주소 카카오우편 API
		String maddress1 = request.getParameter("maddress1");
		String maddress2 = request.getParameter("maddress2");
		String maddress3 = request.getParameter("maddress3");
		String maddress4 = request.getParameter("maddress4");
		
		String maddress = maddress1+","+maddress2+","+maddress3+","+maddress4;
		
		memberDto dto = new memberDto(0, id, mpw, mname, mphone, memail, maddress, null, 0);
		System.out.println(dto.toString());
		
		boolean result = memberDao.getInstance().singup(dto);
		
		
		if(result) {response.sendRedirect("/jspweb/member/login.jsp");}
		else {System.out.println("/jspweb/member/signup.jsp");}
		
	}

}

//request.getParameter -> html의 form 데이터를 요청할 수 있다
//단점은 name값만 가져올 수 있어서 변수명이 같아야 한다