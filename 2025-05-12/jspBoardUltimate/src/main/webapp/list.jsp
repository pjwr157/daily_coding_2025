<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글 목록</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
  <h1>📄 전체 글 목록</h1>

  <!-- 검색 폼 -->
  <form action="list.jsp" method="get" class="search-box">
    <input type="text" name="keyword" value="<%= request.getParameter("keyword") == null ? "" : request.getParameter("keyword") %>" placeholder="Search title or content">
    <input type="submit" value="Search">
  </form>

  <!-- 글 목록 테이블 -->
  <table class="post-table">
    <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<%
  String keyword = request.getParameter("keyword");
  if (keyword == null) keyword = "";

  int currentpage = 1;
  int pageSize = 10;
  if (request.getParameter("page") != null) {
	  currentpage = Integer.parseInt(request.getParameter("page"));
  }
  int offset = (currentpage - 1) * pageSize;

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    // 게시글 가져오기
    String sql = "SELECT * FROM board WHERE title LIKE ? OR content LIKE ? ORDER BY num DESC LIMIT ?, ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, "%" + keyword + "%");
    pst.setString(2, "%" + keyword + "%");
    pst.setInt(3, offset);
    pst.setInt(4, pageSize);
    ResultSet rs = pst.executeQuery();

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
    pst.close();

    // 전체 글 수 구하기 (페이징용)
    String countSql = "SELECT COUNT(*) FROM board WHERE title LIKE ? OR content LIKE ?";
    PreparedStatement countPst = con.prepareStatement(countSql);
    countPst.setString(1, "%" + keyword + "%");
    countPst.setString(2, "%" + keyword + "%");
    ResultSet countRs = countPst.executeQuery();
    countRs.next();
    int totalPosts = countRs.getInt(1);
    int totalPages = (int)Math.ceil(totalPosts / (double)pageSize);

    countRs.close();
    countPst.close();
    con.close();

    // 페이지 번호 출력
    out.println("<div class='pagination'>");
    for (int i = 1; i <= totalPages; i++) {
      String link = "list.jsp?page=" + i + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
      if (i == currentpage) {
        out.println("<strong>" + i + "</strong> ");
      } else {
        out.println("<a href='" + link + "'>" + i + "</a> ");
      }
    }
    out.println("</div>");
  } catch (Exception e) {
    e.printStackTrace();
  }
%>
  </table>

  <p><a class="btn-write" href="write.jsp">➕ 글쓰기</a></p>

</body>
</html>
