<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 목록(@MVC : 전통적 방법)</h3>
<table border="1">
	<tr><th>코드</th><th>품명</th><th>수량</th><th>단가</th></tr>
	<c:forEach var="data" items="${datas}">
		<tr>
		<td>${data.code}</td>
		<td>${data.sang}</td>
		<td>${data.su}</td>
		<td>${data.dan}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>