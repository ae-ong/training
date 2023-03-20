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
	document.querySelector("#btnReply").onclick = chk;	
}

function chk(){
	//alert("k");
	//입력자료 오류검사 생략
	if(reFrm.name.value === ""){
		reFrm.name.focus();
		alert("작성자 이름을 입력하시오");
		return;
	}
	
	reFrm.submit();

}
</script>
</head>
<body>
<h3>* 댓글 쓰기 *</h3>
<form action="reply" method="post" name="reFrm">
	<input type="hidden" name="num" value="${data.num }"/>
	<input type="hidden" name="page" value="${page }"/>
	<input type="hidden" name="gnum" value="${data.gnum }"/>
	<input type="hidden" name="onum" value="${data.onum }"/>
	<input type="hidden" name="nested" value="${data.nested }"/>
	<input type="hidden" name="bip" value="<%=request.getRemoteAddr()%>"/>
	
		<table style="width: 80%">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" ></td>
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
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
				<c:set var="title" value="${data.title }"/>
				<td>
					<input type="text" name="title" style="width: 99%" value="[Re] : ${fn:substring(title, 0, 8) }">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" style="width: 99%" name="cont" ></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="button" value="등록" id="btnReply" />
					<input type="button" value="목록" onclick="location.href='list?page=${page}'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>