package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Dao.boardDao;
import model.Dto.BoardDto;

@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public list() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//검색처리
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		System.out.println(key);
		System.out.println(keyword);
		
		
		
		// 1. 요청페이징처리에 필요한 변수 요펑
		int listsize = Integer.parseInt(request.getParameter("listsize"));
		
		//전체페이지수  vs  검색된 게시물 수
		int totalsize = boardDao.getInstance().gettotalsize();
		
		int totalpage = 0;
		if(totalsize % listsize == 0) totalpage = totalsize / listsize;	// 나머지가 없으면
		else totalpage = totalsize / listsize+1;	// 나머지가 존재하면 나머지를 표시할 페이지+1
		
		System.out.println(totalpage);
		int page = Integer.parseInt(request.getParameter("page"));
		
		//페이지별 시작 게시물번호
		int startrow = (page-1)*listsize;
		
		//화며에 표시할 최대 버튼 수
		int btnsize = 5;	//버튼 5개씩 표시[ 몫 : 현재페이지가 최대버튼수 커지면 = 5베수]
		//버튼 시작
		int startbtn = ((page-1) / btnsize) *btnsize+1;
		//버튼 끝
 		int endbtn = startbtn+(btnsize-1);
 			//만약 endbtn 마지막 페이지보다 크면 마지막 버튼 번호는 마지막 페이지 번호
 		if(endbtn > totalpage) endbtn = totalpage;
 		
		/*
		 * 1. 1 페이지 경우 1 ( (1-1) / btnsize ) * btnsize + 1 = 1 2. 2 페이지 경우 1 ( (2-1) /
		 * btnsize ) * btnsize + 1 = 1 3. 3 페이지 경우 1 ( (3-1) / btnsize ) * btnsize + 1 =
		 * 1 3. 4 페이지 경우 1 ( (4-1) / btnsize ) * btnsize + 1 = 1 3. 5 페이지 경우 1 ( (5-1) /
		 * btnsize ) * btnsize + 1 = 1 3. 6 페이지 경우 6 ( (6-1) / btnsize ) * btnsize + 1 =
		 * 6
		 * 
		 * sb eb page 1~5 1 2 3 4 5 page 6~10 6 7 8 9 10 page 11~15 11 12 13 14 15 page
		 * 16~20 16 17 18 19 20
		 */
		
		//페이징 처리에 필요한 정보담는 JSONObject
		JSONObject boards = new JSONObject();
		//전체 체이지수 계산
		
		// 2. 전체 게시물 호출 vs 검색된 게시물 호출
		ArrayList<BoardDto> list = boardDao.getInstance().getlist(startrow,listsize,key,keyword);
		JSONArray array = new JSONArray();
		for(int i = 0 ; i <list.size() ; i++) {
			JSONObject object = new JSONObject();
			object.put("bno",list.get(i).getBno());
			object.put("btitle",list.get(i).getBtitle());
			object.put("bdate",list.get(i).getBdate());
			object.put("bview",list.get(i).getBview());
			object.put("mid",list.get(i).getMid());
			array.add(object);
		}
		boards.put("totalpage", totalpage);	//전체 페이지
		boards.put("data", array);			//게시물 리스트
		boards.put("startbtn", startbtn);	//버튼의 시작번호
		boards.put("endbtn", endbtn);		//버튼의 끝 번호
		boards.put("totalsize", totalsize);	//게시물 수
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
