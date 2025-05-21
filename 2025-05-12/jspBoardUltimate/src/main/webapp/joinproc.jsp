<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
  request.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  String name = request.getParameter("name");

  if (id == null || pw == null || name == null ||
      id.trim().equals("") || pw.trim().equals("") || name.trim().equals("")) {
    out.println("<script>alert('모든 항목을 입력해주세요.'); history.back();</script>");
    return;
  }

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");

    // 아이디 중복 체크
    PreparedStatement checkPst = con.prepareStatement("SELECT id FROM members WHERE id = ?");
    checkPst.setString(1, id);
    ResultSet checkRs = checkPst.executeQuery();
    if (checkRs.next()) {
      out.println("<script>alert('이미 존재하는 아이디입니다.'); history.back();</script>");
      return;
    }
    checkRs.close();
    checkPst.close();

    // 회원가입 처리
    PreparedStatement pst = con.prepareStatement("INSERT INTO members (id, pw, name, join_date) VALUES (?, ?, ?, NOW())");
    pst.setString(1, id);
    pst.setString(2, pw);
    pst.setString(3, name);

    int result = pst.executeUpdate();
    pst.close();
    con.close();

    if (result == 1) {
      out.println("<script>alert('회원가입 성공! 로그인해주세요.'); location.href='login.jsp';</script>");
    } else {
      out.println("<script>alert('회원가입 실패'); history.back();</script>");
    }
  } catch (Exception e) {
    e.printStackTrace();
    out.println("<script>alert('에러 발생: 가입 실패'); history.back();</script>");
  }
%>
