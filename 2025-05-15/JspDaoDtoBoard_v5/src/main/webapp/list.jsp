<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
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
글번호, 제목, 작성자<hr>


<%

String pageNum=request.getParameter("page");
if(pageNum==null){
	pageNum="1";
}

Dao dao=new Dao();

int totalPage = 0;

ArrayList<Dto> posts = null;
String searchWord=request.getParameter("word");
if(searchWord==null||searchWord.equals("null")){	// case1. 검색어가 없으면
	posts=dao.list(pageNum);
	totalPage = dao.getTotalPageCount();	//총 페이지 수 구하기
}else{					// case2. 검색어가 있으면
	posts=dao.listSearch(searchWord,pageNum);
	totalPage = dao.getSearchTotalPageCount(searchWord);	//총 페이지 수 구하기
}

for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
%>
<a href="write.jsp">쓰기</a>

<!-- 계산할것들: 페이지 수 : 3-->

글 수:

<%
//totalPage
for(int i=1;i<=totalPage;i=i+1){
%>

<a href="list.jsp?page=<%=i%>&word=<%=searchWord%>"><%=i%></a>

<%
}
%>

<form action="list.jsp">
	<input name="word">
	<input type="submit" value="검색">
</form>

<a href="list.jsp">list로</a>

</body>
</html>