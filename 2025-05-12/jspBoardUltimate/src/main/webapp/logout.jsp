<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.*" %>
<%
  session.invalidate(); // 세션 전체 삭제 (로그아웃 처리)
  response.sendRedirect("index.jsp");
%>
