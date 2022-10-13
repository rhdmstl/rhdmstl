package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Dao.memberDao;
import model.Dto.memberDto;

@WebServlet("/member/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public info() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청[세션에 로그인 정보 호출]
		String mid = (String)request.getSession().getAttribute("mid");
		//2.db
		memberDto dto = memberDao.getInstance().getinfo(mid);
		//JS DTO 사용X
			//1.js가 이해할 수 있는 형식[JSON]
			//2.DTO -> JSON형식[자바에서 제공 안함 -> 외부 라이브러리 사용]
		JSONObject object = new JSONObject();
			object.put("mno",dto.getMno());
			object.put("mid",dto.getMid());
			object.put("mname",dto.getMname());
			object.put("mphone",dto.getMphone());
			object.put("memail",dto.getMemail());
			object.put("maddress",dto.getMaddress());
			object.put("mdate",dto.getMdate());
			object.put("mpoint",dto.getMpoint());
	
		//4.응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
