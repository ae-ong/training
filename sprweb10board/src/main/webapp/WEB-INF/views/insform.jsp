<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../resources/css/board.css">
<script type="text/javascript">
window.onload = function(){
	let btnIns = document.getElementById("btnIns");
	btnIns.addEventListener("click", checkData);
}

function checkData(){
	if(frm.name.value === ""){
		alert("작성자를 입력하시오");
		frm.name.focus();
		return;
	}
	if(frm.name.value === ""){
		alert("비밀번호를 입력하시오");
		frm.pass.focus();
		return;
	}
	//...
	
	frm.submit();
}
</script>
</head>
<body>
** 글 쓰기 **<p/>
<form action="update" method="post" name="frm">
<table style="width: 80%">
<tr>
<td>이름</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>암호</td>
<td><input type="text" name="pass"></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="mail"></td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" name="title" style="width: 99%"></td>
</tr>
<tr>
<td>내용</td>
<td><textarea rows="5" style="width: 99%" name="cont"></textarea></td>
</tr>
<tr>
<td colspan="2" style="text-align: center;">
<input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>">
<input type="button" value="등록" id="btnIns"/>
<input type="button" value="목록" onclick="location.href='list?page=1'"/>
</td>
</tr>
</table>
</form>
</body>
</html>