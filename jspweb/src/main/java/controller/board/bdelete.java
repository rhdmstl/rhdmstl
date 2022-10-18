package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.boardDao;
import model.Dto.BoardDto;

@WebServlet("/board/bdelete")
public class bdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDto dto = boardDao.getInstance().getboard(bno);
		
		//DAO 처리
		boolean result = boardDao.getInstance().delete(bno);
		if(result) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
			File file = new File(deletepath);;
			if(file.exists())file.delete();
		}      
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
