<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글 상세보기</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
<%
  String num = request.getParameter("num");
  if (num == null || num.trim().equals("")) {
    response.sendRedirect("list.jsp");
    return;
  }

  String title = "", content = "", writer = "", regDate = "";
  int hit = 0;

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    // 조회수 증가
    PreparedStatement hitPst = con.prepareStatement("UPDATE board SET hit = hit + 1 WHERE num = ?");
    hitPst.setInt(1, Integer.parseInt(num));
    hitPst.executeUpdate();
    hitPst.close();

    // 게시글 조회
    PreparedStatement pst = con.prepareStatement("SELECT * FROM board WHERE num = ?");
    pst.setInt(1, Integer.parseInt(num));
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
      title = rs.getString("title");
      content = rs.getString("content");
      writer = rs.getString("id");
      regDate = rs.getString("reg_date");
      hit = rs.getInt("hit");
%>
<h1><%= title %></h1>
<div class="post-meta">
  작성자: <%= writer %> | 작성일: <%= regDate %> | 조회수: <%= hit %>
</div>
<div class="post-content">
  <pre><%= content %></pre>
</div>

<div class="post-actions">
  <a href="modify.jsp?num=<%= num %>" class="btn-edit">✏️ 수정</a>
  <a href="delproc.jsp?num=<%= num %>" class="btn-delete" onclick="return confirm('정말 삭제하시겠습니까?');">🗑 삭제</a>
  <a href="list.jsp" class="btn-back">🔙 목록</a>
</div>

<hr>
<h3>💬 댓글</h3>
<div class="comment-section">
<%
      // 댓글 목록 조회
      PreparedStatement cmtPst = con.prepareStatement("SELECT * FROM comment_board WHERE board_num = ? ORDER BY comment_id ASC");
      cmtPst.setInt(1, Integer.parseInt(num));
      ResultSet cmtRs = cmtPst.executeQuery();
      while (cmtRs.next()) {
%>
  <div class="comment-item">
    <strong><%= cmtRs.getString("writer_id") %></strong> - <%= cmtRs.getString("reg_date") %><br>
    <div><%= cmtRs.getString("content") %></div>
  </div>
  <hr>
<%
      }
      cmtRs.close();
      cmtPst.close();
%>
</div>

<%
      if (session.getAttribute("loginId") != null) {
%>
  <form action="commentproc.jsp" method="post" class="comment-form">
    <input type="hidden" name="board_num" value="<%= num %>">
    <textarea name="content" rows="3" required placeholder="댓글을 입력하세요"></textarea><br>
    <input type="submit" value="댓글 작성">
  </form>
<%
      } else {
%>
  <p>댓글을 작성하려면 <a href="login.jsp">로그인</a>해주세요.</p>
<%
      }

      rs.close();
      pst.close();
      con.close();
    } else {
%>
  <p>해당 글을 찾을 수 없습니다.</p>
<%
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
</body>
</html>