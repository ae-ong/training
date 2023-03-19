<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	document.querySelector("#btnList").onclick = function(){
		location.href="list";
	}
	document.querySelector("#btnUpdate").onclick = function(){
		if(confirm("정말 수정할까요?")){
			//입력자료 오류검사 생략
			frm.action="update";
			frm.method="post";
			frm.submit();
		}
	}
	document.querySelector("#btnDelete").onclick = function(){
		if(confirm("정말 삭제할까요?")){
			//입력자료 오류검사 생략
			frm.action="delete";
			frm.method="get";
			frm.submit();
		}
	}
}

</script>
</head>
<body>
<h3>* 상세보기 *</h3>
<form name="frm">
글번호 : ${board.num}<br/>
<input type="hidden" name="num" value="${board.num }">
작성자 : <input type="text" name="author" value="${board.author }"><br/>
글제목 : <input type="text" name="title" value="${board.title }"><br/>
글내용 : <textarea row="5" cols="50" name="content">${board.content }</textarea><br/>
작성일 : ${board.bwrite }<br/>
조회수 : ${board.readcnt }<br/>
<input type="button" value="목록" id="btnList">
<input type="button" value="수정" id="btnUpdate">
<input type="button" value="삭제" id="btnDelete">
</form>
</body>
</html>