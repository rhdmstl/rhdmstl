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

import model.Dao.memberDao;
import model.Dao.productDAO;
import model.Dto.cartDTO;

@WebServlet("/product/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청
		int mno = memberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		//2.디비
		ArrayList<cartDTO> list = new productDAO().getcart(mno);
		JSONArray array = new JSONArray();
		//3.형변환
		for(cartDTO dto : list) {
			JSONObject object = new JSONObject();
			object.put("cartno",dto.getCartno());
			object.put("pstno",dto.getPstno());
			object.put("pname",dto.getPname());
			object.put("pimg",dto.getPimg());
			object.put("pprice",dto.getPprice());
			object.put("pdiscount",dto.getPdiscount());
			object.put("pcolor",dto.getPcolor());
			object.put("psize",dto.getPsize());
			object.put("amount",dto.getAmount());
			array.add(object);
		}
		//4.응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
	}

	//스크립트에서 정보를 받아옴
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청
		request.setCharacterEncoding("UTF-8");
		//선택한 제품의 옵션을 받음
		String data = request.getParameter("data");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = memberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		System.out.println("요청 : "+data+pno);
		//문자열 - json으로 형변환
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray)parser.parse(data);
			System.out.println("형변환 확인"+array);
			//옵션별 반복문 (계속 형변환해야해서 향샹된 반복문 사용못함)
			for(int i = 0 ; i < array.size() ; i++) {
				JSONObject object = (JSONObject)array.get(i);
				System.out.println("반복문 확인"+object.toString());
				//순서대로 객체 꺼내기
				System.out.println(object.get("psize"));
				System.out.println(object.get("amount"));
				System.out.println(object.get("pcolor"));
				System.out.println(object.get("mno"));
				System.out.println("모양확인"+object);
				//디비 처리  json객체.get(키) => 값 호출
					//오브젝트에 담긴거 꺼내오기
				String psize = (String)object.get("psize");
				System.out.println("오브젝트 확인1"+psize);
				int amount = Integer.parseInt(String.valueOf(object.get("amount")));	//String.valueOf = 오브젝트를 찍었을때 큰따옴표의 차이(있어야함) 메소드로 스트링 타입으로 변환
				System.out.println("오브젝트 확인1"+amount);
				String pcolor = (String)object.get("pcolor");
				System.out.println("오브젝트 확인1"+pcolor);
				boolean result = new productDAO().setcart(pno ,psize,amount, pcolor , mno);
				
				//응답 하나라도 실패하면
				if(result == false) {response.getWriter().print(result); return;}
			}
		} catch (Exception e) {System.out.println("형변환 오류"+e);}
				//3.응답
				response.setCharacterEncoding("UTF-8");
				//옵션을 다 저장한 경우
				response.getWriter().print("true");
		
			/*
			 	JSON				강제형변환[부모가 자식]
			 	"" : 문자열 string	(String) 클래스가 동일해서 강제변환 가능
			 	숫자 : long			(String) 메소드를 이용해야 형변환이 가능[ String.valueOf ]
			 */
		
		
		
	}

}
