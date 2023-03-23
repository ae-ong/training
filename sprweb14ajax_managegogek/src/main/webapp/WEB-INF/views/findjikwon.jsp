<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리고객 찾기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
window.onload = function(){
	$("#btnSubmit").on("click",function () {
		$("#showData").empty();
		$.ajax({
			type:"get",
			url:"jikwon?gogek_no="+$("#gogek_no").val()+"&gogek_name="+$("#gogek_name").val(),
			//dataType:"json",
			success:function(jikwon){
				let str = "<br/>근무 인원(JSON) **<br/>";
				if(jikwon.length === 0){
					str += "조건에 맞는 직원이 없습니다";
				}else{
				str += "<table border='1'>";
				str += "<tr><th>직원명</th><th>직급</th><th>부서명</th><th>부서전화</th></tr>";
				str += "<tr>";
				str += "<td>" + jikwon.jikwon_name + "</td>";
				str += "<td>" + jikwon.jikwon_jik + "</td>";
				str += "<td>" + jikwon.buser_name + "</td>";
				str += "<td>" + jikwon.buser_tel + "</td>";
				str += "</tr>";
				str += "</table>";
				}
				$("#showData").append(str);
			},
			error:function(){
				$("#showdata").append("에러");
			}
		});
	});
}
</script>
</head>
<body>
관리고객 찾기
고객번호 : <input type="text" name="gogek_no" id="gogek_no" value="1">
고객명 : <input type="text" name="gogek_name" id="gogek_name" value="이나라">
<input type="button" id="btnSubmit" value="검색">
<div id="showData">
</div>
</body>
</html>