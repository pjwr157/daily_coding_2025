<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="index.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//ArrayList 끝에 커서 두고 ctrl + space 하면 힌트 팝업뜨고 고르면
	//알아서 상단에 jsp 지시자  import 삽입됨.
	ArrayList<String> ss = new ArrayList<>();
	ss.add("고양이");
	ss.add("개");
	ss.add("너굴맨");
	for(int i=0;i<3;i++){
%>
		<%=ss.get(i) %>
<%		
	}
%>
</body>
</html>