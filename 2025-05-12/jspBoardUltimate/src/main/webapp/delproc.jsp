<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
  String num = request.getParameter("num");
  if (num == null || num.trim().equals("")) {
    out.println("<script>alert('잘못된 접근입니다.'); location.href='list.jsp';</script>");
    return;
  }

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    String sql = "DELETE FROM board WHERE num = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, Integer.parseInt(num));

    int result = pst.executeUpdate();
    pst.close();
    con.close();

    if (result == 1) {
      response.sendRedirect("list.jsp");
    } else {
      out.println("<script>alert('삭제 실패'); history.back();</script>");
    }
  } catch (Exception e) {
    e.printStackTrace();
    out.println("<script>alert('에러 발생: 삭제 실패'); history.back();</script>");
  }
%>
