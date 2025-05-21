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
	session.invalidate();	//"x" << "cat" 저장했던게 날아감
	response.sendRedirect("index.html");
	
%>



</body>
</html>