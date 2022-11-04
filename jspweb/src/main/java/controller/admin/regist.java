package controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Dao.productDAO;
import model.Dto.prouctDTO;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public regist() {
        super();
        // TODO Auto-generated constructor stub
    }

    ///////////////////////////////////////////////////////////재퓸 출력 메소드//////////////////////////////////////////////////////
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//타입 : 1 [모두 출력] , 2 [개별출력]
		String type = request.getParameter("type");
		request.setCharacterEncoding("UTF-8");
		if(type.equals("1")) {
			String option = request.getParameter("option");
			///////////////////////////////////모든 제품 출력///////////////////////////
			ArrayList<prouctDTO> list = new productDAO().getproductlist(option);
			JSONArray array = new JSONArray();	//list - > json
			for(int i = 0 ; i < list.size() ; i++) {
				JSONObject object = new JSONObject();
				object.put("pno",list.get(i).getPno());
				object.put("pname",list.get(i).getPname());
				object.put("pcomment",list.get(i).getPcomment());
				object.put("pprice",list.get(i).getPprice());
				object.put("pdiscount",list.get(i).getPdiscount());
				object.put("pactive",list.get(i).getPactive());
				object.put("pimg",list.get(i).getPimg());
				object.put("pdate",list.get(i).getPdate());
				object.put("pcno",list.get(i).getPcno());
				array.add(object);
			}	//요청
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(array);
	///////////////////////////////////////////////////////////////////////
		}else if(type.equals("2")) {
	///////////////////////////////////개별 제품 출력///////////////////////////
			//요청
			int pno = Integer.parseInt(request.getParameter("pno"));
			System.out.println("서블렛2"+pno);
			//db처리
			prouctDTO dto = new productDAO().getProduct(pno);
			//dto -> json
			JSONObject object = new JSONObject();
			object.put("pno",dto.getPno());
			object.put("pname",dto.getPname());
			object.put("pcomment",dto.getPcomment());
			object.put("pprice",dto.getPprice());
			object.put("pdiscount",dto.getPdiscount());
			object.put("pactive",dto.getPactive());
			object.put("pimg",dto.getPimg());
			object.put("pdate",dto.getPdate());
			object.put("pcno",dto.getPcno());
			
			//응답
			response.getWriter().print(object);
		}
	}
	///////////////////////////////////////////////////////////제품수정[put]//////////////////////////////////////////////////////
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("풋 시작");
		MultipartRequest multi = new MultipartRequest( 
				request, // 요청방식
				request.getSession().getServletContext().getRealPath("/admin/pimg"), // jspweb/폴더명
				1024*1024*10,
				"UTF-8", // 인코딩
				new DefaultFileRenamePolicy() // 업로드된 파일의 이름이 중복일 경우 자동 이름 변경
		);// 5개의 생성자 end
			// 해당 저장경로에 첨부파일 업로드
		
		int pno = Integer.parseInt( multi.getParameter("pno") );	// 수정할 대상 
		System.out.println("수정풋"+pno);
		byte pactive = Byte.parseByte(multi.getParameter("pactive")); // 제품상태
		System.out.println("수정풋"+pactive);
		String pname = multi.getParameter("pname");		
		System.out.println("수정풋"+pname);
		String pcomment = multi.getParameter("pcomment");
		System.out.println("수정풋"+pcomment);
		int pprice = Integer.parseInt( multi.getParameter("pprice"));	
		System.out.println("수정풋"+pprice);
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		System.out.println("수정풋"+pdiscount);
		String pimg = multi.getFilesystemName("pimg"); 
		System.out.println("수정풋"+pimg);
		//수정대상
	    int pcno = Integer.parseInt(multi.getParameter("pcno"));
	    System.out.println("수정풋"+pcno);
	    
	    // * 기존첨부파일 변경 여부 판단 
	 	boolean bfilechange = true;
	 	prouctDTO dto = new productDAO().getProduct(pno);
	 	
	 // *. 수정시 첨부파일 등록 없을경우 [ 기존첨부파일 호출  ]
	 	if(pimg == null) {pimg = dto.getPimg(); bfilechange = false;}
	 	
	 	prouctDTO dto2 = new prouctDTO(pno, pname, pcomment, pprice, pdiscount, pactive, pimg, null, pcno);
	 	
	 	boolean result = new productDAO().updateProduct(dto2);
	 	
	 	//4.dao 처리 [ 업데이트 = 새로운 첨부파일 ]
	 	if(result && bfilechange) { deletefile(request.getSession(), dto.getPimg());}
	 	
	 	response.getWriter().print(result);
	 	System.out.println("수정"+result);
	}
	
	///////////////////////////////////////////////////////////제품삭제[delete]//////////////////////////////////////////////////
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//삭제할 제품버호 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		prouctDTO dto = new productDAO().getProduct(pno);
		
		//dao
		boolean result = new productDAO().deleteproduct(pno);
		if(result) {deletefile(request.getSession(), dto.getPimg());}
		//응답
		response.getWriter().print(result);
		System.out.println("삭제"+result);
	}
	
//////////////////////////////////////////5. 수정 및 삭제시 첨부파일 제거 메소드 [ file delete ]  //////////////////////////////////////////////
	public void deletefile( HttpSession session ,  String pimg ) {
		String deletepath = session.getServletContext().getRealPath("/admin/pimg/"+ pimg    );
		File file = new File( deletepath );
		if( file.exists() ) file.delete();   // 해당 경로에 존재하는 파일을 삭제
	}
	//////////////////////////////////////////////////////[제품 등록 메소드]///////////////////////////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//첨부파일 있을 경우
		MultipartRequest multi = new MultipartRequest( 
				request, // 요청방식
				request.getSession().getServletContext().getRealPath("/admin/pimg"), // jspweb/폴더명
				1024*1024*10,
				"UTF-8", // 인코딩
				new DefaultFileRenamePolicy() // 업로드된 파일의 이름이 중복일 경우 자동 이름 변경
		);// 5개의 생성자 end
			// 해당 저장경로에 첨부파일 업로드
		String pname = multi.getParameter("pname");		
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt( multi.getParameter("pprice") ) ;	
		float pdiscount = Float.parseFloat( multi.getParameter("pdiscount") );
		String pimg = multi.getFilesystemName("pimg"); 
		
		//pcno요청
		int pcno = Integer.parseInt(multi.getParameter("pcno"));
		prouctDTO dto = new prouctDTO(0, pname, pcomment, pprice, pdiscount, (byte)0,  pimg , null, pcno);
		
	    boolean result = new productDAO().setproduct(dto);
	    response.getWriter().print(result);
		
	}
}
