package kh.s12.calendar.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kh.s12.calendar.main.model.CalendarService;
import kh.s12.calendar.main.model.CalendarVO;
import kh.s12.calendar.member.model.MemberVO;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/index.jsp";
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		CalendarService cservice = new CalendarService();
		PrintWriter out = response.getWriter();
		MemberVO mvo = (MemberVO) session.getAttribute("member");
		
		
		if(mvo != null) {
			int mid = mvo.getMid();
			
			ArrayList<CalendarVO> vo = new ArrayList<CalendarVO>();
			vo = cservice.callSchedule(mid);
			
			System.out.println("/main 컨트롤러");
			
			if(vo != null) {
				System.out.println("/main 스케줄 호출 성공!");
				map.put("list", vo);
			} else {
				System.out.println("/main 스케줄 호출 실패!");
				map.put("msg", "fail");
			}
			out.println(gson.toJson(map));
		}
		out.flush();
		out.close();
	}
}
