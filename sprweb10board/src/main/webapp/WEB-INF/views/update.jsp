<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="../resources/css/board.css">
<script type="text/javascript">
window.onload = function(){
	document.querySelector("#btnUp").onclick = chkUpData;	
}

function chkUpData(){
	//alert("k");
	//입력자료 오류검사 생략
	if(upFrm.pass.value === ""){
		upFrm.pass.focus();
		alert("비밀번호를 입력하시오");
		return;
	}
	
	if(confirm("정말 수정할까요")){
		upFrm.submit();
	}
}
</script>
</head>
<body>
<!-- 비밀번호가 틀린 경우 메시지 출력 -->
<c:if test="${msg != null }">
<script type="text/javascript">
	(function msg(){
		alert("${msg}");
	})();
	location.href="list?page=${page}";
</script>
</c:if>
	<h3>* 글 수정 *</h3>
	<form action="update" method="post" name="upFrm">
	<input type="hidden" name="num" value="${data.num }"/>
	<input type="hidden" name="page" value="${page }"/>
		<table style="width: 80%">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${data.name }"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="mail" value="${data.mail }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 99%" value="${data.title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" style="width: 99%" name="cont" >${data.cont }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="button" value="수정" id="btnUp" />
					<input type="button" value="목록" onclick="location.href='list?page=${page}'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>