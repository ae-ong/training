<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../resources/css/board.css">
</head>
<body>
<body>
	<h3>* 게시판(@MVC + MyBatis) *</h3>
	<table>
		<tr>
		<td>
		[<a href="list?page=1">최근목록</a>]&nbsp;
		[<a href="insert">글쓰기</a>]
		</td>
		</tr>
	</table>
	<table>
		<tr style="background-color: silver;">
			<th>번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="b" items="${data }">
		<!-- 댓글 들여쓰기 -->
		<c:set var="tab" value=""/>
		<c:forEach var="n" begin="1" end="${b.nested}">
			<c:set var="tab" value="${tab}&nbsp;&nbsp;"/>
		</c:forEach>
			<tr align="center">
				<td >${b.num }</td>
				<td align="left">${tab}<a href="detail?num=${b.num }&page=${page}" >${b.title }</a></td>
				<td>${b.name }</td>
				<td>${b.bdate }</td>
				<td>${b.readcnt }</td>
			</tr>
		</c:forEach>
		<!-- paging -->
		<tr align="center">
			<td colspan="5">
			<c:forEach var="psu" begin="1" end="${pagesu }">
				<c:if test="${psu == page }">
				<b>${psu}</b>
				</c:if>
				<c:if test="${psu != page }">
				<a href="list?page=${psu}">${psu}</a>
				</c:if>
			</c:forEach>
			</td>
		</tr>
		<!-- 검색 작업 추가 -->
		<tr align="center">
			<td colspan="5">
			<br/>
				<form action="/search" method="get">
					검색 대상 :
					<select name="searchName">
						<option value="name" selected>작성자</option>
						<option value="title">글제목</option>
					</select> <input type="text" name="searchValue">
					<input type="submit"  value="검색">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>