<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
  <h1>🔐 로그인</h1>
  <form action="loginproc.jsp" method="post" class="login-form">
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" id="id" name="id" required>
    </div>
    <div class="form-group">
      <label for="pw">비밀번호</label>
      <input type="password" id="pw" name="pw" required>
    </div>
    <div class="form-actions">
      <input type="submit" value="로그인" class="btn-submit">
      <a href="join.jsp" class="btn-secondary">회원가입</a>
    </div>
  </form>
</body>
</html>
