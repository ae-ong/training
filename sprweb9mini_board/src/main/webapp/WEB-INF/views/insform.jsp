<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 글 쓰기 **</p>
<form action="insert" method="post">
작성자 : <input type="text" name="author"><br/>
글제목 : <input type="text" name="title"><br/>
글내용 : <textarea row="5" cos="60" name="content"></textarea><br/>
<input type="submit" value="저장">
</form>
</body>
</html>