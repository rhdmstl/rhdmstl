package controller.board;

import javax.websocket.OnOpen;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

//@WebServlet("/board/chating")	서블릿 URL만들기
@ServerEndpoint("/chating/{mid}")	//웹서버에 웹소켓 URL만들기 
//URL/{변수명}
public class chating {
	
	//서버소켓 들어온 클라이언소켓 명단 vector ---> hashtable  변경한 이유 [ 2개씩 저장할려고 ]
		//arraylist vs Vector [ 동기화x vs 동기화o ]
	public static Hashtable<Session ,String> clirnts = new Hashtable<>();
	
	
	@OnOpen //웹소켓 들어왔을때					//@PathParamr : 경로상의 변수 호출
	public void onOpen(Session session , @PathParam("mid") String mid) throws IOException {
		//접속한 클라이언트 저장[session : 클라이언트 소켓 = 접속된 유저]
		clirnts.put(session , mid);
					//키     : 값 -> 엔트리
		System.out.println(mid+"님이 접속했습니다");
		
		//접속했다고 다른사람에게 알리기
		for(Session s : clirnts.keySet()) {
			///map에 저장된 모든 key호출
			s.getBasicRemote().sendText(clirnts.get(s)+"님이 접속했습니다");
		}								//map.get(키) ->값 호출
	}
	
	@OnClose //웹소켓 나갓을때
	public void onClose(Session session) {
		//종료된 세션을 접속면단에서 제거
		clirnts.remove(session);	//map.객체명.remove(key) :해당 key의 엔트리삭제
	}
	
	
	@OnMessage //웹소켓 메세지왔을때							//서블렛이 아니라서 예외처리를 해야함[throws IOException]
	public void onMessage(Session session ,String msg) throws IOException {
		for(Session s : clirnts.keySet()) {
			//getBasicRemote 기본 컨트롤하는 리모컨같은거
			s.getBasicRemote().sendText(msg);
			
		}
	}

}
