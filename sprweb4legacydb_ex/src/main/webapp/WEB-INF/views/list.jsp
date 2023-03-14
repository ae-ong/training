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
<h3>고객 목록(@MVC : 전통적 방법)</h3>
<table border="1">
	<tr><th>고객번호</th><th>고객명</th><th>고객전화</th>
	<c:forEach var="data" items="${datas}">
		<tr>
		<td align="center">${data.gogek_no}</td>
		<td align="center"><a href="damdang?gno=${data.gogek_no}">${data.gogek_name}</a></td>
		<td align="center">${data.gogek_tel}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>