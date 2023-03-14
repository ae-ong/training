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
<table border="1">
	<tr><th>사번</th><th>직원명</th><th>부서명</th><th>직급</th>
	<c:forEach var="data" items="${jdatas}">
	<tr>
	<td>${data.jikwon_no}</td>
	<td>${data.jikwon_name}</td>
	<td>${data.buser_name}</td>
	<td>${data.jikwon_jik}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>