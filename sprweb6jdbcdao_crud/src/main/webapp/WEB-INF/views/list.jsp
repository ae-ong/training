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
<h3>회원 목록(@MVC : JdbcDaoSupport 방법)</h3>
<c:if test="${fn:length(list) >0}">
<table border="1">
	<tr><th>아이디</th><th>회원명</th></tr>
	<c:forEach var="m" items="${list}">
		<tr>
		<td>${m.id}</td>
		<td><a href="detail?id=${m.id}">${m.name}</a></td>
		</tr>
	</c:forEach>
</table>
</c:if>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
건수 : ${fn:length(list) }
<br/>
</body>
</html>