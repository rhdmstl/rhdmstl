package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import modle.DTO;
import modle.memberDao;

@WebServlet("/postlist")
public class postlist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public postlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<DTO> list = memberDao.getInstance().getpostlist();
		
		JSONArray array = new JSONArray();
		for(int i = 0 ; i < list.size() ; i++) {
			JSONObject object = new JSONObject();
				object.put("mno",list.get(i).getMno());
				object.put("mtitle",list.get(i).getMtitle());
				object.put("mcontent",list.get(i).getMcontent());
				object.put("mwtiter",list.get(i).getMwtiter());
				object.put("mpw",list.get(i).getMpw());
				object.put("mdate",list.get(i).getMdate());
				object.put("mview",list.get(i).getMview());
				
			array.add(object);
			System.out.println(array);
			memberDao dao = new memberDao();
		}
		response.getWriter().print(array);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
