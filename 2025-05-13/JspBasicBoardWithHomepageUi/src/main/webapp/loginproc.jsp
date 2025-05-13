<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
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
	String loginedId = null;
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		String sql = String.format("select * from member where s_id='%s' and s_pw='%s'",id,pw);
		
// 		String sql = "insert into cat_board (title,content,id) values ('"
// 				+title
// 				+"','"
// 				+content
// 				+"','"
// 				+id
// 				+"')";
		System.out.println("==== 전송하려는 sql:" + sql);		
		ResultSet rs = st.executeQuery(sql);	// 글쓰기 sql 전송
		rs.next();
		loginedId = rs.getString("s_id");
		
	} catch (Exception e) {		
		e.printStackTrace();
	}

	session.setAttribute("loginedId", loginedId);
	
%>
테스트 로그인 된 id:<%=loginedId %>




</body>
</html>