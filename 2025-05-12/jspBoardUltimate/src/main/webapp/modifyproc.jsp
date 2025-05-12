<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
  request.setCharacterEncoding("UTF-8");

  String num = request.getParameter("num");
  String title = request.getParameter("title");
  String content = request.getParameter("content");
  String id = request.getParameter("id");

  if (num == null || title == null || content == null || id == null ||
      num.trim().equals("") || title.trim().equals("") || content.trim().equals("") || id.trim().equals("")) {
    out.println("<script>alert('모든 항목을 입력해주세요.'); history.back();</script>");
    return;
  }

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    String sql = "UPDATE board SET title = ?, content = ?, id = ? WHERE num = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, title);
    pst.setString(2, content);
    pst.setString(3, id);
    pst.setInt(4, Integer.parseInt(num));

    int result = pst.executeUpdate();
    pst.close();
    con.close();

    if (result == 1) {
      response.sendRedirect("read.jsp?num=" + num);
    } else {
      out.println("<script>alert('수정 실패'); history.back();</script>");
    }
  } catch (Exception e) {
    e.printStackTrace();
    out.println("<script>alert('에러 발생: 수정 실패'); history.back();</script>");
  }
%>
