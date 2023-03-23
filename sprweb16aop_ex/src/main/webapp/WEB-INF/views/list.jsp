<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aop</title>
</head>
<body>
** 전체 직원 **<p/>
<table border="1">
<tr>
	<th>사번</th><th>직원명</th><th>직급</th><th>부서명</th><th>부서전화</th><th>성별</th>
</tr>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="j" items="${list }">
<tr>
	<td>${j.jikwon_no }</td>
	<td>${j.jikwon_name }</td>
	<td>${j.jikwon_jik }</td>
	<td>${j.buser_name }</td>
	<td>${j.buser_tel }</td>
	<td>${j.jikwon_gen }</td>
</tr>
</c:forEach>
</table>
</body>
</html>