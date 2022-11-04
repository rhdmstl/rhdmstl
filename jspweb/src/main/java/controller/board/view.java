package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Dao.boardDao;
import model.Dto.BoardDto;


@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int bno = Integer.parseInt(request.getParameter("bno"));
		 * System.out.println(bno);
		 */
		
		//세션요청[세션(object) -> String -> int]
			//다형성 : 부모가 자식으로 강제 형변환 가능
		int bno = (Integer)request.getSession().getAttribute("bno");
		//DAO 처리
		BoardDto dto = boardDao.getInstance().getboard(bno);
		
		JSONObject object = new JSONObject();
			object.put("bno",dto.getBno());
			object.put("btitle",dto.getBtitle());
			object.put("bcontent",dto.getBcontent());
			object.put("mid",dto.getMid());
			object.put("bfile",dto.getBfile());
		
		//삭제 수정버튼을 활성화를 위한 식별변수 선먼
		//==/로그인으로 이한 세셔 ㄴ정보호풀
		String mid = (String)request.getSession().getAttribute("mid");
		if(mid != null && mid.equals(dto.getMid())) {
			object.put("btnaction", true);
		}
		//로그인한 새션과 현재 게시물의 작성자와 힐치하면
		response.setCharacterEncoding(mid);
		object.put("button", true);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
		System.out.println("뷰서블릿"+object);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
