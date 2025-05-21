<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	<!-- 지시자 -->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="index.css">
<meta charset="UTF-8">		<!-- JSP 처리 단계와 HTML 처리 단계가 다르기 때문 -->
<title>Insert title here</title>
</head>
<body>
	<%
	for(int i=0; i<3;i++){
		%>
		<img src="cat.jpg" alt="고양이" id=cat> <!-- //이건 그냥 html -->
		<%
	}
	%>
</body>
</html>