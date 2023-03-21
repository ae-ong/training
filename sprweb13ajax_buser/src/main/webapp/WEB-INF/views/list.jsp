<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function func(buser_no){
	//alert(buser_no);
	$("#showData").empty();
	$.ajax({
		type:"get",
		url:"jikwonlist?buser_no=" + buser_no,
		dataType:"json",
		success:function(jikwonData){
			//alert(jikwonData);
			let count = 0;
			let str = "<br/>** 근무 인원(JSON) **<br/>";
			str += "<table border='1'>";
			str += "<tr><th>사번</th><th>직원명</th><th>직급</th></tr>";
			let jlist = jikwonData.datas;
			$(jlist).each(function(idx, objArr){
				str += "<tr>";
				str += "<td>" + objArr["no"] + "</td>";
				str += "<td>" + objArr["name"] + "</td>";
				str += "<td>" + objArr["jik"] + "</td>";
				str += "</tr>";
				count++;
			});
			str += "<tr><td colspan='3'>인원수 : " + count + "명</td></tr>";
			str += "</table>";
			$("#showData").append(str);
		},
		error:function(){
			$("#showData").text("에러");
		}
	});
}
</script>
</head>
<body>
<% String id = (String)session.getAttribute("idkey"); %>
<%=id %>님 반갑습니다
<br/>
${sessionScope.idkey}님 반갑습니다<!-- el형식, if문 사용 필요 -->
<br/>
<a href="logout">로그아웃</a>

** 부서 목록 **<br/>
<table border="1">
	<tr>
	<td>부서번호</td><td>부서명</td><td>부서전화</td>
	</tr>
	<c:forEach var="b" items="${blist }">
		<tr>
		<td>${b.buser_no }</td>
		<td><a href="javascript:func(${b.buser_no })">${b.buser_name }</a></td>
		<td>${b.buser_tel }</td>
		</tr>
	</c:forEach>
</table>
<br/><br/>
<div id="showData"></div>
</body>
</html>