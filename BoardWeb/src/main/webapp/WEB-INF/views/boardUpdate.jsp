<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardupdate.jsp</title>
<body>
<h3>게시글 수정</h3>
<form action="boardUpdate">
	<input type="hidden" name="seq" value="${board.seq}"/>
	작성자<input name="writer" value="${board.writer}"><br>
	제목<input name="title" value="${board.title}"><br>
	내용<textarea rows="3" cols="20" name="content">${board.content}</textarea><br>
	<button>등록</button>
</form>
</body>
</html>