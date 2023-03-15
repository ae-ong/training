<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** 회원 상세 보기 **</h3>
아이디 : ${member.id }<br/>
비밀번호 : ${member.pwd }<br/>
회원명 : ${member.name }<br/>
등록일 : ${member.regdate }<br/>
<br/>
<a href="list">목록</a>&nbsp;&nbsp;
<a href="update?id=${member.id }">수정</a>&nbsp;&nbsp;
<a href="delete?id=${member.id }">삭제</a>

</body>
</html>