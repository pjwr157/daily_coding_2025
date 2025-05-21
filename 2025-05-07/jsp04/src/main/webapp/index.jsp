<%@page import="com.peisia.hello.Cat"%>

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
	Cat cat = new Cat();
%>

<%=cat.name %>

</body>
</html>