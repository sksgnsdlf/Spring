<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
<h3>게시글등록</h3>
<form action="boardInsert" method="post" enctype="multipart/form-data">
	작성자<input name="writer"><br>
	제목<input name="title"><br>
	첨부파일<input type="file" name="uploadFile"><br>
	내용<textarea rows="3" cols="20" name="content"></textarea><br>
	<button>등록</button>
</form>
</body>
</html>