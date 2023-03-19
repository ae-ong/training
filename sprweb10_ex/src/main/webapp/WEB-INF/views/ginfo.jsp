<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${jikwon_name }의 관리고객
<table border="1">
		<tr>
			<th>고객번호</th>
			<th>고객명</th>
			<th>성별</th>
			<th>나이</th>
			<th>전화</th>
		</tr>
		<c:forEach var="data" items="${g}">
			<tr align="center">
				<td>${data.gogek_no }</td>
				<td>${data.gogek_name }</td>
				<td>${data.gogek_gen }</td>
				<td>${data.gogek_nai }</td>
				<td>${data.gogek_tel }</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="5">
		인원수  : ${fn:length(g)}
		</td>
		</tr>
	</table>
</body>
</html>