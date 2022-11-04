package product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.memberDao;
import model.Dao.productDAO;

@WebServlet("/product/plike")
public class plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public plike() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	////좋아요 취소 선택////////////////////////////////////////////////////////////////////////////////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 (세션은 쓸 수록 느려짐)
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = memberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		//db처리
		int result = new productDAO().setPlike(pno, mno);  
		//응답 true : 등록
		response.getWriter().print(result);
		System.out.println("서블릿"+result);
	}

}
