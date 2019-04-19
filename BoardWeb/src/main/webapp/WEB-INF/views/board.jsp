<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
검색조건: ${boardVO}
<form>
	<select name="searchCondition">
		<option value="">선택
		<option value="TITLE" 
		<c:if test="${boardVO.searchCondition=='TITLE'}">selected</c:if>>제목
		<option value="CONTENT" 
		<c:if test="${boardVO.searchCondition=='CONTENT'}">selected</c:if>>내용
	</select>
	<script>
	searchFrm.searchCondition.value='${boardVO.searchCondition}';
	</script>
	<input name="searchKeyword" value="${boardVO.searchKeyword}"/>
	<button>검색</button>

</form>
<form action="deleteBoard">
	<table border="1">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일자</th><th>조회수</th><th>삭제</th></tr>
		<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.seq }</td>
			<td><a href="boardUpdateForm?seq=${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.content }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
			<td><input type="checkbox" name="seqs" value="${board.seq }"></td>
		</tr>
		</c:forEach>
	</table>
	<button>선택삭제</button>
</form>
</body>
</html>