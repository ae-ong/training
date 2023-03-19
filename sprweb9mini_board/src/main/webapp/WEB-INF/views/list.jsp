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
<body>
	<h3>* 미니 게시판(전통적 방법) *</h3>
	<a href="insert">글쓰기</a>
	<br/>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="data" items="${list }">
			<tr align="center">
				<td >${data.num }</td>
				<td><a href="detail?num=${data.num }" >${data.title }</a></td>
				<td>${data.author }</td>
				<td>${data.readcnt }</td>
			</tr>
		</c:forEach>
		<!-- 검색 작업 추가 -->
		<tr>
			<td colspan="4">
				<form action="/search" method="get">
					검색 대상 :
					<select name="searchName">
						<option value="author" selected>작성자</option>
						<option value="title">제목</option>
					</select> <input type="text" name="searchValue">
					<input type="submit"  value="검색">
				</form>
			</td>
		</tr>
	</table>
	<br/>
	<a href="index.html">메인으로</a>
	
</body>
</html>