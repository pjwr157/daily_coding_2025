package com.peisia.q13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletHelloWorld
 */
//Java 언어로 만든 웹서버 프로그램이자 사용자의 웹 요청을 받아서 처리하는 자바 클래스
@WebServlet("/ServletHelloWorld")	// "이 자바 클래스는 서블릿이다. 그리고 이 URL로 호출된다."
public class ServletHelloWorld extends HttpServlet {	// 클래스 선언 + 상속
	private static final long serialVersionUID = 1L;	// 자바가 내부적으로 클래스 버전 관리할 때 사용되는 기술적 코드
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHelloWorld() {		// 서블릿이 처음 실행될 때 한 번 호출되는 초기화용 생성자함수
        super();						// 부모 클래스(HttpServlet)의 생성자 호출
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
