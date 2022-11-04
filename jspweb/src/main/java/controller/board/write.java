package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Dao.boardDao;
import model.Dao.memberDao;

@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public write() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * //세션호출 String mid = (String)request.getSession().getAttribute("mid"); //회원
		 * 아이디 -> 회원번호로 호출 int mno = memberDao.getInstance().getMno(mid);
		 * System.out.println(mno); //요청한 정보 호출 String btitle =
		 * request.getParameter("btitle"); String bcontent =
		 * request.getParameter("bcontent"); //dao호출 boolean result =
		 * boardDao.getInstance().write(btitle, bcontent,mno);
		 * 
		 * System.out.println(result); form 전송용 //if(result)
		 * {response.sendRedirect("list.jsp");} //else
		 * {response.sendRedirect("write.jsp");}
		 * 
		 * js용 response.getWriter().print(result);
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.첨부파일 [cos ,java에서 지원]
		// 1.cos빌드 추가
		// 2.HttpServletRequest : 첨부차일 지원X[소량의 문자만 지원]
		// 3.MultipartRequest : 첨부파일 지원 [대량의 문자지원]-post메소드만 지원
		// new MultipartRequest(1.요청방식, 2.파일저장경로, 3.최대용량범위, 4.인코딩타입, 5.기타(보안기능));
		// 1.저장경로[프로젝트 저장]
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload") ; // jspweb/폴더명
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				uploadpath, // 저장경로
				1024 * 1024 * 10, // 10mb
				"UTF-8", // 인코딩
				new DefaultFileRenamePolicy() // 업로드된 파일의 이름이 중복일 경우 자동 이름 변경
		);// 5개의 생성자 end
			// 해당 저장경로에 첨부파일 업로드

		// 나머지 데이터를 직접 요청
		String btitle = multi.getParameter("btitle");
		System.out.println(btitle);// 확인ㄴ
		String bcontent = multi.getParameter("bcontent");
		System.out.println(bcontent);// 확인

		// 어떤파일을 업로드 했는지 DB에 저장할 첨부파일된 경로/이름 호출
		String bfile = multi.getFilesystemName("bfile");
		System.out.println(bfile);
		// 회원번호
		int mno = memberDao.getInstance().getMno((String) request.getSession().getAttribute("mid"));
		System.out.println(mno);
		// db처리
		boolean result = boardDao.getInstance().write(btitle, bcontent, mno, bfile);
		//응답
		response.getWriter().print(result);
	}

}
