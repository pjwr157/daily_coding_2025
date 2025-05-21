<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
  request.setCharacterEncoding("UTF-8");

  String boardNum = request.getParameter("board_num");
  String content = request.getParameter("content");
  String writerId = (String) session.getAttribute("loginId");

  if (writerId == null || boardNum == null || content == null ||
      writerId.trim().equals("") || boardNum.trim().equals("") || content.trim().equals("")) {
    out.println("<script>alert('댓글 작성에 필요한 정보가 부족합니다.'); history.back();</script>");
    return;
  }

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    String sql = "INSERT INTO comment_board (board_num, writer_id, content, reg_date) VALUES (?, ?, ?, NOW())";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, Integer.parseInt(boardNum));
    pst.setString(2, writerId);
    pst.setString(3, content);

    int result = pst.executeUpdate();
    pst.close();
    con.close();

    if (result == 1) {
      response.sendRedirect("read.jsp?num=" + boardNum);
    } else {
      out.println("<script>alert('댓글 등록 실패'); history.back();</script>");
    }
  } catch (Exception e) {
    e.printStackTrace();
    out.println("<script>alert('에러 발생: 댓글 등록 실패'); history.back();</script>");
  }
%>
