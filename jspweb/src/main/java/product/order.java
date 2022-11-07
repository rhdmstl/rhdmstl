package product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Dao.memberDao;
import model.Dao.productDAO;
import model.Dto.orderDto;

@WebServlet("/product/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public order() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data"); //결제할 제품
		String oinfo = request.getParameter("oinfo"); //받는사람
		int mno = memberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		System.out.println("**서블릿1 : "+data);
		System.out.println("**서블릿2 : "+oinfo);
		
		//문자열 타입 JSON형식 -> JSON타입 형변환
		JSONParser parser = new JSONParser();
		
		try {
			//1.객체 [회원정보 문자열 -> object]
			JSONObject jsonObject = (JSONObject)parser.parse(oinfo);
			//2.리스트 [결제할 제품 리스트 문자열 -> array]
			JSONArray jsonArray = (JSONArray)parser.parse(data);
			
			//받는 사람정보
			String oname = String.valueOf(jsonObject.get("oname"));
			String ophon = String.valueOf(jsonObject.get("ophon"));
			String oaddress = String.valueOf(jsonObject.get("oaddress"));
			String orequest = String.valueOf(jsonObject.get("orequest"));
			
			ArrayList<orderDto>list = new ArrayList<>();
			//반복문[orderDto -> dao처리]
			for(int i = 0 ; i < jsonArray.size() ; i++) {
				//주문상세
				JSONObject object = (JSONObject)jsonArray.get(i);
				int odamount = Integer.parseInt(String.valueOf(object.get("amount")));
				int pprice = Integer.parseInt(String.valueOf(object.get("pprice")));
				Float pdiscount = Float.parseFloat(String.valueOf(object.get("pdiscount")));
					int odprice = Math.round(pprice-(pprice*pdiscount));
				int pstno = Integer.parseInt(String.valueOf(object.get("pdiscount")));
				//주문 dto생성
				orderDto dto = new orderDto(0, oname, ophon, oaddress, orequest, null, mno, 0, odamount, odprice, 0, pstno);
				System.out.println("**3"+dto.toString());
				//list
				list.add(dto);
				System.out.println("디티오4 : "+list);
			}//for문
			//주문 DB처리
			boolean result = new productDAO().setOrder(list);
			//db응답
			response.getWriter().print(result);
			System.out.println("디비결과5 : "+result);
		} catch (ParseException e) {System.out.println("**형변환 오류6"+e);}
		response.getWriter().print("false");
	}	
}
