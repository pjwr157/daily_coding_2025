<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href='index3.jsp'>페이지1</a>
<a href='index4.jsp'>페이지2</a>

<%
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
%>

<%=x+y%>
