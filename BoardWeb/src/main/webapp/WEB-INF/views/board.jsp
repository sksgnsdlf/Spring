<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	li { display:inline;}
</style>
<script>
	function go_page(p) {
		searchFrm.page.value = p;
		searchFrm.submit();
	}
</script>
</head>
<body>
<h3>게시판</h3>
<img src="./resources/images/Koala.jpg">
<c:if test="${not empty sessionScope.userName }"> 
	${userName }님 환영합니다.
	<input type="button" onclick="location='logout'" value="로그아웃">
</c:if>
<c:if test="${empty sessionScope.userName }"> 
	<a href="login">로그인</a>
</c:if>
검색조건: ${boardVO}
<form name="searchFrm">
    <input type="hidden" name="page" value="1">
	<select name="searchCondition">
		<option value="">선택
		<c:forEach items="${condMap}" var="option">
			<option value="${option.value}">${option.key}		
		</c:forEach>
	</select>
	<script>
		searchFrm.searchCondition.value='${boardVO.searchCondition}';
	</script>
	<input name="searchKeyword" value="${boardVO.searchKeyword}"/>
	<button>검색</button>
</form>
<form action="deleteBoard">
	<table border="1">
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>내용</th><th>작성일자</th><th>조회수</th>
	<th>첨부파일</th><th>삭제</th></tr>
		<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.seq }</td>
			<td><a href="boardUpdate/${board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.content }</td>
			<td>${board.regDate }</td>
			<td>${board.cnt }</td>
			<td>
				<a href="FileDown?seq=${board.seq }">${board.filename}</a>
			</td>
			<td><input type="checkbox" name="seqs" value="${board.seq }"></td>
		</tr>
		</c:forEach>
	</table>
	<button>선택삭제</button>
</form>
<my:paging paging="${paging}"/>
</body>
</html>