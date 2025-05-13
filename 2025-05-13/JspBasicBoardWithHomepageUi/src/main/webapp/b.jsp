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
	String id = (String)session.getAttribute("loginedId");

	if(id != null){
		
	} else {
		response.sendRedirect("index.jsp");
	}
	// db 접속해서 id 정보가지고 포인트, 	

%>

<%= id %> 회원님 환영합니다.!!!

</body>
</html>