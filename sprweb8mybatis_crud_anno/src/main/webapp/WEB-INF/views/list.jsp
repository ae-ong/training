<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- jstl -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>* 회원 정보 *</h3>
<a href="insert.html">추가</a><!-- insert는 포워딩, insert.html은 리다이렉트 -->
<br/>
<table border="1">
	<tr>
		<th>번호</th><th>이름</th><th>주소</th><th>수정/삭제</th>
	</tr>
	<c:forEach var="data" items="${datas }">
		<tr>
			<td>${data.num }</td>
			<td>${data.name }</td>
			<td>${data.addr }</td>
			<td>
				<a href="update?num=${data.num}">수정</a>/
				<a href="delete?num=${data.num}">삭제</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br/>
<a href="index.html">메인으로</a>
</body>
</html>