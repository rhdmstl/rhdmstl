package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Dao.productDAO;
import model.Dto.pcategoryDTO;

/**
 * Servlet implementation class pcategory
 */
@WebServlet("/admin/pcategory")
public class pcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		
		//2.db처리
		ArrayList<pcategoryDTO> list = new productDAO().getpcategory();
		//3.리스트 -> 제이슨 변환
		JSONArray array = new JSONArray();
		for(pcategoryDTO dto : list) {
			JSONObject object = new JSONObject();
			object.put("pcno", dto.getPcno());
			object.put("pcname", dto.getPcname());
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청
	    request.setCharacterEncoding("UTF-8");
	    String pcname = request.getParameter("pcname");
	    // 2. dao 처리
	    boolean result = new productDAO().setpcategory(pcname); // 싱글톤객체 사용하지 않을경우 메소드 호출방식
	    // 3. 응답
	    response.getWriter().print(result);
	    
	}

}
