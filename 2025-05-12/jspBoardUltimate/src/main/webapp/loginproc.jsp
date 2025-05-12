<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
  request.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pw = request.getParameter("pw");

  if (id == null || pw == null || id.trim().equals("") || pw.trim().equals("")) {
    out.println("<script>alert('아이디와 비밀번호를 모두 입력하세요.'); history.back();</script>");
    return;
  }

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
    String sql = "SELECT * FROM members WHERE id = ? AND pw = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, id);
    pst.setString(2, pw);

    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
      session.setAttribute("loginId", id);
      response.sendRedirect("index.jsp");
    } else {
      out.println("<script>alert('로그인 정보가 올바르지 않습니다.'); history.back();</script>");
    }

    rs.close();
    pst.close();
    con.close();
  } catch (Exception e) {
    e.printStackTrace();
    out.println("<script>alert('로그인 처리 중 오류 발생'); history.back();</script>");
  }
%>
