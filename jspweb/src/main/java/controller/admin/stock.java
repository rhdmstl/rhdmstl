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
import model.Dto.stockDto;

@WebServlet("/admin/stock")
public class stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public stock() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //재고출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		System.out.println("서블릿저장요청"+pno);
		//디비처리
		ArrayList<stockDto> list = new productDAO().getstock(pno);
		//형변환
		JSONArray array = new JSONArray();
		for(stockDto dto : list) {
			JSONObject object = new JSONObject();
			object.put("psno", dto.getPsno());
			object.put("psize", dto.getPsize());
			object.put("pstno", dto.getPstno());
			object.put("pcolor", dto.getPcolor());
			object.put("pstock", dto.getPstock());
			array.add(object);
		}
		//반환
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		System.out.println("서블릿출력"+array);
	}
	
	//재고저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("UTF-8");
		String psize = request.getParameter("psize");	//사이즈
		int pno = Integer.parseInt(request.getParameter("pno"));	//번호
		String pcolor = request.getParameter("pcolor");		//색상
		int pstock = Integer.parseInt(request.getParameter("pstock"));	//재고
		//디비처리
		boolean result = new productDAO().setstock(psize , pno , pcolor , pstock);
		///결과
		response.getWriter().print(result);
		System.out.println("재고저장서블릿"+result);
	}

}
