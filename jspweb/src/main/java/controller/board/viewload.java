package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Dao.boardDao;

@WebServlet("/board/viewload")
public class viewload extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public viewload() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청[클릭한 게시물의 번호 저장 = 백엔드]
		
		//*세션 랩서버에 저장할 수 있는 메모리공간
			//브라우저마다 할당[유저 개인별 웹서버 할당]
			//서버 종료되서나 시간타이머 브라우저가 아예 종료됐을때
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		HttpSession session = request.getSession();
		
		//클릭한 게시물 번호를 세션에 저장
		session.setAttribute("bno",bno);
		String mid = (String)request.getSession().getAttribute("mid");
		
		
		
		//24시간 내에 한번도 클릭한 적이 없으면 [세션이 없으면]
		if(session.getAttribute(bno+mid)==null){
			//현재 유저가 조회 한 기록 남기기
			request.getSession().setAttribute(bno+mid, true);
			request.getSession().setMaxInactiveInterval(60*60*24);
			
			//DAO조회수 증가
			boardDao.getInstance().bviewupdate(bno);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
