<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
	<%-- //id:<input name="id" value="${userVO.id}"> --%>
	id:<input name="id" value="${user.id}">
	pw:<input name="password" value="${user.password }">
	<button>로그인</button>
</form>
</body>
</html>