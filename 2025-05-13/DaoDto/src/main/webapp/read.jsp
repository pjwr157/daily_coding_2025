<%@page import="com.peisia.db.Dto2"%>
<%@page import="com.peisia.db.Dao4"%>
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
String no=request.getParameter("no");

Dao4 dao=new Dao4();
Dto2 d=dao.read(no);
%>

<%=d.no%>
<%=d.title%>
<%=d.id%>
<%=d.text%>

</body>
</html>