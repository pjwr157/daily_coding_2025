<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	System.out.println("id: "+id);
	System.out.println("pw: "+pw);
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		System.out.println("성공");
		
		stmt=con.createStatement();
		
		rs = stmt.executeQuery("SELECT * FROM member where id='"+id+"'");
		rs.next();
		String pwTemp = rs.getString("pw");
		System.out.println("pwTemp: "+pwTemp);
		
		if(pw.equals(pwTemp)){
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		stmt.close();
		con.close();
		
	} catch (SQLException e){	
		System.out.println("sql 익셉션:"+e);
	} catch (Exception e) {	
		System.out.println("익셉션:"+e);
	}	
	response.sendRedirect("index.html");
%>
</body>
</html>