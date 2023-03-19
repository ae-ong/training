<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<h3>직원 자료 출력(@MVC + MyBatis)</h3>
	<table border="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직급</th>
			<th>부서명</th>
			<th>관리고객</th>
		</tr>
		<c:forEach var="data" items="${datas }">
			<tr align="center">
				<td>${data.jikwon_no }</td>
				<td><a href="ginfo?no=${data.jikwon_no }&name=${data.jikwon_name}" target="gogekinfo">${data.jikwon_name }</td>
				<td>${data.jikwon_jik }</td>
				<td>${data.buser_name }</a></td>
				<td>${data.jikwon_dam }</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<iframe name="gogekinfo" frameborder="0" width="1000px" height="300px">
	</iframe>
</body>
</html>