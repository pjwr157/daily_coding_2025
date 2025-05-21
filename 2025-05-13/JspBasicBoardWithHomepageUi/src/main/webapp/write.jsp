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
<div id="box">
	<div id="top">
		<h1>야옹이네 홈페이지</h1>
	</div>
	<div id="mid">
		<div id="mid_left">
			<a href="reg.jsp">회원가입</a><br>
			<a href="login.jsp">로그인</a><br>
			<a href="list.jsp">자유 게시판</a><br>
		</div>
		<div id="mid_center">
			<form action="writeproc.jsp">
				글제목:<input name="title"><br>
				글작성자id:<input name="id"><br>
				글내용:<textarea name="content" rows="5" cols="50"></textarea>
				<input type="submit" value="글쓰기">
			</form>

		</div>
		<div id="mid_right">
			<img src="banner_right.jpg">
		</div>
	</div>
	<div id="bot">
		copyright peisia.com
	</div>
</div>



</body>
</html>