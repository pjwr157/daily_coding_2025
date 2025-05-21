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
<form action="ServletWrite">
	<input name="title" placeholder="제목">
	<input name="id" placeholder="작성자id">
	<input name="text" placeholder="내용">
	<input type="submit" value="쓰기">
</form>
</body>
</html>