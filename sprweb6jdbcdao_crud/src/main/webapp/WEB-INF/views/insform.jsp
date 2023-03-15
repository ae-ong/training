<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 자료 추가  **<br/>
<sform:form commendName="command">
id : <sform:input path="id"/><br/>
pwd : <sform:input path="pwd"/><br/>
name : <sform:input path="name"/><br/>
<br/>
<input type="submit" value="추가">
<input type="reset" value="초기화">
</sform:form>
</body>
</html>