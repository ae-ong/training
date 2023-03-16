<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 자료 수정 **<br/>
<form action="update" method="post">
번호 : ${data.num}<br/>
<input type="hidden" name="num" value="${data.num }"/>
이름 : <input type="text"" name="name" value="${data.name }"><br/>
주소 : <input type="text"" name="addr" value="${data.addr }"><br/>
<br/>
<input type="submit" value="수정"/>
<input type="button" value="취소" onclick="history.back()"/>
</form>
</body>
</html>