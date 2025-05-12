<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>글쓰기</title>
  <link rel="stylesheet" href="common.css">
</head>
<body>
  <h1>✍️ 새 글 작성</h1>

  <form action="writeproc.jsp" method="post" accept-charset="UTF-8">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" name="title" required>
    </div>
    <div class="form-group">
      <label for="id">작성자 ID</label>
      <input type="text" id="id" name="id" required>
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" name="content" rows="10" required></textarea>
    </div>
    <div class="form-actions">
      <input type="submit" value="등록하기" class="btn-submit">
      <a href="list.jsp" class="btn-cancel">취소</a>
    </div>
  </form>

</body>
</html>
