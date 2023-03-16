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
			<th>부서명</th>
			<th>직급</th>
			<th>입사시기</th>
		</tr>
		<c:forEach var="data" items="${datas }">
			<tr>
				<td>${data.jikwon_no }</td>
				<td>${data.jikwon_name }</td>
				<td><a href="binfo?bname=${data.buser_name }" target="buserinfo">${data.buser_name }</a></td>
				<td>${data.jikwon_jik }</td>
				<td>${data.jikwon_ibsail.substring(0,4) }년 
				<c:choose>
					<c:when test="${data.jikwon_ibsail.substring(5,7) < 4}">1사분기</c:when>
					<c:when test="${data.jikwon_ibsail.substring(5,7) < 7}">2사분기</c:when>
					<c:when test="${data.jikwon_ibsail.substring(5,7) < 10}">3사분기</c:when>
					<c:when test="${data.jikwon_ibsail.substring(5,7) < 13}">4사분기</c:when>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="5">
		인원수 : ${fn:length(datas) }
		</td>
		</tr>
		<!-- 검색 작업 추가 -->
		<tr>
			<td colspan="5">
				<form action="/search" method="get">
					부서별 자료보기 : 
					<select name="searchValue">
						<option value="all" >전체</option>
						<c:forEach var="buser" items="${bdatas }" >
							<option value="${buser.buser_name }">${buser.buser_name }</option>
						</c:forEach>
					</select> <input type="submit" value="검색">
				</form>
			</td>
		</tr>
	</table>
	<hr/>
	부서정보 : <br/>
	<iframe name="buserinfo" frameborder="0" width="1000px" height="300px">
	</iframe>
</body>
</html>