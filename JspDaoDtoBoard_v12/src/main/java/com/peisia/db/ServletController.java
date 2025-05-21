package com.peisia.db;

import java.io.IOException;
import java.util.ArrayList;

import com.peisia.c.util.Cw;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class ServletController extends HttpServlet {
	String nextPage;
	Dao dao;
	
	@Override
	public void init() throws ServletException {
		dao = new Dao();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		Cw.wn("action:"+action);
		if(action!=null) {
			switch(action) {
			case "/del":	//했음
				Cw.wn("삭제");
				nextPage="/list.jsp";
				dao.del(request.getParameter("no"));				
				break;
			case "/write":	//했음
				Cw.wn("쓰기");
				nextPage="/list.jsp";
				Dto dto = new Dto(
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
				dao.write(dto);				
				break;
			case "/edit_insert"://했음
				Cw.wn("수정-insert");
				nextPage="/edit.jsp";
				request.setAttribute("post", dao.read(request.getParameter("no")));				
				break;
			case "/edit_proc"://했음
				Cw.wn("수정-proc");
				nextPage="/list.jsp";
				dao.edit(
						new Dto(
								request.getParameter("title"),
								request.getParameter("text")
								)
						,request.getParameter("no")
						);				
				break;
			case "/read":
				Cw.wn("읽기");
				nextPage="/read.jsp";
				Dto d=dao.read(request.getParameter("no"));
				request.setAttribute("post", d);
				break;
			case "/list"://todo
				Cw.wn("리스트");
				nextPage="/list.jsp";
				ArrayList<Dto> posts = dao.list();
				request.setAttribute("posts", posts);
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}
}