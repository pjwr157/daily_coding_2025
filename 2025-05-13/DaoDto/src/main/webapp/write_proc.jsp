<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao3"%>
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
			request.getParameter("title"),
			request.getParameter("id"),
			request.getParameter("text")
			);
	Dao3 dao = new Dao3();
	dao.write(dto);
%>

</body>
</html>