<%@page import="com.peisia.hello.Cat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page errorPage="error.jsp" %>    <!-- 이 JSP에서 예외가 발생하면 이동할 대상 JSP -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Insert title here</title>
</head>
<body>

<%
	//Cat cat = new Cat();
	Cat cat = null;
	System.out.println("콘솔로찍기:"+cat.name);
%>

<%=cat.name %>

</body>
</html>