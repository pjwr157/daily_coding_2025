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
String no=request.getParameter("no");

Dao dao=new Dao();
Dto d=dao.read(no);
%>

<%=d.no%>
<%=d.id%>
<%=d.title%>
<hr>
<%=d.text%>

<a href="ServletDel?no=<%=no%>">삭제</a>
<a href="edit.jsp?no=<%=no%>">수정</a>
<a href="list.jsp">리스트로</a>

</body>
</html>