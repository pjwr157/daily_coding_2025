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
//글번호 no가 get 방식으로 넘어 왔다고 가정
String no = request.getParameter("no");
//글 가져오기
Dao dao = new Dao();
Dto dto = dao.read(no);
%>



<form action="ServletEdit">
	<input type="hidden" name="no" value="<%=no%>"> 
	<input name="title" value="<%=dto.title%>">
	<input name="text" value="<%=dto.text%>">
	<input type="submit" value="수정">
</form>
<a href="list.jsp">리스트로</a>
</body>
</html>