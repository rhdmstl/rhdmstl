package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.BufferedServletInputStream;

/**
 * Servlet implementation class filedown
 */
@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드된 파일을 다운로드
		//1. 다운로드 할 파일명 요펑
		request.setCharacterEncoding("UTF-8");
		String bfile = request.getParameter("bfile");
		
		//2.경로+파일명으로 해당파일 위치 찾기
		String uploadpath = 
				"C:\\Users\\504\\git\\rhdmstl\\jspweb\\src\\main\\webapp\\upload\\"+bfile;
		//3.해당 경로의 파일을 객체화[java에서 파일클래스 = file]
		File file = new File(uploadpath);	//해당 경로에 존재하는 파일을 객체화 불러오기[해당 파일을 조작/메소드]
		
		//4.HTTP에서 지원하는 다운로드형식 메소드 [response] (필수아님 없어도 실행됨)
		response.setHeader("Content-Disposition",//다운로드형식 HML에서 지원[브라우저 차이잇음]
				"attachment;fileename="+URLEncoder.encode(bfile,"UTF-8") //파일다운로드시 명시된 파일명을
				); //URL경로에 한글이 있을 경우 URLEncoder.encode(데이터,"인코딩타입") 클래스사용
		//실제 파일 전송[외부와 데이터 통신전송(스트림) = 바이트단위]
			//1.파일의 내용물의 바이트로 모두 읽어온다- 객체생성
			//[입력]
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
			//2.파일의 바이트 길이만큼 배열선언
		byte[] bytes = new byte[(int)file.length()];
		
		//3.파일의 내용[바이트]읽어오기
		fin.read(bytes);	//읽어온 바이트를 바이트배열에 저장
		
			//4.출력 스트림 객체생성
		//읽어온 바이트배열을 출력한다 - HTTP로 출력하기위함 response.getOutputStream()
		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
		
		//배열에 존재하는 바이트 출력
		fout.write(bytes);	//바이트배열에 저장된 바이트를 모두 내보내기
		
			//스트림은 버퍼(전송시 사용되는 임시메모리 공간 = 대용량에서는 꼭 초기화해야함)
		fout.flush();//출력스트림 버처 초기화
		fin.close();//입력스트림 닫기
		fout.close();//출력스트림 닫기[closs하면 버퍼 초기화]
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
