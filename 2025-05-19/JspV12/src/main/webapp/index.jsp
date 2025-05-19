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
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	session.setAttribute("idKey",id);
	session.setMaxInactiveInterval(30);
	
%>

<form method="post" action="index2.jsp">
	1.가장 좋아하는 계절은?<br>
	<input type=radio name="season" value="봄">봄
	<input type=radio name="season" value="여름">여름
	<input type=radio name="season" value="가을">가을
	<input type=radio name="season" value="겨울">겨울
	<input type=submit>
</form>


</body>
</html>



