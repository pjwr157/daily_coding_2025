<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Dto dto = new Dto(
			request.getParameter("title"), // 문자열 데이터임. Post방식, 무조건 url아님, 저장해둔 value 꺼내기
			request.getParameter("text")
			);
	Dao dao = new Dao();
	dao.edit(dto,request.getParameter("no"));
	response.sendRedirect("list.jsp");
%>

</body>
</html>