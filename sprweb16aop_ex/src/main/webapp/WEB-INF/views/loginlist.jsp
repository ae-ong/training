<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 님 담당 직원 **<p/>
<%
if(session.getAttribute("name") != null){
	out.println("<a href='logout'>로그아웃</a>");
}
%>
<table border="1">
<tr>
	<th>사번</th><th>직원명</th><th>직급</th><th>부서명</th><th>부서전화</th><th>성별</th>
</tr>
<tr>
	<td>${list.jikwon_no }</td>
	<td>${list.jikwon_name }</td>
	<td>${list.jikwon_jik }</td>
	<td>${list.buser_name }</td>
	<td>${list.buser_tel }</td>
	<td>${list.jikwon_gen }</td>
</tr>
</table>
</body>
</html>