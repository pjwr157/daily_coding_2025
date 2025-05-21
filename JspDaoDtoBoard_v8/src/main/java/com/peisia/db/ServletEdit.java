package com.peisia.db;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletEdit")
public class ServletEdit extends HttpServlet {
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