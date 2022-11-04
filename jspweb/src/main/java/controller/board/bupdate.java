package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Dao.boardDao;
import model.Dto.BoardDto;


@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버내 업로드 폴더 경로찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		
		MultipartRequest multi = new MultipartRequest( request,uploadpath,1024*1024*10,"UTF-8",new DefaultFileRenamePolicy());
		
		//요청
		String btitle = multi.getParameter("btitle"); //수정제목
		String bcontent = multi.getParameter("bcontent");	//수정내용
		String bfile= multi.getFilesystemName("bfile");	//수정파일
		
		//수정할 게시물의 번호
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		//수정되기전 세기물 정보 호출
		BoardDto dto = boardDao.getInstance().getboard(bno);
		
		//기존첨부파일 변경여부 판다
		boolean bfilechange = true;
		
		if(bfile == null) {
			//수정시 첨부파일 등록 없을 경우[기존첨부파일 호출
			bfile = boardDao.getInstance().getboard(bno).getBfile();
		} 
		
		//dao처리 [새로운 첨부파일이 있든없든 무조건 업데이트]
		boolean result = boardDao.getInstance().bupdate(bno,btitle,bcontent,bfile);
		if(result) {
			//업데이트 성공시 ㅣ기존파일 삭제
			if(bfilechange) {
				String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+dto.getBfile());
				File file = new File(deletepath);
				if(file.exists())file.delete();
			}
		}
		//결과 반환
		response.getWriter().print(result);
	}
}
