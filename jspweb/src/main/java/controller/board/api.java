package controller.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class api
 */
@WebServlet("/board/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public api() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.공공데이터 포털 사용[안산시 약국]
			//url을 객체화하기[클래스사용 java.net]																						//perPage : 사용데이터 표시갯수
		URL url = new URL("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&serviceKey=DsXRTZHu8xRmIrHnHiu%2Bwu8C8C%2BQXCIEo2ijc6zHJ1b5a%2FZND3h%2FQZq1jtI4LYIq9eUnADdEMQYxvrLghWTgug%3D%3D");
		
		//2.스트림 읽어오기 [읽어오기 위해 url을 만듬]
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
		//읽어오기
		String result = bf.readLine();	//모두 읽어오기
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
