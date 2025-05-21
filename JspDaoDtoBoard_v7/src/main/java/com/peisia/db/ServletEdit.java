package com.peisia.db;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dto dto = new Dto(
				request.getParameter("title"),
				request.getParameter("text")
				);
		Dao dao = new Dao();
		dao.edit(dto,request.getParameter("no"));
		response.sendRedirect("list.jsp");
	}
}