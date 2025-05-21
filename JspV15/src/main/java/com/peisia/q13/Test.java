package com.peisia.q13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

//16번은; 서블릿 진입 시 특정사이트 강제 이동 처리
//	resp.sendRedirect("http://daum.net");
//  이거 끝임.
	
//17번은; out 객체를 받아서 cat을 브라우저에 출력
// PrintWriter out = resp.getWriter();	
// out.println("<h1>cat</h1>");	
	
//18번은; 서블릿과 세션 연습 완료.
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== 두 포스트");
		System.out.println("id: "+ req.getParameter("id"));
		System.out.println("pw: "+ req.getParameter("pw"));
	}

}