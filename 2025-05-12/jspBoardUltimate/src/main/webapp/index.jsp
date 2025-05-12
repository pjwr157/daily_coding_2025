<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to My Board</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
  <h1>📋 Welcome to My Bulletin Board 📋</h1>

  <!-- 검색 폼 -->
  <form action="list.jsp" method="get" class="search-box">
    <input type="text" name="keyword" placeholder="Search title or content">
    <input type="submit" value="Search">
  </form>

  <!-- 최근 글 목록 일부 표시 -->
  <table class="post-table">
    <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<%
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT num, title, id, reg_date FROM board ORDER BY num DESC LIMIT 5");

    while (rs.next()) {
      int num = rs.getInt("num");
      String title = rs.getString("title");
      String id = rs.getString("id");
      String regDate = rs.getString("reg_date");
%>
      <tr>
        <td><%= num %></td>
        <td><a href="read.jsp?num=<%= num %>"><%= title %></a></td>
        <td><%= id %></td>
        <td><%= regDate %></td>
      </tr>
<%
    }
    rs.close();
    st.close();
    con.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
  </table>

  <p><a class="btn-write" href="write.jsp">➕ 글쓰기</a></p>

</body>
</html>