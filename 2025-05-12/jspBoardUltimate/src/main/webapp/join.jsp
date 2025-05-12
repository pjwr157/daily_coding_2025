<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
  <h1>📝 회원가입</h1>
  <form action="joinproc.jsp" method="post" class="join-form">
    <div class="form-group">
      <label for="id">아이디</label>
      <input type="text" id="id" name="id" required>
    </div>
    <div class="form-group">
      <label for="pw">비밀번호</label>
      <input type="password" id="pw" name="pw" required>
    </div>
    <div class="form-group">
      <label for="name">이름</label>
      <input type="text" id="name" name="name" required>
    </div>
    <div class="form-actions">
      <input type="submit" value="가입하기" class="btn-submit">
      <a href="login.jsp" class="btn-secondary">로그인</a>
    </div>
  </form>
</body>
</html>
