<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글 수정</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
<%
  String num = request.getParameter("num");
  if (num == null || num.trim().equals("")) {
    response.sendRedirect("list.jsp");
    return;
  }

  String title = "";
  String content = "";
  String id = "";

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    PreparedStatement pst = con.prepareStatement("SELECT * FROM board WHERE num = ?");
    pst.setInt(1, Integer.parseInt(num));
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
      title = rs.getString("title");
      content = rs.getString("content");
      id = rs.getString("id");
    } else {
      out.println("<script>alert('존재하지 않는 글입니다.'); location.href='list.jsp';</script>");
      return;
    }

    rs.close();
    pst.close();
    con.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
%>

  <h1>✏️ 글 수정</h1>
  <form action="modifyproc.jsp" method="post" accept-charset="UTF-8">
    <input type="hidden" name="num" value="<%= num %>">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" name="title" value="<%= title %>" required>
    </div>
    <div class="form-group">
      <label for="id">작성자 ID</label>
      <input type="text" id="id" name="id" value="<%= id %>" required>
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" name="content" rows="10" required><%= content %></textarea>
    </div>
    <div class="form-actions">
      <input type="submit" value="수정하기" class="btn-submit">
      <a href="read.jsp?num=<%= num %>" class="btn-cancel">취소</a>
    </div>
  </form>
</body>
</html>
