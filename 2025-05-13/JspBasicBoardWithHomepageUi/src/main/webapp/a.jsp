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

	//로그인을 성공해서 id를 
	String loginedId = "kitty";
	session.setAttribute("loginedId",loginedId);


%>

<a href="b.jsp">b페이지로</a>
</body>
</html>