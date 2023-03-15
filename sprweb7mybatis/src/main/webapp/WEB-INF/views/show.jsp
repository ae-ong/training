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
	<h3>* 상품 정보(@MVC + MyBatis) *</h3>
	<table border="1">
		<tr>
			<th>code</th>
			<th>snag</th>
			<th>su</th>
			<th>dan</th>
		</tr>
		<c:forEach var="data" items="${datas }">
			<tr>
				<td>${data.code }</td>
				<td>${data.sang }</td>
				<td>${data.su }</td>
				<td>${data.dan }</td>
			</tr>
		</c:forEach>
		
		<!-- 검색 작업 추가 -->
		<tr>
		<td colspan="4">
		<form action="/search" method="get">
		상품명 : <input type="text" name="searchValue" placeholder="상품명 입력"/>
		<input type="submit" value="검색">
		</form>
		</td>
		</tr>
	</table>
	<br/>
	<a href="index.html">메인으로</a>
</body>
</html>