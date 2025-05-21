<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 전용 서비스를 하는 페이지~~</h1>

<%
	String id = (String)session.getAttribute("x");

	if(id == null){
		response.sendRedirect("index.html");
	}

%>



<%= id %> 회원님 환영해요~



</body>
</html>



