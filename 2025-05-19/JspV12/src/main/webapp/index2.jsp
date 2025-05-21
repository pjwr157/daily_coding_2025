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
	request.setCharacterEncoding("UTF-8");

	String season = request.getParameter("season");
	String id = (String)session.getAttribute("idKey");

%>

	<%=id %>님이 좋아하는 계절은 <%=season %> 입니다.


</body>
</html>



