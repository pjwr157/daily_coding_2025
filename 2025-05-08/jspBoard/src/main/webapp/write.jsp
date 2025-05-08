<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글쓰기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<hr>

<form action="writeproc.jsp" method="get">
	글제목:<input name="title"><br>
	글작성자id:<input name="id"><br>
	글내용:<textarea name="content" rows="5" cols="50"></textarea>
	<input type="submit" value="글쓰기">
</form>
<!-- 이 폼(form)에 입력한 데이터를 폼 아래의 '글쓰기' 버튼을 눌렀을 때 writeproc.jsp로 전송-->
<!-- writeproc.jsp?title=입력한제목&id=입력한ID&content=입력한내용 -->

</body>
</html>